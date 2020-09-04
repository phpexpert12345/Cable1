package cable.social.app.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.cjt2325.cameralibrary.util.FileUtil;
import com.iceteck.silicompressorr.SiliCompressor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import cable.social.app.Interface.Category_interface;
import cable.social.app.Interface.VideoUploadInterface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.model.Category_model;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;
import cable.social.app.video_filter.ui.activity.TrimVideoActivity;
import cable.social.app.video_filter.utils.ExtractVideoInfoUtil;
import cable.social.app.video_filter.utils.VideoUtil;
import cable.social.app.video_filter.view.NormalProgressDialog;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class EpisodInfoActivity extends AppCompatActivity implements View.OnClickListener, VideoUploadInterface, Category_interface, AdapterView.OnItemSelectedListener {

    Button submit_btn;
    EditText season_title_et, desc_et, episod_title_et, date_et, Series_name, Season_number;
    String Date;
    ImageView back;

    File videofile, CoverImagefile, PhotoImageFile;
    ImageView Upload_Cover, Upload_photo, UploadVideo;
    RelativeLayout CoverRL;

    int type = -1;
    private static final int BUFFER_SIZE = 1024 * 3;

    LinearLayout selected_video_ll, upload_video_ll;

    private static final String IMAGE_DIRECTORY = "/demonuts_upload_gallery";

    private static final String TAG = EpisodInfoActivity.class.getSimpleName();


    private CompositeDisposable mDisposables = new CompositeDisposable();
    String compressedFilePath;

    ArrayAdapter cat_spnr_adapter;
    List<String> cat_list = new ArrayList<>();
    List<Category_model.CategoyList> categoyLists = new ArrayList<>();

    int cat_item_id = 0;

    Spinner cat_spinner;

    Calendar myCalendar;

    int From = -1;
    String Series_id = "", Season_id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episod_info);
        getViewId();

        myCalendar = Calendar.getInstance();


        Intent intent = getIntent();

        if (intent.getIntExtra("from", -1) == 0) {
            From = 0;

            Season_number.setVisibility(View.GONE);

        } else if (intent.getIntExtra("from", -1) == 1) {
            From = 1;
            CoverRL.setVisibility(View.GONE);
            Series_name.setVisibility(View.GONE);
            Series_id = intent.getStringExtra("series_id");

        } else if (intent.getIntExtra("from", -1) == 2) {

            From = 2;
            season_title_et.setVisibility(View.GONE);
            desc_et.setVisibility(View.GONE);
            CoverRL.setVisibility(View.GONE);
            Series_name.setVisibility(View.GONE);
            Season_number.setVisibility(View.GONE);
            season_title_et.setVisibility(View.GONE);


            Series_id = intent.getStringExtra("series_id");
            Season_id = intent.getStringExtra("season_id");
        }

    }

    private void getViewId() {
        submit_btn = findViewById(R.id.submit_btn);
        season_title_et = findViewById(R.id.title_et);
        desc_et = findViewById(R.id.desc_et);
        Season_number = findViewById(R.id.season_number);
        episod_title_et = findViewById(R.id.episod_title_et);
        date_et = findViewById(R.id.date_et);
        upload_video_ll = findViewById(R.id.upload_video_ll);
        selected_video_ll = findViewById(R.id.selected_video_ll);
        back = findViewById(R.id.back);

        Upload_Cover = findViewById(R.id.upload_cover);
        Upload_photo = findViewById(R.id.upload_photo);
        UploadVideo = findViewById(R.id.upload_video);

        cat_spinner = findViewById(R.id.cat_ep_spnr);

        Series_name = findViewById(R.id.series_name_et);

        CoverRL = findViewById(R.id.cover_ll);


        Upload_Cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showpictures(this);
                type = 0;
            }
        });

        Upload_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showpictures(this);
                type = 1;
            }
        });


        UploadVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showpicture(this);
            }
        });


        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        date_et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(EpisodInfoActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        cat_spinner.setOnItemSelectedListener(this);


        if (GlobalClass.isNetworkConnected(this)) {
            WebapiCall categorylist = new WebapiCall();
            categorylist.category_listEpisode(this, this, CSPreferences.readString(this, "tooken"));
        } else {
            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }


        setListners();
    }

    private void updateLabel() {

        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        Date = sdf.format(myCalendar.getTime());

        date_et.setText(Date);

    }

    private void setListners() {
        submit_btn.setOnClickListener(this);
        back.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submit_btn:
                uploadData();
                break;
            case R.id.back:
                finish();
                break;
        }
    }


    public void showpicture(View.OnClickListener activity) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(getResources().getString(R.string.txt_slct_option));
        String[] items = {getResources().getString(R.string.txt_gellery),
                getResources().getString(R.string.txt_cameray), getResources()
                .getString(R.string.txt_warning)};

        // dialog.setMessage("*for your security reason we blocked!");
        dialog.setItems(items, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                switch (which) {
                    case 0:
                        showFileChooser();
                        break;
                    case 1:
                        takePhotoFromCamera();
                        break;
                }
            }
        });
        dialog.show();
    }


    private final int GALERY_REQUEST_VIDEO = 20;
    private static final int REQUEST_VIDEO_CAPTURE = 1888;


    private void takePhotoFromCamera() {
        Intent videoCaptureIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (videoCaptureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(videoCaptureIntent, REQUEST_VIDEO_CAPTURE);
        }

    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Video"), GALERY_REQUEST_VIDEO);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.requestCoverCode == requestCode && resultCode == RESULT_OK) {
            Uri picUri = data.getData();


            if (type == 0) {
                CoverImagefile = new File(getPaths(picUri));
                Log.d("imagegallary", String.valueOf(CoverImagefile));
                Upload_Cover.setImageURI(picUri);
            } else if (type == 1) {
                PhotoImageFile = new File(getPaths(picUri));
                Log.d("imagegallary", String.valueOf(PhotoImageFile));
                Upload_photo.setImageURI(picUri);
            }
        }
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
//            Upload_Cover.setImageBitmap(photo);

            if (type == 0) {
                Upload_Cover.setImageBitmap(photo);
                Uri tempUri = getImageUri(this, photo);
                CoverImagefile = new File(getRealPathFromURI(tempUri));
                Log.d("imagecamera", String.valueOf(CoverImagefile));

            } else if (type == 1) {
                Upload_photo.setImageBitmap(photo);
                Uri tempUri = getImageUri(this, photo);
                PhotoImageFile = new File(getRealPathFromURI(tempUri));
                Log.d("imagecamera", String.valueOf(PhotoImageFile));

            }


        }
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
           /* videofile =new  File(getPath(uri));
            videofile = new File(
                    Environment.getExternalStorageDirectory()
                            .toString());
            Log.d("Dsfdf",videofile.getName());*/

            //  pathToStoredVideo = getRealPathFromURIPath(uri, CreateIntroVideoActivity.this);
            //Log.d("Dsfdf", pathToStoredVideo);

            videofile = new File(getFilePathFromURI(EpisodInfoActivity.this, uri));
            Log.d("gooooo", videofile.toString());
            compressVideo(videofile.toString());


        } else {
            if (requestCode == GALERY_REQUEST_VIDEO && resultCode == Activity.RESULT_OK) {
                Uri contentURI = null;
                if (data != null) {
                    contentURI = data.getData();
                }
                //   pathToStoredVideo = getPath(contentURI);

                //pathToStoredVideo = getRealPathFromURIPath(contentURI, CreateIntroVideoActivity.this);
                // videofile = new File(getRealPathFromURIPath(contentURI, CreateIntroVideoActivity.this));
                videofile = new File(getFilePathFromURI(EpisodInfoActivity.this, contentURI));
                // MEDIA GALLERY
                // String   selectedImagePath = getPath(contentURI);
                Log.d("Dsfdf", videofile.toString());
                //     val selectedVideoPath = getPath(contentURI !!)

                compressVideo(videofile.toString());

            }
        }
    }


    private void compressVideo(String srcPath) {
        NormalProgressDialog
                .showLoading(this, getResources().getString(R.string.video_compress), false);

        selected_video_ll.setVisibility(View.VISIBLE);
        upload_video_ll.setVisibility(View.GONE);

        String destDirPath = VideoUtil.getTrimmedVideoDir(this, "small_video");
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) {
                try {
                    int outWidth = 0;
                    int outHeight = 0;
//                    if (mOriginalWidth > mOriginalHeight) {
//                        //Horizontal screen
//                        outWidth = 720;
//                        outHeight = 480;
//                    } else {
                    //Portrait
                    outWidth = 480;
                    outHeight = 720;
//                    }
                    compressedFilePath = SiliCompressor.with(EpisodInfoActivity.this).compressVideo(srcPath, destDirPath, outWidth, outHeight, 900000);
                    emitter.onNext(compressedFilePath);
                } catch (Exception e) {
                    emitter.onError(e);
                }
                emitter.onComplete();
            }
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        subscribe(d);
                    }

                    @Override
                    public void onNext(String outputPath) {

                        File file = new File(outputPath);
                        //Source path: /storage/emulated/0/Android/data/com.kangoo.diaoyur/cache/small_video/trimmedVideo_20180514_163858.mp4
                        //Compressed path: /storage/emulated/0/Android/data/com.kangoo.diaoyur/cache/small_video/VIDEO_20180514_163859.mp4
                        Log.e(TAG, "compressVideo---onSuccess " + (file.length() / 1024 * 1024));

                        NormalProgressDialog.stopLoading();


//                        "Header required
//                        apikey: base64:ATC+vljhHr3GdKMD7j69utCF+hUoaISYHwyFxBhOztI=
//                                Authorization:required
//
//                        video_title:ORM Relationship larvel video
//                        customer_id:3
//                        video_file:
//                        movie_category:2
//                        movie_thumbnail:
//                        movie_poster:
//                        duration:2hr
//                        movie_language:2
//                        video_access:1
//                        video_description:this is testig video details
//                        release_date:2020"


                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.e(TAG, "compressVideo---onError:" + e.toString());
                        NormalProgressDialog.stopLoading();
                        Toast.makeText(EpisodInfoActivity.this, "Video compression failed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public void subscribe(Disposable disposable) {
        mDisposables.add(disposable);
    }


    public void uploadData() {
//        String livedate= (String) android.text.format.DateFormat.format("yyyy-MM-dd hh:mm:ss", new java.util.Date());
//        Log.d("goo..",livedate);

        RequestBody video_title = RequestBody.create(MediaType.parse("multipart/form-data"), episod_title_et.getText().toString());
        RequestBody customer_id = RequestBody.create(MediaType.parse("multipart/form-data"), CSPreferences.readString(EpisodInfoActivity.this, "auth_key"));
        RequestBody movie_category = RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(cat_item_id));


        RequestBody video_access = RequestBody.create(MediaType.parse("multipart/form-data"), "Free");
        RequestBody release_date = RequestBody.create(MediaType.parse("multipart/form-data"), Date);
        RequestBody language = RequestBody.create(MediaType.parse("multipart/form-data"), "1");

        RequestBody air_date = RequestBody.create(MediaType.parse("multipart/form-data"), Date);
        RequestBody video_type = RequestBody.create(MediaType.parse("multipart/form-data"), "1");


//        RequestBody movie_language = RequestBody.create(MediaType.parse("multipart/form-data"), "1");
//
//        RequestBody duration = RequestBody.create(MediaType.parse("multipart/form-data"), "3hr");
//        RequestBody video_access = RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(cat_item_id));


        RequestBody token = RequestBody.create(MediaType.parse("multipart/form-data"), CSPreferences.readString(EpisodInfoActivity.this, "tooken"));
        RequestBody videoFile;
        MultipartBody.Part videobody = null;


        RequestBody imagerequestFile, imagerequestFile1;
        MultipartBody.Part PhotoImage = null, coverimagebody1 = null;
        if (PhotoImageFile == null) {
            GlobalClass.showtost(EpisodInfoActivity.this, "Select your image");

        } else {
            imagerequestFile = RequestBody.create(MediaType.parse("multipart/form-data"), PhotoImageFile);
            PhotoImage = MultipartBody.Part.createFormData("movie_thumbnail", PhotoImageFile.getName(), imagerequestFile);

        }
        if (CoverImagefile == null) {
            if (From == 0) {
                GlobalClass.showtost(EpisodInfoActivity.this, "Select your image");
                return;
            }

        } else {
            imagerequestFile1 = RequestBody.create(MediaType.parse("multipart/form-data"), CoverImagefile);
            coverimagebody1 = MultipartBody.Part.createFormData("season_image", CoverImagefile.getName(), imagerequestFile1);

        }
        if (compressedFilePath == null) {
            GlobalClass.showtost(EpisodInfoActivity.this, "Select your video");

        } else if (cat_item_id == 0) {
            GlobalClass.showtost(EpisodInfoActivity.this, "Select Video Genre");

        } else {
            File vFile = new File(compressedFilePath);
            videoFile = RequestBody.create(MediaType.parse("multipart/form-data"), vFile);
            videobody = MultipartBody.Part.createFormData("video_file", vFile.getName(), videoFile);

            WebapiCall webApicall = new WebapiCall();

            if (From == 0) {

                RequestBody season_title = RequestBody.create(MediaType.parse("multipart/form-data"), season_title_et.getText().toString());
                RequestBody season_description = RequestBody.create(MediaType.parse("multipart/form-data"), desc_et.getText().toString());
                RequestBody season_number = RequestBody.create(MediaType.parse("multipart/form-data"), "1");
                RequestBody series_name = RequestBody.create(MediaType.parse("multipart/form-data"), Series_name.getText().toString());

                webApicall.uploadNewSeries(EpisodInfoActivity.this, token, video_title, customer_id, movie_category, PhotoImage, videobody, video_access, release_date, language, season_number, season_title, coverimagebody1, season_description, air_date, video_type, series_name, this);

            } else if (From == 1) {

                RequestBody season_title = RequestBody.create(MediaType.parse("multipart/form-data"), season_title_et.getText().toString());
                RequestBody season_description = RequestBody.create(MediaType.parse("multipart/form-data"), desc_et.getText().toString());
                RequestBody season_number = RequestBody.create(MediaType.parse("multipart/form-data"), Season_number.getText().toString());
                RequestBody series_ID = RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(Series_id));

                webApicall.uploadNewSeason(EpisodInfoActivity.this, token, video_title, customer_id, movie_category, PhotoImage, videobody, video_access, release_date, language, season_number, season_title, coverimagebody1, season_description, air_date, video_type, series_ID, this);

            } else if (From == 2) {

                RequestBody series_ID = RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(Series_id));
                RequestBody seasonID = RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(Season_id));

                webApicall.uploadNewEpisode(EpisodInfoActivity.this, token, video_title, customer_id, movie_category, PhotoImage, videobody, video_access, release_date, language, series_ID, seasonID, video_type, this);

            }


        }
    }


    private String pathToStoredVideo;

    private String getRealPathFromURIPath(Uri contentURI, Activity activity) {
        Cursor cursor = activity.getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) {
            return contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(idx);
        }
    }


    // UPDATED!
    public String getPath(Uri uri) {
        String[] projection = {MediaStore.Video.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            // HERE YOU WILL GET A NULLPOINTER IF CURSOR IS NULL
            // THIS CAN BE, IF YOU USED OI FILE MANAGER FOR PICKING THE MEDIA
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } else
            return null;
    }


    // Select image
    private final int requestCoverCode = 10;
    private final int requestPhotoCode = 20;
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
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);

    }

    private void showFileChoosesr() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,

                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        // Start the Intent

        startActivityForResult(galleryIntent, requestCoverCode);

