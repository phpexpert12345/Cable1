package cable.social.app.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickResult;

import java.io.File;

import cable.social.app.Interface.EditPassword;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static cable.social.app.activity.MainActivity.uname;
import static cable.social.app.activity.MyAccountFragment.fname_tv;

public class EditProfileActivity extends AppCompatActivity implements  IPickResult, EditPassword {

//    EditText fname_et,lname_et,mobile_et,about_et,tag_et;
    EditText fname_et,user_name_et,email_et,Password;
    Button submit_btn;
    ImageView cover_iv,edit_iv;
    CircleImageView profile_civ;
    String fname="",user_name="",email="",profileimg="",cover_image="";
    String filePath,filePathCover;
     String cover_profile = "https://socialcableapps.s3.ap-south-1.amazonaws.com/movies/images/1595195049IMG20200610163404.jpg";
    File imagefile=null;
    File imagefile_cover=null;
    private String OldPasword,password,Confirm_password;

    ImageView BackArrow;

    int Imagetoggle=-1;

     Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Bundle bundle=getIntent().getExtras();
        fname=bundle.getString("fname");
        user_name=bundle.getString("user_name");
        profileimg=bundle.getString("profileimg");
        email=bundle.getString("email");
        cover_image=bundle.getString("cover_image");


          dialog = new Dialog(this);


        getViewId();
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fname=fname_et.getText().toString();
                user_name=user_name_et.getText().toString();

                RequestBody customer_id_rb = RequestBody.create(MediaType.parse("multipart/form-data"), CSPreferences.readString(EditProfileActivity.this, "auth_key"));
                RequestBody fname_rb = RequestBody.create(MediaType.parse("multipart/form-data"), fname);
                RequestBody username_rb = RequestBody.create(MediaType.parse("multipart/form-data"), user_name);
                uname.setText(fname);
                fname_tv.setText(fname);
                CSPreferences.putString(getApplicationContext(), "name", String.valueOf(fname));


                RequestBody imagerequestFile;
                MultipartBody.Part imagebody = null;

                if (imagefile_cover == null) {
//                    GlobalClass.showtost(EditProfileActivity.this, "Select your image");
//                    return;

                } else {
                    imagerequestFile = RequestBody.create(MediaType.parse("multipart/form-data"), imagefile_cover);
                    imagebody = MultipartBody.Part.createFormData("cover_profile_image", imagefile_cover.getName(), imagerequestFile);

                }


                if (GlobalClass.isNetworkConnected(EditProfileActivity.this)) {

                    WebapiCall webapiCalls = new WebapiCall();
                    webapiCalls.updateProfile(EditProfileActivity.this, CSPreferences.readString(EditProfileActivity.this, "tooken"),
                            customer_id_rb,fname_rb,username_rb,imagebody);
                } else {

                    Toast.makeText(EditProfileActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }

            }
        });
        edit_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Imagetoggle=1;
                PickImageDialog.build(new PickSetup()).show(EditProfileActivity.this);

            }
        });
        profile_civ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Imagetoggle=0;
                PickImageDialog.build(new PickSetup()).show(EditProfileActivity.this);
            }
        });
    }
    private void getViewId(){
        submit_btn=findViewById(R.id.submit_btn);
        fname_et=findViewById(R.id.fname_et);
        user_name_et=findViewById(R.id.user_name_et);
        email_et=findViewById(R.id.email_et);
        cover_iv=findViewById(R.id.cover_iv);
        edit_iv=findViewById(R.id.edit_iv);
        profile_civ=findViewById(R.id.profile_civ);
        BackArrow = findViewById(R.id.back_arrow);
        Password = findViewById(R.id.password_et);

        fname_et.setText(fname);
        user_name_et.setHint(user_name);
        email_et.setHint(email);

        if(profileimg!=null&&!profileimg.equalsIgnoreCase("null")&&!profileimg.equalsIgnoreCase("")){
            Glide.with(this)
                    .load(profileimg)
                    .fitCenter().placeholder(R.drawable.logo)
                    .into(profile_civ);

        } if(cover_image!=null&&!cover_image.equalsIgnoreCase("null")&&!cover_image.equalsIgnoreCase("")){
            Glide.with(this)
                    .load(cover_image)
                    .fitCenter().placeholder(R.drawable.imgg)
                    .into(cover_iv);
        }



        BackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        Password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showCustomDialog();

            }
        });


    }

    private void showCustomDialog() {



        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.show();
        dialog.getWindow().setAttributes(lp);

        // Include dialog.xml file
        dialog.setContentView(R.layout.change_password);
        dialog.show();

        Button save =  (Button)dialog.findViewById(R.id.dialog_submit_btn);
        EditText oldpassword = (EditText)dialog.findViewById(R.id.old_password);
        EditText new_password = (EditText)dialog.findViewById(R.id.new_password);
        EditText new_confirm_password = (EditText)dialog.findViewById(R.id.new_confirm_password);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OldPasword = oldpassword.getText().toString();
                password = new_password.getText().toString();
                Confirm_password = new_confirm_password.getText().toString();

                if(OldPasword.equals("") || password.equals("") || Confirm_password.equals("")) {
                    GlobalClass.showtost(EditProfileActivity.this,"please Enter the password in all field");

                }else if(password.equals(Confirm_password)){
                    savePassword();
                }else{
                    GlobalClass.showtost(EditProfileActivity.this,"Password and Confirm password do not match");

                }
            }
        });

