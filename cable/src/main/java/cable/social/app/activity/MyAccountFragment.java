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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.loader.content.CursorLoader;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

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

import cable.social.app.Interface.Account_profile;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.adadpter.Recent_video_Adapter;
import cable.social.app.adadpter.TabsAdapter;
import cable.social.app.fragment.Memberships;
import cable.social.app.model.CustomerInfo_pojo;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MyAccountFragment extends Fragment implements View.OnClickListener, Account_profile {
    ArrayList<CustomerInfo_pojo.Datum> arrayList = new ArrayList<>();
    ImageView profile_image, edit_iv, cover_image;
    TextView name, followers_, followersing, like_, emailtextView;
    RecyclerView watiching;
    Recent_video_Adapter recent_video_adapter;
    private RelativeLayout relativeLayout;
//    private ImageView  takecamra;

    private CircleImageView profile_civ;
    public static TextView fname_tv, lname_tv;


    File imagefile;
    EditText first_name, lastname;

    TextView NoChannel,TotalLike,TotalSubscribe,TotalVideo;
    int a = 0;

    LinearLayout MyChannel, MyVideos;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_my_account, container, false);


        fname_tv = rootView.findViewById(R.id.fname_tv);
        lname_tv = rootView.findViewById(R.id.lname_tv);
        profile_civ = rootView.findViewById(R.id.profile_civ);
        cover_image = rootView.findViewById(R.id.cover_image);
        relativeLayout = (RelativeLayout) rootView.findViewById(R.id.relativeLayout);
        edit_iv = rootView.findViewById(R.id.edit_iv);
        name = (TextView) rootView.findViewById(R.id.name);

        NoChannel = rootView.findViewById(R.id.nochanel);
        TotalLike = rootView.findViewById(R.id.total_like);
        TotalSubscribe = rootView.findViewById(R.id.total_subcribe);
        TotalVideo = rootView.findViewById(R.id.total_video);


        MyChannel = (LinearLayout)rootView. findViewById(R.id.channel_ll);
        MyVideos = rootView.findViewById(R.id.my_videos_ll);

        edit_iv.setOnClickListener(this);
        MyChannel.setOnClickListener(this);
        MyVideos.setOnClickListener(this);


        checkpermissions(getActivity());

        if (GlobalClass.isNetworkConnected(getActivity())) {

            WebapiCall webapiCall = new WebapiCall();
            webapiCall.customerInfo(getActivity(), CSPreferences.readString(getActivity(), "tooken"), CSPreferences.readString(getActivity(), "auth_key"), this);
        } else {

            Toast.makeText(getActivity(), GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }

        return rootView;

    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_account);
//
//        findViews();
//        checkpermissions(this);
//
//        if (GlobalClass.isNetworkConnected(MyAccountFragment.this)) {
//
//            WebapiCall webapiCall = new WebapiCall();
//            webapiCall.customerInfo(this, CSPreferences.readString(this, "tooken"), CSPreferences.readString(this, "auth_key"), this);
//        } else {
//
//            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
//        }
//
//    }

//    private void findViews() {
//        fname_tv = findViewById(R.id.fname_tv);
//        lname_tv = findViewById(R.id.lname_tv);
//        profile_civ = findViewById(R.id.profile_civ);
//        cover_image = findViewById(R.id.cover_image);
//        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
//        edit_iv = findViewById(R.id.edit_iv);
//        name = (TextView) findViewById(R.id.name);
//
//        NoChannel = findViewById(R.id.nochanel);
//        TotalLike = findViewById(R.id.total_like);
//        TotalSubscribe = findViewById(R.id.total_subcribe);
//        TotalVideo = findViewById(R.id.total_video);
//
//
//
//
//        MyChannel = (LinearLayout) findViewById(R.id.channel_ll);
//        MyVideos = findViewById(R.id.my_videos_ll);
//
//        edit_iv.setOnClickListener(this);
//        MyChannel.setOnClickListener(this);
//        MyVideos.setOnClickListener(this);
//
//
//
//    }

    @Override
    public void onClick(View v) {

//        else if (v == takecamra) {
//            showpictures(this);
//        }
         if (v == edit_iv) {
            Intent intent = new Intent(getActivity(), EditProfileActivity.class);
            intent.putExtra("fname", arrayList.get(0).getCustomerName());
            intent.putExtra("user_name", arrayList.get(0).getCustomerUsername());
            intent.putExtra("profileimg", arrayList.get(0).getCustomerProfilePic());
            intent.putExtra("email", arrayList.get(0).getCustomerEmail());
            intent.putExtra("cover_image", arrayList.get(0).getCoverProfileImage());
            startActivity(intent);

        }  else if (v == MyChannel) {
            Intent intent1 = new Intent(getActivity(), My_chanlel.class);
            startActivity(intent1);

        } else if (v == MyVideos) {
            CSPreferences.putString(getActivity(), "user_id_for_video", CSPreferences.readString(getActivity(), "auth_key"));
            Intent intent1 = new Intent(getActivity(), MyEpisodActivity.class);
            startActivity(intent1);
        }
    }


    @Override
    public void account_profile(ArrayList<CustomerInfo_pojo.Datum> customerdump) {
        arrayList.clear();
        arrayList.addAll(customerdump);
        fname_tv.setText(arrayList.get(0).getCustomerName());
        //followers_.setText(arrayList.get(0).getChannelName());
        lname_tv.setText(arrayList.get(0).getCustomerLastName());

        TotalLike.setText(arrayList.get(0).getTotalLike());
        TotalSubscribe.setText(arrayList.get(0).getTotalSubscribe());
        TotalVideo.setText(arrayList.get(0).getTotalDislike());

        if(arrayList.get(0).getChannelName().equals("")){
            MyChannel.setVisibility(View.GONE);
            MyVideos.setVisibility(View.GONE);
            NoChannel.setVisibility(View.VISIBLE);
        }


if(isAdded()){
    Glide.with(this)
            .load(arrayList.get(0).getCustomerProfilePic())
            .fitCenter().placeholder(R.drawable.logo)
            .into(profile_civ);

    Glide.with(this)
            .load(arrayList.get(0).getCoverProfileImage())
            .fitCenter().placeholder(R.drawable.user_cover)
            .into(cover_image);


    Log.d("dfsdfsdfdsfdsf", arrayList.get(0).getCustomerProfilePic());
}

    }

    @Override
    public void Subscrbe(String msg) {

    }
