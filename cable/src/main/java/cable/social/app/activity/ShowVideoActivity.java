package cable.social.app.activity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import cable.social.app.R;
import cable.social.app.databinding.ActivityShowVideoBinding;
import cable.social.app.utility.BaseActivity;

public class ShowVideoActivity extends BaseActivity {
    ActivityShowVideoBinding binding;
    String videoURL = "https://www.radiantmediaplayer.com/media/bbb-360p.mp4";
    private SimpleExoPlayer exoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_show_video);


        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            videoURL = extras.getString("video");
            String video = extras.getString("videoThumbnail");

        }
//        Toast.makeText(this, videoURL, Toast.LENGTH_SHORT).show();
        try {
            DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
            TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
            exoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector);
            Uri videoURI = Uri.parse(videoURL);
            DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("exoplayer_video");
            ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
            MediaSource mediaSource = new ExtractorMediaSource(videoURI, dataSourceFactory, extractorsFactory, null, null);
            binding.andExoPlayerView.setPlayer(exoPlayer);
            exoPlayer.prepare(mediaSource);
            exoPlayer.setPlayWhenReady(true);
        } catch (Exception e) {
            Log.e("MainAcvtivity", " exoplayer error " + e.toString());
        }

    }

    @Override
    public void initData() {

        binding.toolBar.menuBtn.setVisibility(View.GONE);
        binding.toolBar.tvToolbarTitle.setVisibility(View.GONE);
        // binding.toolBar.tvToolbarTitle.setText(R.string.my_intro);
        binding.toolBar.search.setVisibility(View.GONE);
        binding.toolBar.imageView10.setVisibility(View.GONE);


    }

    @Override
    public void initListeners() {
        binding.toolBar.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        {

        }
    }
}