//        if (type == 0) {
//        } else if (type == 1) {
//            startActivityForResult(galleryIntent, requestPhotoCode);
//
//        }

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


    public static String getFilePathFromURI(Context context, Uri contentUri) {
        //copy file and send new file path

        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();
        }

        File copyFile = new File(wallpaperDirectory + File.separator + Calendar.getInstance()
                .getTimeInMillis() + ".mp4");
        // create folder if not exists

        copy(context, contentUri, copyFile);
        Log.d("vPath--->", copyFile.getAbsolutePath());

        return copyFile.getAbsolutePath();

    }

    public static void copy(Context context, Uri srcUri, File dstFile) {
        try {
            InputStream inputStream = context.getContentResolver().openInputStream(srcUri);
            if (inputStream == null) return;
            OutputStream outputStream = new FileOutputStream(dstFile);
            copystream(inputStream, outputStream);
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int copystream(InputStream input, OutputStream output) throws Exception, IOException {
        byte[] buffer = new byte[BUFFER_SIZE];

        BufferedInputStream in = new BufferedInputStream(input, BUFFER_SIZE);
        BufferedOutputStream out = new BufferedOutputStream(output, BUFFER_SIZE);
        int count = 0, n = 0;
        try {
            while ((n = in.read(buffer, 0, BUFFER_SIZE)) != -1) {
                out.write(buffer, 0, n);
                count += n;
            }
            out.flush();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                Log.e(e.getMessage(), String.valueOf(e));
            }
            try {
                in.close();
            } catch (IOException e) {
                Log.e(e.getMessage(), String.valueOf(e));
            }
        }
        return count;
    }


    @Override
    public void closeActivity() {
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if (i == 0) {
//            Toast.makeText(this, "Select a Genre", Toast.LENGTH_LONG).show();
            cat_item_id = 0;
        } else {
            cat_item_id = categoyLists.get(i - 1).getId();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    @Override
    public void category_list(ArrayList<Category_model.CategoyList> list) {

        cat_list.clear();
        cat_list.add("Select Genre");
        categoyLists.clear();
        categoyLists.addAll(list);

        for (int i = 0; i < list.size(); i++) {
            cat_list.add(list.get(i).getCategoryName());
        }

        cat_spnr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, cat_list);
        cat_spinner.setAdapter(cat_spnr_adapter);

    }


}