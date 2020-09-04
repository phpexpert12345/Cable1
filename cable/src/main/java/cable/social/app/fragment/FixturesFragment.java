package cable.social.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;

import cable.social.app.Interface.Salider_interface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.activity.Video_Chat_call;
import cable.social.app.activity.Video_deatil;
import cable.social.app.adadpter.Recent_video_Adapter;
import cable.social.app.adadpter.Mycomunity_adapter;
import cable.social.app.adadpter.Premium_video_Adapter;
import cable.social.app.adadpter.Primium_video_adapters;
import cable.social.app.adadpter.SocialCommunity_Adapter;
import cable.social.app.model.Slider_model;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;
import cable.social.app.utility.RecyclerItemClickListener;

import java.util.ArrayList;

public class FixturesFragment extends Fragment implements Salider_interface, View.OnClickListener {

    private LinearLayout llmain;
//    private TextView catseeall;
//    private TextView premiumSeeall;
//    private TextView mcommunitySeeall;
//    private TextView sosialSeeall;
    private ShimmerFrameLayout mShimmerViewContainer;
//    top_recycler
    private RecyclerView recycleview_recent_video, recyclerView_Premimvideo, recycleviewpremiun_, recycleviewsocal_commnicate, recycleviewmycommunity;
    private Recent_video_Adapter recent_video_adapter;
    private ArrayList<Slider_model.SliderList> sliderLists = new ArrayList<>();
    private ArrayList<Slider_model.RecentVideo> recentVideos = new ArrayList<>();
    private ArrayList<Slider_model.PremiumVideoList> primevideoLists = new ArrayList<>();

    ImageView TopImage;


    RelativeLayout rl_top;
     Handler handler;

    private RelativeLayout continue_watching,premium_video,free_video,my_community,social_community;

    private ArrayList<Slider_model.FreeVideoList> FreeVideo_list = new ArrayList<>();

    private ArrayList<Slider_model.MyCommunityUsersList> MyCommunityUsersList_list = new ArrayList<>();
    private ArrayList<Slider_model.SocialCommunityUser> SocialCommunityUser_list = new ArrayList<>();

    GridLayoutManager SocialManaager;
    SocialCommunity_Adapter socialCommunity_adapter;
    int scrollCount = 0;


//    private TopAdapter topAdapter;
    public FixturesFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // View rootView = inflater.inflate(R.layout.fragment_fixtures, container, false);

        //View view = inflater.inflate(R.layout.fragment_category, container, false);
        View view = inflater.inflate(R.layout.fragment_fixtures, container, false);
        recycleview_recent_video = view.findViewById(R.id.recycleviewgernal_movie);
//        top_recycler = view.findViewById(R.id.top_recycler);
//        top_recycler.setLayoutManager(new CenterZoomLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        llmain = view.findViewById(R.id.llmain);
        mShimmerViewContainer = view.findViewById(R.id.shimmer_view_container);
        handler = new Handler();





//        catseeall = view.findViewById(R.id.cat_seeall);
//        mcommunitySeeall = view.findViewById(R.id.mcommunity_seeall);
//        premiumSeeall = view.findViewById(R.id.premium_seeall);
//        sosialSeeall = view.findViewById(R.id.sosial_seeall);
        rl_top = view.findViewById(R.id.rl_top);

        continue_watching = view.findViewById(R.id.continue_watching);
        premium_video = view.findViewById(R.id.premium_video);
        free_video = view.findViewById(R.id.free_video);
        my_community = view.findViewById(R.id.my_community);
        social_community = view.findViewById(R.id.social_community);
        TopImage = view.findViewById(R.id.top_image);


        TopImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Video_Chat_call.class).putExtra("videourl", "https://socialcableapps.s3.ap-south-1.amazonaws.com/movies/video/1597693552sosocial%20final%20video.mp4").putExtra("video_id","45"));
            }
        });

//        catseeall.setOnClickListener(this);
//        mcommunitySeeall.setOnClickListener(this);
//        premiumSeeall.setOnClickListener(this);
//        sosialSeeall.setOnClickListener(this);