//        Button no = (Button)dialog.findViewById(R.id.dialog_no);
//        SeriesSpinner = (Spinner) dialog.findViewById(R.id.series_spnr);
//        ll = (LinearLayout)dialog.findViewById(R.id.series_panchayat_linear);


//        yes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(EditProfileActivity.this, EpisodInfoActivity.class));
//                dialog.dismiss();
//
//
//            }
//        });
//
//        no.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                getMySeries();
//
//            }
//        });


//        SeriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
//
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                if(i==0){
//
//                }else {
////                    GlobalClass.showtost(ChooseTypeActivty.this, serieszList.get(i-1).getSeasonTitle() + serieszList.get(i-1).getSeasonId());
//
//                    Intent intent = new Intent(getActivity(), EpisodInfoActivity.class);
//
//                    intent.putExtra("season_id",String.valueOf(serieszList.get(i-1).getSeasonId()));
//
//                    Log.d("season_id", String.valueOf(serieszList.get(i-1).getSeasonId()));
//
//                    startActivity(intent);
//
//
//                    dialog.dismiss();
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });


    }


    private void savePassword() {
        if (GlobalClass.isNetworkConnected(this)) {
            WebapiCall sliderlist = new WebapiCall();
            sliderlist.saveNewPassword(this, CSPreferences.readString(this, "tooken"), CSPreferences.readString(this, "auth_key"),OldPasword,password,Confirm_password,this);
        } else {

            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }
    }


    public void onPickResult(PickResult r) {
        if (r.getError() == null) {
            if(Imagetoggle==0) {
                filePath = r.getPath();
                profile_civ.setImageBitmap(r.getBitmap());
                imagefile = new File(r.getPath());
                profileupdateApi(this, imagefile);
            }else{
                filePathCover = r.getPath();
                cover_iv.setImageBitmap(r.getBitmap());
                imagefile_cover = new File(r.getPath());
            }
        } else {
            //Handle possible errors
            //TODO: do what you have to do with r.getError();
            Toast.makeText(this, r.getError().getMessage(), Toast.LENGTH_LONG).show();
        }
    }


    private void profileupdateApi(Context context, File imagefile){
        RequestBody customer_id = RequestBody.create(MediaType.parse("multipart/form-data"), CSPreferences.readString(EditProfileActivity.this, "auth_key"));

        RequestBody imagerequestFile;
        MultipartBody.Part imagebody = null;

        if (imagefile == null) {
            GlobalClass.showtost(EditProfileActivity.this, "Select your image");
            return;

        } else {
            imagerequestFile = RequestBody.create(MediaType.parse("multipart/form-data"), imagefile);
            imagebody = MultipartBody.Part.createFormData("customer_profile_pic", imagefile.getName(), imagerequestFile);

        }

        if (GlobalClass.isNetworkConnected(this)) {

            WebapiCall webapiCall = new WebapiCall();
            webapiCall.customerProfilePic(context, CSPreferences.readString(context, "tooken"),customer_id,imagebody);


        } else {

            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }



    }

    @Override
    public void PasswordChanged(String msg) {

        dialog.dismiss();
        GlobalClass.showtost(this,msg);


    }
}