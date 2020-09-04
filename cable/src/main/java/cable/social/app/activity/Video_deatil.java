package cable.social.app.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

import cable.social.app.Interface.Video_detail_Interfae;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.activity.services.LoginService;
import cable.social.app.adadpter.Cast_Adapter;
import cable.social.app.adadpter.Invitation_invite_adapter;
import cable.social.app.adadpter.Recent_viewAdapter;
import cable.social.app.model.VideoDetailModel;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;
import cable.social.app.utils.SharedPrefsHelper;

public class Video_deatil extends AppCompatActivity implements View.OnClickListener, Video_detail_Interfae {
    ArrayList<VideoDetailModel.Data.SimilarVideo> arrayList = new ArrayList<>();
    ArrayList<VideoDetailModel.Data.InviteList> invitrarrayList = new ArrayList<>();
//    ArrayList<VideoDetailModel.Data.SeasonsList> seasonsLists = new ArrayList<>();
    ArrayList<VideoDetailModel.Data.Genre> genricarrayList = new ArrayList<>();
    RecyclerView cast_recyclview, recentview_recycle,recycle_invite;
    Cast_Adapter cast_adapter;
    Recent_viewAdapter recent_viewAdapter;
    Invitation_invite_adapter invitation_invite_adapter;
//    Season_adapter season_adapter;
    String Ispremiumvideo, videoId;
    //  SimpleExoPlayerView exoPlayerView;
    ImageView exoPlayerView;
    SimpleExoPlayer exoPlayer;
    ImageView play, imageView;
    TextView total_view, relase_date, vtital, averagerating,Movie_Cat;
    //    LinearLayout doloadenable;
    RatingBar ratting_bar;
    ImageView likeImage,likedImage,BottomDown;
    TextView VideoLike,RecentViewAll,Description;
    String videoDescription = "Not Found";

    LinearLayout video_call;
    ImageView backbutton;
    String videoFile = null;
    RelativeLayout relativeLayoutCast;

    private BottomSheetBehavior sheetBehavior;
    private LinearLayout bottom_sheet;
    TextView date;
//    String videoURL = "https://www.radiantmediaplayer.com/media/bbb-360p.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_detail);
//        Ispremiumvideo = getIntent().getStringExtra("Ispremiumvideo");
        videoId = getIntent().getStringExtra("videoId");

        // exoPlayerView = (SimpleExoPlayerView) findViewById(R.id.videoplay);
//        exoPlayerView = (ImageView) findViewById(R.id.imageView);
        play = findViewById(R.id.play);
        relase_date = findViewById(R.id.relase_date);
        total_view = findViewById(R.id.total_view);
        vtital = findViewById(R.id.vid_tital);
        Movie_Cat = findViewById(R.id.movie_cat);
        relativeLayoutCast = findViewById(R.id.relativ_cast);
//        txtvalue = findViewById(R.id.txtvalue);
        imageView = findViewById(R.id.imageView);
//        doloadenable = findViewById(R.id.doloadenable);
//        ratting_bar = findViewById(R.id.ratting_bar);
//        averagerating = findViewById(R.id.averagerating);
        recycle_invite = findViewById(R.id.recycle_invite);
//        recycle_season = findViewById(R.id.recycle_season);

        BottomDown = findViewById(R.id.bottom_down);
        date = findViewById(R.id.date);


        play.setOnClickListener(this);


        cast_recyclview = findViewById(R.id.cast_recyclview);
        recentview_recycle = findViewById(R.id.recent_view_recycel);
//        seemore = findViewById(R.id.seemore);

        video_call = findViewById(R.id.video_call);

