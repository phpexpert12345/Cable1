package cable.social.app.activity;

import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.quickblox.core.QBEntityCallback;
import com.quickblox.core.exception.QBResponseException;
import com.quickblox.users.QBUsers;
import com.quickblox.users.model.QBUser;

import java.util.HashMap;

import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.activity.services.LoginService;
import cable.social.app.utility.GlobalClass;
import cable.social.app.utility.MyLoaders;
import cable.social.app.utils.Consts;
import cable.social.app.utils.KeyboardUtils;
import cable.social.app.utils.QBEntityCallbackImpl;
import cable.social.app.utils.SharedPrefsHelper;
import cable.social.app.utils.ToastUtils;
import cable.social.app.utils.ValidationUtils;
import cable.social.app.video_filter.App;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    Button login, createaccount;
    private EditText edtemail,edtpass;

    private String refreshedToken;
    MyLoaders myLoaders;
    private String TAG = LoginActivity.class.getSimpleName();

    private static final int MIN_LENGTH = 3;


    private QBUser userForSave;


    ProgressDialog pd;

    public void dailogshow(Context context) {
        pd = new ProgressDialog(context);
        pd.setMessage("loading...");
        pd.setCancelable(false);
        pd.show();
    }

    public void dailoghide(Context context) {
        pd.dismiss();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        myLoaders = new MyLoaders(getApplicationContext());
        refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
        findViews();

      /*  login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, AlloptionActivity.class);
                startActivity(i);
                finish();
            }
        });
*/

      createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);

            }
        });
    }


    private void findViews() {
        login =  findViewById(R.id.login_btn);
        createaccount = findViewById(R.id.create_btn);
        edtemail =findViewById(R.id.mail_et);
        edtpass =findViewById(R.id.password_et);
        login.setOnClickListener(this);
    }

    public boolean Check_Data(View view) {

        if (edtemail.getText().toString().equals("")) {
            myLoaders.showSnackBar(view, "Please Enter Correct Email");
            return false;

        } else if (TextUtils.isEmpty(edtpass.getText().toString().trim())) {
            myLoaders.showSnackBar(view, "Please Enter Password");
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
        if (v == login) {
            dailogshow(LoginActivity.this);
            if (Check_Data(v)) {

                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("customer_username", edtemail.getText().toString());
                hashMap.put("password", edtpass.getText().toString());
                hashMap.put("device_type", "Android");
                hashMap.put("fcm_token", refreshedToken);


                if (GlobalClass.isNetworkConnected(LoginActivity.this)) {
                        hideKeyboard();
                        userForSave = createUserWithEnteredData();
                        startSignUpNewUser(userForSave,hashMap);


                } else {
                    dailoghide(LoginActivity.this);

                    Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }

            }


        }
    }

    private void hideKeyboard() {
        KeyboardUtils.hideKeyboard(edtemail);
        KeyboardUtils.hideKeyboard(edtpass);
    }

    private void startSignUpNewUser(final QBUser newUser,HashMap hashMap) {
        Log.d(TAG, "SignUp New User");
        //showProgressDialog(R.string.dlg_creating_new_user);
        requestExecutor.signUpNewUser(newUser, new QBEntityCallback<QBUser>() {
                    @Override
                    public void onSuccess(QBUser result, Bundle params) {
                        Log.d(TAG, "SignUp Successful");
                        dailoghide(LoginActivity.this);

                        saveUserData(newUser);
                        loginToChat(result);
                        WebapiCall webapiCall = new WebapiCall();
                        webapiCall.LoginApi(LoginActivity.this, hashMap);

                    }

                    @Override
                    public void onError(QBResponseException e) {


                        Log.d(TAG, "Error SignUp" + e.getMessage());
                        if (e.getHttpStatusCode() == Consts.ERR_LOGIN_ALREADY_TAKEN_HTTP_STATUS) {
                            dailoghide(LoginActivity.this);
                            signInCreatedUser(newUser,hashMap);
                        } else {
                            dailoghide(LoginActivity.this);
                          //  hideProgressDialog();
                            ToastUtils.longToast(R.string.sign_up_error);
                        }
                    }
                }
        );
    }

    private void loginToChat(final QBUser qbUser) {
        qbUser.setPassword(edtpass.getText().toString());
        userForSave = qbUser;
        startLoginService(qbUser);
    }

    private void saveUserData(QBUser qbUser) {
        SharedPrefsHelper sharedPrefsHelper = SharedPrefsHelper.getInstance();
        sharedPrefsHelper.saveQbUser(qbUser);
    }

    private QBUser createUserWithEnteredData() {
        return createQBUserWithCurrentData("Social_"+String.valueOf(edtemail.getText()),
                String.valueOf(edtemail.getText()));
    }

    private QBUser createQBUserWithCurrentData(String userLogin, String userFullName) {
        QBUser qbUser = null;
        if (!TextUtils.isEmpty(userLogin) && !TextUtils.isEmpty(userFullName)) {
            qbUser = new QBUser();
            qbUser.setLogin(userLogin);
            qbUser.setFullName(userFullName);
            qbUser.setPassword(edtpass.getText().toString());
        }
        return qbUser;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Consts.EXTRA_LOGIN_RESULT_CODE) {
          //  hideProgressDialog();
            boolean isLoginSuccess = data.getBooleanExtra(Consts.EXTRA_LOGIN_RESULT, false);
            String errorMessage = data.getStringExtra(Consts.EXTRA_LOGIN_ERROR_MESSAGE);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("customer_username", edtemail.getText().toString());
            hashMap.put("password", edtpass.getText().toString());
            hashMap.put("device_type", "Android");
            hashMap.put("fcm_token", refreshedToken);
            if (isLoginSuccess) {
                dailoghide(LoginActivity.this);

                saveUserData(userForSave);
                signInCreatedUser(userForSave,hashMap);
            } else {
                dailoghide(LoginActivity.this);

                ToastUtils.longToast(getString(R.string.login_chat_login_error) + errorMessage);
                edtemail.setText(userForSave.getLogin());
                edtpass.setText(userForSave.getPassword());
            }
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void signInCreatedUser(final QBUser qbUser,HashMap hashMap) {
        Log.d(TAG, "SignIn Started");
        requestExecutor.signInUser(qbUser, new QBEntityCallbackImpl<QBUser>() {
            @Override
            public void onSuccess(QBUser user, Bundle params) {
                Log.d(TAG, "SignIn Successful");
                dailoghide(LoginActivity.this);

                sharedPrefsHelper.saveQbUser(userForSave);
                updateUserOnServer(qbUser);
                WebapiCall webapiCall = new WebapiCall();
                webapiCall.LoginApi(LoginActivity.this, hashMap);
            }

            @Override
            public void onError(QBResponseException responseException) {
                Log.d(TAG, "Error SignIn" + responseException.getMessage());
                dailoghide(LoginActivity.this);

               // hideProgressDialog();
                ToastUtils.longToast(R.string.sign_in_error);
            }
        });
    }

    private void updateUserOnServer(QBUser user) {
        user.setPassword(null);
        QBUsers.updateUser(user).performAsync(new QBEntityCallback<QBUser>() {
            @Override
            public void onSuccess(QBUser qbUser, Bundle bundle) {
             //   hideProgressDialog();
                dailoghide(LoginActivity.this);
               // OpponentsActivity.start(LoginActivity.this);
              //  finish();
            }

            @Override
            public void onError(QBResponseException e) {
             //   hideProgressDialog();
                dailoghide(LoginActivity.this);
                ToastUtils.longToast(R.string.update_user_error);
            }
        });
    }

    private void startLoginService(QBUser qbUser) {
        Intent tempIntent = new Intent(this, LoginService.class);
        PendingIntent pendingIntent = createPendingResult(Consts.EXTRA_LOGIN_RESULT_CODE, tempIntent, 0);
        LoginService.start(this, qbUser, pendingIntent);
    }



}
