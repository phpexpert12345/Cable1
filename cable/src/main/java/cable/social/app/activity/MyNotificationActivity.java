package cable.social.app.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cable.social.app.Interface.FreindRequestInterface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.adadpter.CallingRequestNotiAdaper;
import cable.social.app.adadpter.FriendRequestNotiAdaper;
import cable.social.app.adadpter.MyNotiAdapter;
import cable.social.app.adadpter.NotificationPagerAdapter;

import cable.social.app.model.FriendRequest;


public class MyNotificationActivity extends AppCompatActivity  {

    ImageView back_iv;
    TabLayout tabLayout;
    ViewPager viewPager;
    NotificationPagerAdapter notificationPagerAdapter;


    RecyclerView noti_recycler;
    MyNotiAdapter myNotiAdapter;
    FriendRequestNotiAdaper friendRequestNotiAdaper;
    CallingRequestNotiAdaper callingRequestNotiAdaper;
    List<Map<String,String>>myNotiList=new LinkedList<>();
//    List<Map<String,String>>friendRequestNotiList=new LinkedList<>();
    List<FriendRequest.Datum>friendRequestNotiList=new LinkedList<>();


    List<Map<String,String>>callingRequestNotiList=new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notification);
        getViewId();


//        if (GlobalClass.isNetworkConnected(MyNotificationActivity.this)) {
//            WebapiCall webapiCall = new WebapiCall();
//
//            Log.d("token", CSPreferences.readString(this, "tooken"));
//
//            webapiCall.getFriendRequest(this, CSPreferences.readString(this, "tooken"),  CSPreferences.readString(this, "auth_key"), this);
//
//
//        } else {
//
//            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
//        }


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                if(tab.getPosition()==0){
//                    setMyNotiList();
//                }
////                else if(tab.getPosition()==1){
////                    setFriendRequest();
////                }
////                else if(tab.getPosition()==2){
////                    setCallingRequestNoti();
////                }
//
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        notificationPagerAdapter = new NotificationPagerAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(notificationPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }
    private void getViewId(){
        back_iv=findViewById(R.id.back_iv);
//        noti_recycler=findViewById(R.id.noti_recycler);
//        noti_recycler.setHasFixedSize(true);
//        noti_recycler.setLayoutManager(new LinearLayoutManager(MyNotificationActivity.this));
        viewPager=findViewById(R.id.viewPager);
        tabLayout=findViewById(R.id.tabLayout);
//        tabLayout.addTab(tabLayout.newTab().setText("Notification"));
//        tabLayout.addTab(tabLayout.newTab().setText("Friend Requests"));
//        tabLayout.addTab(tabLayout.newTab().setText("Video Calling Request"));
//        setMyNotiList();
        back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }









}