        bottom_sheet = findViewById(R.id.bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(bottom_sheet);
        backbutton = findViewById(R.id.backbutton_vd);

        likeImage = findViewById(R.id.like_img);
        likedImage = findViewById(R.id.liked_img);
        VideoLike = findViewById(R.id.video_like);
        RecentViewAll = findViewById(R.id.recent_viewAll);

        Description = findViewById(R.id.description);




        // change the state of the bottom sheet
        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        sheetBehavior.setPeekHeight(260);


        Description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(Video_deatil.this)
                        .setTitle("Description")
                        .setMessage(videoDescription)

                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Continue with delete operation
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
//                        .setNegativeButton(android.R.string.no, null)
//                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });


        BottomDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
//                    btn_bottom_sheet.setText("Close sheet");
                sheetBehavior.setHideable(true);

            }
        });



        // set callback for changes
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                Log.d("Bottom_Sheet","onStateChanged");
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                Log.d("Bottom_Sheet","onSlide");

            }
        });

        video_call.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                SharedPrefsHelper sharedPrefsHelper = SharedPrefsHelper.getInstance();
                if (sharedPrefsHelper.hasQbUser()) {
                    LoginService.start(Video_deatil.this, sharedPrefsHelper.getQbUser());
                    Log.v("vidUrl",videoFile);
                    CSPreferences.putString(Video_deatil.this, "videourl", videoFile);
                    CSPreferences.putString(Video_deatil.this, "video_id", videoId);
                    OpponentsActivity.start(Video_deatil.this,videoFile,videoId);
                } else {
                    LoginActivity.start(Video_deatil.this);
                }
                finish();

//                if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
//                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
////                    btn_bottom_sheet.setText("Close sheet");
//                    sheetBehavior.setHideable(true);
//
//                } else {
//                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
////                    btn_bottom_sheet.setText("Expand sheet");
//                    sheetBehavior.setHideable(false);
//
//                }
            }
        });

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

//        RecentViewAll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment fragsearch = new CategoryFragment();
//                FragmentManager fragmentManagersearch = getSupportFragmentManager();
//                fragmentManagersearch.beginTransaction().replace(R.id.content_frame, fragsearch).commit();
//            }
//        });


        likeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (GlobalClass.isNetworkConnected(Video_deatil.this)) {
                    WebapiCall webapiCall = new WebapiCall();

//                    Log.d("token",CSPreferences.readString(Video_deatil.this, "tooken"));

                    webapiCall.VideoLike(Video_deatil.this, CSPreferences.readString(Video_deatil.this, "tooken"), videoId,CSPreferences.readString(Video_deatil.this, "auth_key"), Video_deatil.this);


                } else {

                    Toast.makeText(Video_deatil.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }



            }
        });



        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(Video_deatil.this, LinearLayoutManager.HORIZONTAL, false);
        cast_recyclview.setLayoutManager(horizontalLayoutManagaer);

        LinearLayoutManager recentLayoutManagaer
                = new LinearLayoutManager(Video_deatil.this, LinearLayoutManager.HORIZONTAL, false);
        recentview_recycle.setLayoutManager(recentLayoutManagaer);

        LinearLayoutManager inviteLayoutManagaer
                = new LinearLayoutManager(Video_deatil.this, LinearLayoutManager.VERTICAL, false);
        recycle_invite.setLayoutManager(inviteLayoutManagaer);

//        LinearLayoutManager seasonLayoutManagaer
//                = new LinearLayoutManager(Video_deatil.this, LinearLayoutManager.HORIZONTAL, false);
//        recycle_season.setLayoutManager(seasonLayoutManagaer);


        invitation_invite_adapter = new Invitation_invite_adapter(this, invitrarrayList);
        recycle_invite.setAdapter(invitation_invite_adapter);

