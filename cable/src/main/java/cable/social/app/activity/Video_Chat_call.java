package cable.social.app.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.util.ArrayList;

import cable.social.app.Interface.FriendListInterface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.adadpter.Video_call_adapter;
import cable.social.app.fragment.Memberships;
import cable.social.app.model.FriendListPoJO;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;

public class Video_Chat_call extends AppCompatActivity implements FriendListInterface {
    RecyclerView videoinview;
    Video_call_adapter video_call_adapter;
    String videoURL = "https://www.radiantmediaplayer.com/media/bbb-360p.mp4", Ispremiumvideo,video_id;
    SimpleExoPlayerView exoPlayerView;
    private static int splashTimeOut = 5000;
    String TOKBOXSESSION_ID, TOKBOXTOKEN;
    ArrayList<FriendListPoJO.FriendList> arrayList = new ArrayList<>();
    WebapiCall webapiCall;
    ImageView backbutton;


    SimpleExoPlayer exoPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video__chat_call);

        Intent intent = getIntent();

        videoURL = intent.getStringExtra("videourl");
        Ispremiumvideo = intent.getStringExtra("Ispremiumvideo");
        video_id = intent.getStringExtra("video_id");

        exoPlayerView = (SimpleExoPlayerView) findViewById(R.id.videoplay);
        videoinview = findViewById(R.id.videoinview);

        backbutton = findViewById(R.id.backbutton);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        videoinview.setLayoutManager(horizontalLayoutManagaer);
        video_call_adapter = new Video_call_adapter(this, arrayList);

        videoinview.setAdapter(video_call_adapter);


        if (GlobalClass.isNetworkConnected(this)) {
             webapiCall = new WebapiCall();
//            webapiCall.friendList(this, CSPreferences.readString(this, "tooken"), CSPreferences.readString(this, "auth_key"), this);
            webapiCall.RecentVideo(this, CSPreferences.readString(this, "tooken"), CSPreferences.readString(this, "auth_key"),video_id);

        } else {

            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }

        try {
            BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
            TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
            exoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector);
            Uri videoURI = Uri.parse(videoURL);
            DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("exoplayer_video");
            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
            MediaSource mediaSource = new ExtractorMediaSource(videoURI, dataSourceFactory, extractorsFactory, null, null);
            exoPlayerView.setPlayer(exoPlayer);
            exoPlayer.prepare(mediaSource);
            exoPlayer.setPlayWhenReady(true);
            hideSystemUi();
        } catch (Exception e) {
            Log.e("MainAcvtivity", " exoplayer error " + e.toString());
        }


        try {

            if (CSPreferences.readString(this, "ActivePlanId").isEmpty() && Ispremiumvideo.equalsIgnoreCase(Ispremiumvideo))
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        showConfigError("purchase your plain", "");
                        // exoPlayer.stop();
                        // startActivity(new Intent(Video_Chat_call.this, Memberships.class));

                 /*   Intent intent = new Intent(Video_Chat_call.this, Memberships.class);// New activity
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish(); //*/
                    }
                }, splashTimeOut);

        } catch (Exception e) {
            Log.e("MainAcvtivity", " exoplayer error " + e.toString());
        }
    }

    private void showConfigError(String alertTitle, final String errorMessage) {

        exoPlayer.stop();
        new FancyGifDialog.Builder(this)

                .setTitle("MemberShip Plan")
                .setMessage(alertTitle)
                .setNegativeBtnText("Cancel")
                .setPositiveBtnBackground("#FF4081")
                .setPositiveBtnText("Buy")
                .setNegativeBtnBackground("#3a3160")
                .setGifResource(R.drawable.watch)
                .isCancellable(false)
                .OnPositiveClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {
                        Intent intent = new Intent(Video_Chat_call.this, Memberships.class);// New activity
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    }
                })
                .OnNegativeClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {
                        finish();
                    }
                })
                .build();


    }

    @Override
    protected void onPause() {
        super.onPause();
        exoPlayer.stop();
        // play.setVisibility(View.VISIBLE);


    }

    @Override
    protected void onResume() {
        super.onResume();
        // play.setVisibility(View.GONE);

        exoPlayer.setPlayWhenReady(true);
    }


    @SuppressLint("InlinedApi")
    private void hideSystemUi() {
        exoPlayerView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }





    @Override
    public void friendListInterface(ArrayList<FriendListPoJO.FriendList> list) {
        arrayList.clear();
        arrayList.addAll(list);
        videoinview.getAdapter().notifyDataSetChanged();

    }


    @Override
    public void tokboxcredentialsInterface(FriendListPoJO.TokboxCredentials tokboxCredentials) {
        TOKBOXSESSION_ID = tokboxCredentials.getSessionId();
        TOKBOXTOKEN = tokboxCredentials.getSessionId();


    }
}
