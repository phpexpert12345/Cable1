package cable.social.app.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.content.CursorLoader;

import com.bumptech.glide.Glide;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import butterknife.BindView;
import butterknife.OnClick;
import cable.social.app.Interface.VideoUploadInterface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;

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

import cable.social.app.video_filter.App;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class CreateIntroVideoActivity extends AppCompatActivity implements VideoUploadInterface {
    ImageView upload_introvideo, upload, imageView;
//    File videofile, imagefile;
    File  imagefile;
    EditText add_descri, tital;
    Button uploadnow;
    private static final int BUFFER_SIZE = 1024 * 3;
    private static final String IMAGE_DIRECTORY = "/demonuts_upload_gallery";

    private String mVideoPath;
    private String mVideoThumb;


    FrameLayout mFlVideo;
    VideoView mVideoView;
    ImageView mIvThumb;
    ImageView mIvPlay;
    LinearLayout ll_video;



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_intro_video);
        upload_introvideo = findViewById(R.id.upload_introvideo);


        mVideoPath = getIntent().getStringExtra("path");
        mVideoThumb = getIntent().getStringExtra("thumb");



        add_descri = findViewById(R.id.add_descri);
        tital = findViewById(R.id.tital);
        uploadnow = findViewById(R.id.uploadnow);
        upload = findViewById(R.id.upload);
        imageView = findViewById(R.id.imageView);

        mFlVideo = (FrameLayout)findViewById(R.id.fl);
        mVideoView = (VideoView)findViewById(R.id.videoView);
        mIvThumb = (ImageView)findViewById(R.id.iv_thumb);
        mIvPlay = (ImageView) findViewById(R.id.iv_play);
        ll_video = (LinearLayout) findViewById(R.id.ll_video);


        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showpictures(this);
            }
        });

        uploadnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               uploadData();

            }
        });


        mVideoView.setVideoPath(mVideoPath);
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                ViewGroup.LayoutParams lp = mVideoView.getLayoutParams();
                int videoWidth = mp.getVideoWidth();
                int videoHeight = mp.getVideoHeight();
                float videoProportion = (float) videoWidth / (float) videoHeight;
                int screenWidth = mFlVideo.getWidth();
                int screenHeight = mFlVideo.getHeight();
                float screenProportion = (float) screenWidth / (float) screenHeight;
                if (videoProportion > screenProportion) {
                    lp.width = screenWidth;
                    lp.height = (int) ((float) screenWidth / videoProportion);
                } else {
                    lp.width = (int) (videoProportion * (float) screenHeight);
                    lp.height = screenHeight;
                }
                mVideoView.setLayoutParams(lp);

                Log.e("videoView",
                        "videoWidth:" + videoWidth + ", videoHeight:" + videoHeight);
            }
        });
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mIvPlay.setVisibility(View.VISIBLE);
                mIvThumb.setVisibility(View.VISIBLE);
                Glide.with(App.sApplication)
                        .load(mVideoThumb)
                        .into(mIvThumb);
            }
        });
        videoStart();


        mIvPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIvThumb.setVisibility(View.GONE);
                mIvPlay.setVisibility(View.GONE);
                videoStart();
            }
        });

        ll_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the input method manager
                InputMethodManager inputMethodManager = (InputMethodManager)
                        view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                // Hide the soft keyboard
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
            }
        });



    }


    public void uploadData(){
        String livedate= (String) android.text.format.DateFormat.format("yyyy-MM-dd hh:mm:ss", new java.util.Date());
        Log.d("goo..",livedate);

        RequestBody customer_id = RequestBody.create(MediaType.parse("multipart/form-data"), CSPreferences.readString(CreateIntroVideoActivity.this, "auth_key"));
        RequestBody title = RequestBody.create(MediaType.parse("multipart/form-data"), tital.getText().toString());
        RequestBody summary = RequestBody.create(MediaType.parse("multipart/form-data"), add_descri.getText().toString());
        RequestBody live_started_at = RequestBody.create(MediaType.parse("multipart/form-data"), livedate);
        RequestBody token = RequestBody.create(MediaType.parse("multipart/form-data"), CSPreferences.readString(CreateIntroVideoActivity.this, "tooken"));
        RequestBody videoFile;
        MultipartBody.Part videobody = null;


        RequestBody imagerequestFile;
        MultipartBody.Part imagebody = null;
        if (imagefile == null) {
            GlobalClass.showtost(CreateIntroVideoActivity.this, "Select your image");

        } else {
            imagerequestFile = RequestBody.create(MediaType.parse("multipart/form-data"), imagefile);
            imagebody = MultipartBody.Part.createFormData("intro_thumnail", imagefile.getName(), imagerequestFile);

        }
        if (mVideoPath == null) {
            GlobalClass.showtost(CreateIntroVideoActivity.this, "Select your video");

        } else {

            File vFile = new File(mVideoPath);

            videoFile = RequestBody.create(MediaType.parse("multipart/form-data"), vFile);
            videobody = MultipartBody.Part.createFormData("intro_video", vFile.getName(), videoFile);

        }

        WebapiCall webApicall = new WebapiCall();
        webApicall.customerIntroVideoCreate(CreateIntroVideoActivity.this, customer_id, title, summary, live_started_at, token, videobody, imagebody,this);
    }







    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.requestCode == requestCode && resultCode == RESULT_OK) {
            Uri picUri = data.getData();
            imagefile = new File(getPaths(picUri));
            Log.d("imagegallary", String.valueOf(imagefile));
            imageView.setImageURI(picUri);

        }
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
            Uri tempUri = getImageUri(this, photo);
            imagefile = new File(getRealPathFromURI(tempUri));
            Log.d("imagecamera", String.valueOf(imagefile));

        }
    }




    // Select image
    private final int requestCode = 10;
    private static final int CAMERA_REQUEST = 188;

    public void showpictures(View.OnClickListener activity) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);


        dialog.setTitle(getResources().getString(R.string.txt_slct_optionn));
        String[] items = {getResources().getString(R.string.txt_gelleryy),
                getResources().getString(R.string.txt_camerayy), getResources()
                .getString(R.string.txt_warningg)};
        // dialog.setMessage("*for your security reason we blocked!");
        dialog.setItems(items, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                switch (which) {
                    case 0:
                        showFileChoosesr();
                        break;
                    case 1:
                        takePhotoFromCameras();
                        break;
                }
            }
        });
        dialog.show();
    }

    private void takePhotoFromCameras() {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);

    }

    private void showFileChoosesr() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,

                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent

        startActivityForResult(galleryIntent, requestCode);

    }

    private String getPaths(Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(this, contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }


    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }




    public void videoStart() {
        mVideoView.start();
    }

    public void videoPause() {
        if (mVideoView != null && mVideoView.isPlaying()) {
            mVideoView.pause();
        }
    }

    public void videoDestroy() {
        if (mVideoView != null) {
            mVideoView.stopPlayback();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //全屏显示

            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoDestroy();
    }


    @Override
    public void closeActivity() {
finish();
    }
}