//        season_adapter = new Season_adapter(this, seasonsLists);
//        recycle_season.setAdapter(season_adapter);


        cast_adapter = new Cast_Adapter(Video_deatil.this, genricarrayList);
        cast_recyclview.setAdapter(cast_adapter);

        recent_viewAdapter = new Recent_viewAdapter(this, arrayList);
        recentview_recycle.setAdapter(recent_viewAdapter);


        if (GlobalClass.isNetworkConnected(Video_deatil.this)) {
            WebapiCall webapiCall = new WebapiCall();

            Log.d("token",CSPreferences.readString(this, "tooken"));

            webapiCall.video_detailById(this, CSPreferences.readString(this, "tooken"),CSPreferences.readString(this, "auth_key"), videoId, this);


        } else {

            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        // exoPlayer.stop();
        play.setVisibility(View.VISIBLE);


    }

    @Override
    protected void onResume() {
        super.onResume();
        //  exoPlayer.setPlayWhenReady(true);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(Video_deatil.this, Video_Chat_call.class).putExtra("videourl", videoFile).putExtra("video_id",videoId));
        play.setVisibility(View.INVISIBLE);

//        play.setVisibility(View.INVISIBLE);
       /* try {
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
        } catch (Exception e) {
            Log.e("MainAcvtivity", " exoplayer error " + e.toString());
        }*/
    }

    VideoDetailModel.Data models;

    @Override
    public void videolist(VideoDetailModel.Data model) {
        models = model;



        Glide.with(this).load(models.getVideoDetails().getMovieThumbnail())
                .fitCenter()
                .placeholder(R.drawable.logo)
                .into(imageView);
        total_view.setText(models.getVideoDetails().getTotalViews());
        relase_date.setText(models.getVideoDetails().getReleaseDate());
        vtital.setText(models.getVideoDetails().getVideoTitle());
        Movie_Cat.setText(models.getVideoDetails().getCategoryName() + " | "  +models.getVideoDetails().getDuration());
        videoDescription = models.getVideoDetails().getVideoDescription();

        if(models.getVideoDetails().getVideoType().equals("0")){
            date.setText("Release");
        }else if(models.getVideoDetails().getVideoType().equals("1")){
            date.setText("Air Date");
        }


        if(!models.getVideoDetails().getVideoLike().equals("")){
            likeImage.setVisibility(View.GONE);
            likedImage.setVisibility(View.VISIBLE);
            VideoLike.setText("Liked");
        }

        videoFile = models.getVideoDetails().getVideoFile();



//        txtvalue.setText(models.getVideoDetails().getSeoDescription());
//
//        if (models.getVideoDetails().getDownloadEnable().equalsIgnoreCase("0")) {
//            doloadenable.setVisibility(View.GONE);
//        } else {
//            doloadenable.setVisibility(View.VISIBLE);
//        }

        //ratting_bar.setRating(Float.parseFloat(models.getVideoDetails().getAverageRating()));
//        averagerating.setText(models.getVideoDetails().getAverageRating());


    }

    @Override
    public void videolistdata(ArrayList<VideoDetailModel.Data.SimilarVideo> list) {
        arrayList.clear();
        arrayList.addAll(list);
//        videoURL = arrayList.get(0).getVideoFile();
        recentview_recycle.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void invite_data(ArrayList<VideoDetailModel.Data.InviteList> list) {
        invitrarrayList.clear();
        invitrarrayList.addAll(list);
        recycle_invite.getAdapter().notifyDataSetChanged();
    }
//    @Override
//    public void season_list(ArrayList<VideoDetailModel.Data.SeasonsList> list) {
//        seasonsLists.clear();
//        seasonsLists.addAll(list);
//        recycle_season.getAdapter().notifyDataSetChanged();
//    }

    @Override
    public void genric_data(ArrayList<VideoDetailModel.Data.Genre> list) {
        if(list.size()==0){
            relativeLayoutCast.setVisibility(View.GONE);
        }else {
            relativeLayoutCast.setVisibility(View.VISIBLE);
        }

        genricarrayList.clear();
        genricarrayList.addAll(list);
        cast_recyclview.getAdapter().notifyDataSetChanged();

    }

    @Override
    public void videoLike(String msg) {

//        GlobalClass.showtost(this,msg);

        likeImage.setVisibility(View.GONE);
        likedImage.setVisibility(View.VISIBLE);
        VideoLike.setText("Liked");

    }
}