//         topAdapter=new TopAdapter(getActivity(),sliderLists);
//        top_recycler.setAdapter(topAdapter);


        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycleview_recent_video.setLayoutManager(horizontalLayoutManagaer);

        recent_video_adapter = new Recent_video_Adapter(getActivity(),recentVideos);
        recycleview_recent_video.setAdapter(recent_video_adapter);

        recycleviewpremiun_ = view.findViewById(R.id.recycleviewpremiun_);
        recyclerView_Premimvideo = view.findViewById(R.id.recycleviewpremiun_video);

        recycleviewsocal_commnicate = view.findViewById(R.id.recycleviewsocial_community);
        recycleviewmycommunity = view.findViewById(R.id.recycleviewmycommunity);

        // Prime video................
        LinearLayoutManager horizontalLayoutManagaer1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView_Premimvideo.setLayoutManager(horizontalLayoutManagaer1);
        Premium_video_Adapter primium_video_adapter = new Premium_video_Adapter(getActivity(), primevideoLists);
        recyclerView_Premimvideo.setAdapter(primium_video_adapter);


      //Free video.
        LinearLayoutManager horizontalLayoutManagaers = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycleviewpremiun_.setLayoutManager(horizontalLayoutManagaers);

        Primium_video_adapters primium_video_adapters = new Primium_video_adapters(getActivity(), FreeVideo_list);
        recycleviewpremiun_.setAdapter(primium_video_adapters);


        // My communatiy .....................
        LinearLayoutManager horizontalLayoutManagaer3
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycleviewmycommunity.setLayoutManager(horizontalLayoutManagaer3);

        Mycomunity_adapter mycomunity_adapter = new Mycomunity_adapter(getActivity(), MyCommunityUsersList_list);
        recycleviewmycommunity.setAdapter(mycomunity_adapter);


// Social commenutiy........
        SocialManaager = new GridLayoutManager(getActivity(), 2,GridLayoutManager.HORIZONTAL, false);
        recycleviewsocal_commnicate.setLayoutManager(SocialManaager);

        socialCommunity_adapter = new SocialCommunity_Adapter(getActivity(), SocialCommunityUser_list);
        recycleviewsocal_commnicate.setAdapter(socialCommunity_adapter);


        if (GlobalClass.isNetworkConnected(getActivity() )) {
                WebapiCall sliderlist = new WebapiCall();
                sliderlist.sliderlist(getActivity(), this, CSPreferences.readString(getActivity(), "tooken"));
        } else {

            Toast.makeText(getActivity(), GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }


        recycleviewpremiun_.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        //startActivity(new Intent(getActivity(), Video_deatil.class).putExtra("price_", "no"));
                        startActivity(new Intent(getActivity(), Video_deatil.class).putExtra("videoId",primevideoLists.get(position).getId()).putExtra("Ispremiumvideo","no"));


                    }
                }));

        recyclerView_Premimvideo.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        startActivity(new Intent(getActivity(), Video_deatil.class).putExtra("videoId",primevideoLists.get(position).getId()).putExtra("Ispremiumvideo","yes"));

                    }
                }));

        recycleview_recent_video.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(getActivity(), Video_deatil.class).putExtra("videoId",recentVideos.get(position).getVideoId()).putExtra("Ispremiumvideo","yes"));

            }
        }));


        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