// Api call update profile picture

//    private void profileupdateApi(Context context, File imagefile) {
//        RequestBody customer_id = RequestBody.create(MediaType.parse("multipart/form-data"), CSPreferences.readString(MyAccountFragment.this, "auth_key"));
//
//        RequestBody imagerequestFile;
//        MultipartBody.Part imagebody = null;
//
//        if (imagefile == null) {
//            GlobalClass.showtost(MyAccountFragment.this, "Select your image");
//
//        } else {
//            imagerequestFile = RequestBody.create(MediaType.parse("multipart/form-data"), imagefile);
//            imagebody = MultipartBody.Part.createFormData("customer_profile_pic", imagefile.getName(), imagerequestFile);
//
//        }
//
//        if (GlobalClass.isNetworkConnected(this)) {
//
//            WebapiCall webapiCall = new WebapiCall();
//            webapiCall.customerProfilePic(context, CSPreferences.readString(context, "tooken"), customer_id, imagebody);
//
//
//        } else {
//
//            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
//        }
//
//
//    }


    // Select image
    private final int requestCode = 10;
    private static final int CAMERA_REQUEST = 188;

//    public void showpictures(View.OnClickListener activity) {
//        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
//
//
//        dialog.setTitle(getResources().getString(R.string.txt_slct_optionn));
//        String[] items = {getResources().getString(R.string.txt_gelleryy),
//                getResources().getString(R.string.txt_camerayy), getResources()
//                .getString(R.string.txt_warningg)};
//        // dialog.setMessage("*for your security reason we blocked!");
//        dialog.setItems(items, new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                // TODO Auto-generated method stub
//                switch (which) {
//                    case 0:
//                        showFileChoosesr();
//                        break;
//                    case 1:
//                        takePhotoFromCameras();
//                        break;
//                }
//            }
//        });
//        dialog.show();
//    }


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

//    private String getPaths(Uri contentUri) {
//        String[] proj = {MediaStore.Images.Media.DATA};
//        CursorLoader loader = new CursorLoader(this, contentUri, proj, null, null, null);
//        Cursor cursor = loader.loadInBackground();
//        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//        cursor.moveToFirst();
//        String result = cursor.getString(column_index);
//        cursor.close();
//        return result;
//    }


//    public String getRealPathFromURI(Uri uri) {
//        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
//        cursor.moveToFirst();
//        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
//        return cursor.getString(idx);
//    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    private static final int BUFFER_SIZE = 1024 * 3;
    private static final String IMAGE_DIRECTORY = "/demonuts_upload_gallery";

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

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (this.requestCode == requestCode && resultCode == RESULT_OK) {
//            Uri picUri = data.getData();
//            imagefile = new File(getPaths(picUri));
//            Log.d("imagegallary", String.valueOf(imagefile));
//            profile_civ.setImageURI(picUri);
//            profileupdateApi(this, imagefile);
//        }
//        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
//            Bitmap photo = (Bitmap) data.getExtras().get("data");
//            profile_civ.setImageBitmap(photo);
//            Uri tempUri = getImageUri(this, photo);
//            imagefile = new File(getRealPathFromURI(tempUri));
//            Log.d("imagecamera", String.valueOf(imagefile));
//            profileupdateApi(this, imagefile);
//        }
//
//    }

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
}
