package cable.social.app.video_filter.ui.activity;

import android.Manifest.permission;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;

import cable.social.app.R;
import cable.social.app.video_filter.base.BaseActivity;
import cable.social.app.video_filter.helper.ToolbarHelper;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class VideoActivity extends BaseActivity {

    private RxPermissions mRxPermissions;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initToolbar(ToolbarHelper toolbarHelper) {
        toolbarHelper.setTitle("Video Editor");
        toolbarHelper.hideBackArrow();
    }

    @Override
    protected void initView() {
        mRxPermissions = new RxPermissions(this);
    }

    /**
     * 拍照
     * @param view
     */


    public void takeCamera(View view) {
        mRxPermissions
            .request(permission.WRITE_EXTERNAL_STORAGE, permission.RECORD_AUDIO, permission.CAMERA)
            .subscribe(new Observer<Boolean>() {
                @Override
                public void onSubscribe(Disposable d) {
                    subscribe(d);
                }

                @Override
                public void onNext(Boolean granted) {
                    if (granted) { //已获取权限
                        Intent intent = new Intent(VideoActivity.this, VideoCameraActivity.class);
//                        startActivityForResult(intent, 100);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(VideoActivity.this, "\n" +
                                "Is it possible to give permission?", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onComplete() {

                }
            });
    }

    /**
     * 相册
     * @param view
     */
    public void takeAlbum(View view) {
        mRxPermissions
            .request(permission.WRITE_EXTERNAL_STORAGE, permission.READ_EXTERNAL_STORAGE)
            .subscribe(new Observer<Boolean>() {
                @Override
                public void onSubscribe(Disposable d) {
                    subscribe(d);
                }

                @Override
                public void onNext(Boolean granted) {
                    if (granted) { //已获取权限
                        Intent intent = new Intent(VideoActivity.this, VideoAlbumActivity.class);
                        startActivityForResult(intent, 100);
                        finish();
                    } else {
                        Toast.makeText(VideoActivity.this, "\n" +
                                "Is it possible to give permission?", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onComplete() {

                }
            });
    }
}