//        if(SocialCommunityUser_list.size()>0){
//
//            SocialCommunityUser_list(SocialCommunityUser_list);
//
//        }
    }

    @Override
    public void onPause() {
        mShimmerViewContainer.stopShimmerAnimation();

        super.onPause();
    }

    public void onStop(){
        super.onStop();
//        handler.removeCallbacksAndMessages(null);

    }


    @Override
    public void slider_list(ArrayList<Slider_model.SliderList> list) {
//        if(list.size()>0) {
//            top_recycler.setVisibility(View.VISIBLE);
//            llmain.setVisibility(View.VISIBLE);
//            sliderLists.clear();
//            sliderLists.addAll(list);
//            topAdapter.notifyDataSetChanged();
//
//            // stop animating Shimmer and hide the layout
//            mShimmerViewContainer.stopShimmerAnimation();
//            mShimmerViewContainer.setVisibility(View.GONE);
//        }
    }

    @Override
    public void recent_video(ArrayList<Slider_model.RecentVideo> list) {
        if(list.size()>0){
            continue_watching.setVisibility(View.VISIBLE);
            recycleview_recent_video.setVisibility(View.VISIBLE);
            recentVideos.clear();
            recentVideos.addAll(list);
            recycleview_recent_video.getAdapter().notifyDataSetChanged();
        }
        rl_top.setVisibility(View.VISIBLE);

    }

    @Override
    public void primevideo_list(ArrayList<Slider_model.PremiumVideoList> list) {
        if(list.size()>0) {
            premium_video.setVisibility(View.VISIBLE);
            primevideoLists.clear();
            primevideoLists.addAll(list);
            recyclerView_Premimvideo.getAdapter().notifyDataSetChanged();
        }

    }

    @Override
    public void FreeVideo_list(ArrayList<Slider_model.FreeVideoList> list) {

        if(list.size()>0) {

            free_video.setVisibility(View.VISIBLE);
            FreeVideo_list.clear();
            FreeVideo_list.addAll(list);
            recycleviewpremiun_.getAdapter().notifyDataSetChanged();
        }
    }

    @Override
    public void MyCommunityUsersList_list(ArrayList<Slider_model.MyCommunityUsersList> list) {

        if(list.size()>0) {
//            my_community.setVisibility(View.VISIBLE);
            MyCommunityUsersList_list.clear();
            MyCommunityUsersList_list.addAll(list);
            recycleviewmycommunity.getAdapter().notifyDataSetChanged();
        }


    }

    @Override
    public void SocialCommunityUser_list(ArrayList<Slider_model.SocialCommunityUser> list) {

        if(list.size()>0) {
            social_community.setVisibility(View.VISIBLE);
            SocialCommunityUser_list.clear();
            SocialCommunityUser_list.addAll(list);
            recycleviewsocal_commnicate.getAdapter().notifyDataSetChanged();


//            SocialManaager = new GridLayoutManager(getActivity(), 4,GridLayoutManager.HORIZONTAL, false);
//            recycleviewsocal_commnicate.setLayoutManager(SocialManaager);

             SocialManaager = new GridLayoutManager(getContext(),1,GridLayoutManager.HORIZONTAL,false) {

                @Override
                public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                    try {
                        LinearSmoothScroller smoothScroller = new LinearSmoothScroller(getContext()) {
                            private static final float SPEED = 3500f;// Change this value (default=25f)

                            @Override
                            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                                return SPEED / displayMetrics.densityDpi;
                            }
                        };
                        smoothScroller.setTargetPosition(position);
                        startSmoothScroll(smoothScroller);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            //  LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            autoScrollAnother();
            SocialManaager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recycleviewsocal_commnicate.setLayoutManager(SocialManaager);
            recycleviewsocal_commnicate.setHasFixedSize(true);
            recycleviewsocal_commnicate.setItemViewCacheSize(1000);
            recycleviewsocal_commnicate.setDrawingCacheEnabled(true);
            recycleviewsocal_commnicate.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
            recycleviewsocal_commnicate.setAdapter(socialCommunity_adapter);

//            socialCommunity_adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//                @Override
//                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                    Toast.makeText(getContext(), "Item clicked", Toast.LENGTH_LONG).show();
//                }
//            });


        }
    }


    /**
     * Autoscroll detected from here, where counter, time and runnable is declared.
     */
    public void autoScrollAnother() {
        scrollCount = 0;
         handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                recycleviewsocal_commnicate.smoothScrollToPosition((scrollCount++));
                if (scrollCount == socialCommunity_adapter.getItemCount() - 4) {
//                    stockListModels.addAll(stockListModels);
                    socialCommunity_adapter.notifyDataSetChanged();
                }
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runnable, 1000);
    }

    @Override
    public void onClick(View v) {
//        if (v == catseeall) {
//            Fragment fragment = new All_category_seeall();
//            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
//
//        }

    }






}
