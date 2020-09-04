package cable.social.app.fragments;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;

import com.quickblox.users.model.QBUser;

import java.util.ArrayList;

import cable.social.app.R;
import cable.social.app.activity.CallActivity;


public class ScreenShareFragment extends BaseToolBarFragment {

    public static final String TAG = ScreenShareFragment.class.getSimpleName();
    private OnSharingEvents onSharingEvents;
    private CallActivity.CurrentCallStateCallback currentCallStateCallback;
  //  String videoURL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4";
    SimpleExoPlayer exoPlayer;
    SimpleExoPlayerView exoPlayerView;
    VideoView videoView;
    private static final String VIDEO_SAMPLE =
            "https://developers.google.com/training/images/tacoma_narrows.mp4";

   // private VideoView mVideoView;
    //private TextView mBufferingTextView;

    // Current playback position (in milliseconds).
    private int mCurrentPosition = 0;

    // Tag for the instance state bundle.
    private static final String PLAYBACK_TIME = "play_time";
    ImageView stop_screen_share;

    public static ScreenShareFragment newInstance() {
        return new ScreenShareFragment();
    }

    @Override
    int getFragmentLayout() {
        return R.layout.fragment_pager;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ImagesAdapter adapter = new ImagesAdapter(getChildFragmentManager());
        videoView = (VideoView)view.findViewById(R.id.videoView);

        stop_screen_share = view.findViewById(R.id.stop_screen_share);

        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(PLAYBACK_TIME);
        }
        Uri uri = Uri.parse(VIDEO_SAMPLE);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                //close the progress dialog when buffering is done
               // pd.dismiss();
            }
        });

        toolbar.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));

        stop_screen_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Stop Screen Sharing");
                if (onSharingEvents != null) {
                    onSharingEvents.onStopPreview();
                }
            }
        });
        return view;
    }









    // Get a Uri for the media sample regardless of whether that sample is
    // embedded in the app resources or available on the internet.


    @Override
    public void onResume() {
        super.onResume();
        currentCallStateCallback = new CurrentCallStateCallbackImpl();
        ((CallActivity) getActivity()).addCurrentCallStateListener(currentCallStateCallback);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onSharingEvents = (OnSharingEvents) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement OnSharingEvents");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onSharingEvents = null;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (currentCallStateCallback != null) {
            ((CallActivity) getActivity()).removeCurrentCallStateListener(currentCallStateCallback);
        }
    }

    public static class ImagesAdapter extends FragmentPagerAdapter {
        private static final int NUM_ITEMS = 4;

        private int[] images = {R.drawable.pres_img, R.drawable.p2p, R.drawable.group_call, R.drawable.opponents};

        public ImagesAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            return PreviewFragment.newInstance(images[position]);
        }
    }

    private class CurrentCallStateCallbackImpl implements CallActivity.CurrentCallStateCallback {
        @Override
        public void onCallStarted() {

        }

        @Override
        public void onCallStopped() {

        }

        @Override
        public void onOpponentsListUpdated(ArrayList<QBUser> newUsers) {

        }

        @Override
        public void onCallTimeUpdate(String time) {
            toolbar.setTitle("");
            TextView timerTextView = toolbar.findViewById(R.id.timer_call);
            timerTextView.setVisibility(View.VISIBLE);
            timerTextView.setText(time);
        }
    }

    public interface OnSharingEvents {
        void onStopPreview();
    }
}