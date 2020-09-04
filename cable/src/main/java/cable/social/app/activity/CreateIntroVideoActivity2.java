package cable.social.app.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.content.CursorLoader;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
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

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class CreateIntroVideoActivity2 extends AppCompatActivity {
    ImageView upload_introvideo, upload, imageView;
    File videofile, imagefile;
    EditText add_descri, tital;
    Button uploadnow;
    private static final int BUFFER_SIZE = 1024 * 3;
    private static final String IMAGE_DIRECTORY = "/demonuts_upload_gallery";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        checkpermissions(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_intro_video);
        upload_introvideo = findViewById(R.id.upload_introvideo);

        upload_introvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showpicture(this);
            }
        });



        add_descri = findViewById(R.id.add_descri);
        tital = findViewById(R.id.tital);
        uploadnow = findViewById(R.id.uploadnow);
        upload = findViewById(R.id.upload);
        imageView = findViewById(R.id.imageView);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showpictures(this);
            }
        });

        uploadnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String livedate= (String) android.text.format.DateFormat.format("yyyy-MM-dd hh:mm:ss", new java.util.Date());
                Log.d("goo..",livedate);

                RequestBody customer_id = RequestBody.create(MediaType.parse("multipart/form-data"), CSPreferences.readString(CreateIntroVideoActivity2.this, "auth_key"));
                RequestBody title = RequestBody.create(MediaType.parse("multipart/form-data"), tital.getText().toString());
                RequestBody summary = RequestBody.create(MediaType.parse("multipart/form-data"), add_descri.getText().toString());
                RequestBody live_started_at = RequestBody.create(MediaType.parse("multipart/form-data"), livedate);
                RequestBody token = RequestBody.create(MediaType.parse("multipart/form-data"), CSPreferences.readString(CreateIntroVideoActivity2.this, "tooken"));
                RequestBody videoFile;
                MultipartBody.Part videobody = null;


                RequestBody imagerequestFile;
                MultipartBody.Part imagebody = null;
                if (imagefile == null) {
                    GlobalClass.showtost(CreateIntroVideoActivity2.this, "Select your image");

                } else {
                    imagerequestFile = RequestBody.create(MediaType.parse("multipart/form-data"), imagefile);
                    imagebody = MultipartBody.Part.createFormData("intro_thumnail", imagefile.getName(), imagerequestFile);

                }
                if (videofile == null) {
                    GlobalClass.showtost(CreateIntroVideoActivity2.this, "Select your video");

                } else {
                    videoFile = RequestBody.create(MediaType.parse("multipart/form-data"), videofile);
                    videobody = MultipartBody.Part.createFormData("intro_video", videofile.getName(), videoFile);

                }

                WebapiCall webApicall = new WebapiCall();
//                webApicall.customerIntroVideoCreate(CreateIntroVideoActivity2.this, customer_id, title, summary, live_started_at, token, videobody, imagebody);

            }
        });


    }

    public void checkpermissions(Activity context) {
        if (Build.VERSION.SDK_INT >= 23) {
            new TedPermission(context)
                    .setPermissionListener(permissionListener)
                    //.setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                    .setPermissions(
                            android.Manifest.permission.INTERNET,
                            android.Manifest.permission.CAMERA,
                            android.Manifest.permission.READ_EXTERNAL_STORAGE,
                            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
                    .check();
        }


    }

    PermissionListener permissionListener = new PermissionListener() {
        @Override
        public void onPermissionGranted() {

        }

        @Override
        public void onPermissionDenied(ArrayList<String> deniedPermissions) {

        }

    };

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
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
           /* videofile =new  File(getPath(uri));
            videofile = new File(
                    Environment.getExternalStorageDirectory()
                            .toString());
            Log.d("Dsfdf",videofile.getName());*/

          //  pathToStoredVideo = getRealPathFromURIPath(uri, CreateIntroVideoActivity.this);
            //Log.d("Dsfdf", pathToStoredVideo);

            videofile = new File(getFilePathFromURI( CreateIntroVideoActivity2.this,uri));
            Log.d("gooooo", videofile.toString());

        } else {
            if (requestCode == GALERY_REQUEST_VIDEO && resultCode == Activity.RESULT_OK) {
                Uri contentURI = null;
                if (data != null) {
                    contentURI = data.getData();
                }
                //   pathToStoredVideo = getPath(contentURI);

                //pathToStoredVideo = getRealPathFromURIPath(contentURI, CreateIntroVideoActivity.this);
               // videofile = new File(getRealPathFromURIPath(contentURI, CreateIntroVideoActivity.this));
                videofile = new File(getFilePathFromURI( CreateIntroVideoActivity2.this,contentURI));
                // MEDIA GALLERY
                // String   selectedImagePath = getPath(contentURI);
                Log.d("Dsfdf", videofile.toString());
                //     val selectedVideoPath = getPath(contentURI !!)

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
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);

    }

    private void showFileChoosesr() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,

                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
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


    public static String getFilePathFromURI(Context context, Uri contentUri) {
        //copy file and send new file path

        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();
        }

        File copyFile = new File(wallpaperDirectory + File.separator + Calendar.getInstance()
                .getTimeInMillis()+".mp4");
        // create folder if not exists

        copy(context, contentUri, copyFile);
        Log.d("vPath--->",copyFile.getAbsolutePath());

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

}
