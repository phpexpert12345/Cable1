package cable.social.app.video_filter.ui.activity;

import android.content.Context;
import android.content.Intent;


import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//import butterknife.BindView;
import butterknife.BindView;
import cable.social.app.R;
import cable.social.app.video_filter.adapter.VideoGridAdapter;
import cable.social.app.video_filter.base.BaseActivity;
import cable.social.app.video_filter.helper.ToolbarHelper;
import cable.social.app.video_filter.model.LocalVideoModel;
import cable.social.app.video_filter.utils.VideoUtil;
import cable.social.app.video_filter.view.DividerGridItemDecoration;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author LLhon
 * @Project Android-Video-Editor
 * @Package com.marvhong.videoeditor
 * @Date 2018/8/21 15:16
 * @description 视频相册界面
 */
public class VideoAlbumActivity extends BaseActivity implements VideoGridAdapter.OnItemClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private List<LocalVideoModel> mLocalVideoModels = new ArrayList<>();
    private VideoGridAdapter mAdapter;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, VideoAlbumActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_album;
    }

    @Override
    protected void initToolbar(ToolbarHelper toolbarHelper) {
        toolbarHelper.setTitle("Photo album");
    }

    @Override
    protected void initView() {

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        mAdapter = new VideoGridAdapter(this, mLocalVideoModels);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    protected void initData() {
        VideoUtil.getLocalVideoFiles(this)
            .subscribe(new Observer<ArrayList<LocalVideoModel>>() {
                @Override
                public void onSubscribe(Disposable d) {
                    subscribe(d);
                }

                @Override
                public void onNext(ArrayList<LocalVideoModel> localVideoModels) {
                    mLocalVideoModels = localVideoModels;
                    mAdapter.setData(mLocalVideoModels);
                }

                @Override
                public void onError(Throwable e) {
                    e.printStackTrace();
                }

                @Override
                public void onComplete() {

                }
            });
    }

    @Override
    public void onItemClick(int position, LocalVideoModel model) {
        Intent intent = new Intent(this, TrimVideoActivity.class);
        intent.putExtra("videoPath", model.getVideoPath());
        startActivityForResult(intent, 100);
        finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mLocalVideoModels = null;
    }
}
