package cable.social.app.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.content.CursorLoader;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;

import cable.social.app.Interface.Account_profile;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.adadpter.Recent_video_Adapter;
import cable.social.app.adadpter.TabsAdapter;
import cable.social.app.fragment.Memberships;
import cable.social.app.model.CustomerInfo_pojo;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class OtherUserAccount extends AppCompatActivity implements View.OnClickListener, Account_profile {
    ArrayList<CustomerInfo_pojo.Datum> arrayList = new ArrayList<>();
    ImageView cover_image;
    TextView name;


    private ImageView backbutton,edit_iv,SubsImage,SubsImage1;

    private CircleImageView profile_civ;
    private TextView fname_tv, lname_tv;
    private String user_id=null;
    private String ChannelID=null;
    private int totalSubscribe = 0;
    private TextView channel,video,NoChannel,TotalLike,TotalSubscribe,TotalVideo;


    LinearLayout MyChannel, MyVideos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_user_account);

        findViews();

        Intent intent = getIntent();

        user_id = intent.getStringExtra("user_id");


        if (GlobalClass.isNetworkConnected(OtherUserAccount.this)) {

            WebapiCall webapiCall = new WebapiCall();
            webapiCall.customerInfo(this, CSPreferences.readString(this, "tooken"), user_id, this);
        } else {

            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }


    }

    private void findViews() {
        fname_tv = findViewById(R.id.fname_tv);
        lname_tv = findViewById(R.id.lname_tv);
        profile_civ = findViewById(R.id.profile_civ);
        cover_image = findViewById(R.id.cover_image);
        backbutton = (ImageView) findViewById(R.id.backbutton);
        name = (TextView) findViewById(R.id.name);
        edit_iv = findViewById(R.id.edit_iv);
        edit_iv.setVisibility(View.GONE);
        video = findViewById(R.id.video);
        channel = findViewById(R.id.channel);
        NoChannel = findViewById(R.id.nochanel);
        TotalLike = findViewById(R.id.total_like);
        TotalSubscribe = findViewById(R.id.total_subcribe);
        TotalVideo = findViewById(R.id.total_video);
        SubsImage = findViewById(R.id.sbs_img);
        SubsImage1 = findViewById(R.id.sbs_img1);






        MyChannel = (LinearLayout) findViewById(R.id.channel_ll);
        MyVideos = findViewById(R.id.my_videos_ll);

        MyChannel.setVisibility(View.GONE);

        SubsImage.setOnClickListener(this);



        backbutton.setOnClickListener(this);
        MyChannel.setOnClickListener(this);
        MyVideos.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        if (v == backbutton) {
            finish();
        } else if (v == MyChannel) {
            Intent intent1 = new Intent(this, My_chanlel.class);
            startActivity(intent1);

        } else if (v == MyVideos) {
            CSPreferences.putString(OtherUserAccount.this, "user_id_for_video", user_id);
            Intent intent1 = new Intent(this, MyEpisodActivity.class);
            startActivity(intent1);

        }else if(v==SubsImage){

            if(!ChannelID.isEmpty()) {

                if (GlobalClass.isNetworkConnected(OtherUserAccount.this)) {

                    WebapiCall webapiCall = new WebapiCall();
                    webapiCall.UserSubscribe(this, CSPreferences.readString(this, "tooken"), CSPreferences.readString(this, "auth_key"),ChannelID, this);
                } else {

                    Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }
            }else{
                GlobalClass.showtost(this,"No Channel Found");
            }

        }

    }


    @Override
    public void account_profile(ArrayList<CustomerInfo_pojo.Datum> customerdump) {
        arrayList.clear();
        arrayList.addAll(customerdump);
        fname_tv.setText(arrayList.get(0).getCustomerName());
        //followers_.setText(arrayList.get(0).getChannelName());
        lname_tv.setText(arrayList.get(0).getCustomerLastName());

        totalSubscribe = Integer.parseInt(arrayList.get(0).getTotalSubscribe());


        if(!arrayList.get(0).getTotalLike().equals("0")) {
            TotalLike.setText(arrayList.get(0).getTotalLike() + " Like");
        }
        if(!arrayList.get(0).getTotalSubscribe().equals("0")) {
            TotalSubscribe.setText(arrayList.get(0).getTotalSubscribe() + " Suscriber");
        }
        if(!arrayList.get(0).getTotalDislike().equals("0")) {
            TotalVideo.setText(arrayList.get(0).getTotalDislike() + " Videos");
        }

            ChannelID = arrayList.get(0).getChannelLogoId();



        if(arrayList.get(0).getChannelName().equals("")){
            MyVideos.setVisibility(View.GONE);
            NoChannel.setVisibility(View.VISIBLE);
        }


        video.setText(arrayList.get(0).getCustomerName() + " Videos");
        channel.setText(arrayList.get(0).getCustomerName() + " Channel");


        Glide.with(this)
                .load(arrayList.get(0).getCustomerProfilePic())
                .fitCenter().placeholder(R.drawable.logo)
                .into(profile_civ);

        Glide.with(this)
                .load(arrayList.get(0).getCoverProfileImage())
                .fitCenter().placeholder(R.drawable.user_cover)
                .into(cover_image);



    }

    @Override
    public void Subscrbe(String msg) {
        GlobalClass.showtost(this,msg);
        SubsImage.setVisibility(View.GONE);
        SubsImage1.setVisibility(View.VISIBLE);

        TotalSubscribe.setText(totalSubscribe+1 + " Suscriber");





    }
// Api call update profile picture


}

