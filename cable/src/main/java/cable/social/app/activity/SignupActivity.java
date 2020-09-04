package cable.social.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickResult;

import cable.social.app.Interface.SignUp_interface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.utility.GlobalClass;
import cable.social.app.utility.MyLoaders;
import de.hdodenhof.circleimageview.CircleImageView;

import java.util.HashMap;
import java.util.Random;


public class SignupActivity extends AppCompatActivity implements View.OnClickListener, IPickResult, SignUp_interface {
    private EditText edtusername, edtemail, edtpass, edtconfirmpass;

    private AppCompatButton btnRegister;
//    private AppCompatTextView txtLogin;
    MyLoaders myLoaders;
    private String refreshedToken;
    private static final String TAG = "LoginActivity";
    CircleImageView profile_civ;
    String ImagePath="";
    Boolean valid;

    ImageView Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
        findViews();
        myLoaders = new MyLoaders(getApplicationContext());
    }

    private void findViews() {
        edtusername = findViewById(R.id.edtusername);
        profile_civ = findViewById(R.id.profile_civ);
        edtusername = findViewById(R.id.edtuserrname);

        edtemail = findViewById(R.id.edtemail);
        edtpass = findViewById(R.id.edtpass);
        edtconfirmpass = findViewById(R.id.edtconfirmpass);
        btnRegister = (AppCompatButton) findViewById(R.id.btn_register);
//        txtLogin = (AppCompatTextView) findViewById(R.id.txt_login);
        Back = findViewById(R.id.signup_back);

        btnRegister.setOnClickListener(this);
//        txtLogin.setOnClickListener(this);
        profile_civ.setOnClickListener(this);
        Back.setOnClickListener(this);


        edtusername.setOnEditorActionListener(
                new EditText.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                                actionId == EditorInfo.IME_ACTION_DONE ||
                                event != null &&
                                        event.getAction() == KeyEvent.ACTION_DOWN &&
                                        event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                            if (event == null || !event.isShiftPressed()) {
                                // the user is done typing.

                                Log.d(TAG, "the user is done typing.");

                                return true; // consume.
                            }
                        }
                        return false; // pass on to other listeners.
                    }
                }
        );


        edtusername.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                if (edtusername.getText().toString().equals("")) {
//                    edtusername.setError("This field can not be blank");

                } else {
                    Log.d("Changed", "the user is done typing.");


                    checkUserName();
                }
            }
        });


    }

    private void checkUserName() {
        if (GlobalClass.isNetworkConnected(SignupActivity.this)) {

            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("customer_username", edtusername.getText().toString());

            WebapiCall webapiCall = new WebapiCall();
            webapiCall.checkUserEmail(SignupActivity.this, hashMap, this);

        } else {
            Toast.makeText(SignupActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }
    }

    public boolean Check_Data(View view) {

        if (TextUtils.isEmpty(edtusername.getText().toString().trim())) {
            //  myLoaders.showSnackBar(view, "Please Enter Email");
            myLoaders.showSnackBar(view, "Please Enter User First Name");
            return false;
        } else if (TextUtils.isEmpty(edtusername.getText().toString().trim())) {
            myLoaders.showSnackBar(view, "Please Enter Last Name");
            return false;
        } else if (!edtemail.getText().toString().contains("@")) {
            myLoaders.showSnackBar(view, "Please Enter Correct Email");
            return false;

        } else if (TextUtils.isEmpty(edtpass.getText().toString().trim())) {
            myLoaders.showSnackBar(view, "Please Enter Password");
            return false;
        } else if (TextUtils.isEmpty(edtconfirmpass.getText().toString().trim())) {
            myLoaders.showSnackBar(view, "Please Enter Confirm Password");
            return false;
        }else if(!valid){
            myLoaders.showSnackBar(view, "Please Choose A valid UserName");
            return false;
        }
        return true;
    }

    /*"email":"rahueerf@gmgaiil.com",
            "mobileno":"7334455535636287",
            "customer_name":"raj",
            "customer_last_name":"pa",
            "password":"123"*/
    @Override
    public void onClick(View v) {
        if (v == btnRegister) {
            if (Check_Data(v)) {
                Random rand = new Random();
                int resRandom=0,resRandom1=0;
                System.out.println("Random numbers...");
                for (int i = 1; i<= 10; i++) {
                    resRandom = rand.nextInt((9999 - 100) + 1) + 10;
                    resRandom1 = rand.nextInt((999999 - 100) + 1) + 10;

                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("email", edtemail.getText().toString());
                hashMap.put("customer name", edtusername.getText().toString());
                hashMap.put("customer_username", edtusername.getText().toString());
                hashMap.put("password", edtpass.getText().toString());
                hashMap.put("device_type", "1");
                hashMap.put("mobileno", String.valueOf(resRandom)+String.valueOf(resRandom1));
                hashMap.put("fcm_token", refreshedToken);

                if (GlobalClass.isNetworkConnected(SignupActivity.this)) {
                    WebapiCall webapiCall = new WebapiCall();
                    webapiCall.SignupApi(SignupActivity.this, hashMap, this);

                } else {
                    Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }
            }

        }
//        else if (v == txtLogin) {
//            Intent intent = new Intent(SignupActivity.this, CreateChanelStart.class);
//            intent.putExtra("path", ImagePath);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
//        }
        else if (v == profile_civ) {
            PickImageDialog.build(new PickSetup()).show(SignupActivity.this);
        }
        else if(v==Back){
            finish();

        }
    }

    @Override
    public void onPickResult(PickResult r) {
        profile_civ.setImageBitmap(r.getBitmap());
        ImagePath = r.getPath();
    }

    @Override
    public void Sucess() {
        Intent intent = new Intent(SignupActivity.this, CreateChanelStart.class);
        if(!ImagePath.isEmpty()) {
            intent.putExtra("path", ImagePath);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

    @Override
    public void ValidUserName(int i, String msg) {
        if (i == 0) {
            valid = true;
            edtusername.setError(null);
        } else {
            valid = false;
            edtusername.setError(msg);
        }
    }
}
