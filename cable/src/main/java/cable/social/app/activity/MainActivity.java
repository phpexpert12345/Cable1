package cable.social.app.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.bumptech.glide.Glide;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;
import com.social.bottomnavbar.BottomNavBar;

import java.util.ArrayList;

import cable.social.app.fragment.CategoryFragment;
import cable.social.app.fragment.ChooseTypeFragment;
import cable.social.app.fragment.Memberships;
import cable.social.app.fragment.SearchUserFragment;
import cable.social.app.utility.BaseActivity;
import cable.social.app.utility.DataModel;
import cable.social.app.Interface.ApiClient;
import cable.social.app.R;
import cable.social.app.adadpter.DrawerItemCustomAdapter;
import cable.social.app.fragment.FixturesFragment;
import cable.social.app.fragment.LiveVideoFragment;
import cable.social.app.model.Logout_model;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
    private static DrawerLayout mDrawerLayout;
    ImageView toggle, search_iv;
    public static TextView toolbartxt, uname, textView;
    CircleImageView profileImage;
    Toolbar toolbar;
    ImageView Notificationbar;


    private TextView mTextMessage;
    private String[] mNavigationDrawerItemTitles;

    private ListView mDrawerList;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;


    private BottomNavBar.OnBottomNavigationListener mOnBottomNavItemSelectedListener =
            new BottomNavBar.OnBottomNavigationListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.navigation_home:
                            //mTextMessage.setText(R.string.title_home);
                            // toolbartxt.setText("Home");
                            // Fragment fragment = new ConnectFragment();
                            Fragment fragment = new FixturesFragment();
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
                            return true;


                        case R.id.navigation_payment:
                            //mTextMessage.setText(R.string.title_payment);
                            // toolbartxt.setText("Category");
                            // Fragment fragsearch = new SearchFragment();
                            Fragment fragsearch = new CategoryFragment();
                            FragmentManager fragmentManagersearch = getSupportFragmentManager();
                            fragmentManagersearch.beginTransaction().replace(R.id.content_frame, fragsearch).commit();
                            return true;

                        case R.id.navigation_new_cart:
                            //mTextMessage.setText(R.string.title_new_cart);
                            // toolbartxt.setText("video");
                            // Fragment fragment2 = new FixturesFragment();
                           /* Fragment fragment2 = new Upload_service();
                            FragmentManager fragmentManager2 = getSupportFragmentManager();
                            fragmentManager2.beginTransaction().replace(R.id.content_frame, fragment2).commit();
                            */

                            Fragment chooseTypeFragment = new ChooseTypeFragment();
                            FragmentManager fragmentManagersearch1 = getSupportFragmentManager();
                            fragmentManagersearch1.beginTransaction().replace(R.id.content_frame, chooseTypeFragment).commit();
//                            startActivity(new Intent(MainActivity.this, ChooseTypeFragment.class));
                            return true;

                        case R.id.navigation_dashboard:
                            // toolbartxt.setText("Live");
                            //mTextMessage.setText(R.string.title_dashboard);
                            Fragment livevideo = new LiveVideoFragment();
                            FragmentManager fragmentManagerlivevideo = getSupportFragmentManager();
                            fragmentManagerlivevideo.beginTransaction().replace(R.id.content_frame, livevideo).commit();
                            return true;

                        case R.id.navigation_notifications:
                            // toolbartxt.setText("Myprofile");
                            //mTextMessage.setText(R.string.title_notifications);
//                            NotificationFragment notificationFragment = new NotificationFragment();
//                            FragmentManager fragmentManagernoti = getSupportFragmentManager();
//                            fragmentManagernoti.beginTransaction().replace(R.id.content_frame, notificationFragment).commit();

//                            Intent intent = new Intent(MainActivity.this, MyAccountFragment.class);
//                            startActivity(intent);

                            Fragment myAccount = new MyAccountFragment();
                            FragmentManager fragmentManagerAccount = getSupportFragmentManager();
                            fragmentManagerAccount.beginTransaction().replace(R.id.content_frame, myAccount).commit();

                            return true;
                    }
                    return false;
                }
            };
    private ActionBarDrawerToggle mDrawerToggle;


    public static void drawerCheck() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkpermissions(this);

        search_iv = findViewById(R.id.search_iv);
        mTextMessage = findViewById(R.id.message);
        toggle = findViewById(R.id.toggle);
        toolbartxt = findViewById(R.id.toolbartxt);
        BottomNavBar bottomNavView = findViewById(R.id.bottom_nav_view);
        bottomNavView.setBottomNavigationListener(mOnBottomNavItemSelectedListener);
        relativeLayout = findViewById(R.id.dailog);
        Notificationbar = findViewById(R.id.notificatiom_bar);


        View includedLayout = findViewById(R.id.accept_reject);
        Accept = includedLayout.findViewById(R.id.Accept);
        Accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        Notificationbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notification = new Intent(MainActivity.this, MyNotificationActivity.class);
                startActivity(notification);
            }
        });

        /// mTitle = mDrawerTitle = getTitle();
        // mNavigationDrawerItemTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerList = findViewById(R.id.left_drawer);
        uname = findViewById(R.id.uname);
        textView = findViewById(R.id.textView);
        profileImage = findViewById(R.id.profile_image);
        uname.setText(CSPreferences.readString(this, "name"));
        textView.setText(CSPreferences.readString(this, "email"));

        Glide.with(this)
                .load(CSPreferences.readString(this, "imageprofile"))
                .fitCenter().placeholder(R.drawable.logo)
                .into(profileImage);

        setupToolbar();


        DataModel[] drawerItem = new DataModel[6];
/*  <item>Upload Video</item>
        <item>MyDashboard</item>
        <item>My Channel</item>
        <item>My Videos</item>
        <item>My PlayList</item>
        <item>My SubsCriptions</item>
        <item> My Video History</item>
        <item>Logout</item>*/


        drawerItem[0] = new DataModel(R.drawable.hoe, "Home");
        drawerItem[1] = new DataModel(R.drawable.dashboard, "Subscriptions");
        drawerItem[2] = new DataModel(R.drawable.ic_profile, "My Profile");
        drawerItem[3] = new DataModel(R.drawable.ic_my_channel, "My Channel");
//        drawerItem[4] = new DataModel(R.drawable.ic_my_videos, "My Videos");
//        drawerItem[5] = new DataModel(R.drawable.ic_my_playlist, "My Playlist");
//        drawerItem[6] = new DataModel(R.drawable.ic_refer, "Refer & Earns");
//        drawerItem[7] = new DataModel(R.drawable.ic_rate, "Rate App");
//        drawerItem[8] = new DataModel(R.drawable.ic_refer_and_earn, "Share App");
//        drawerItem[4] = new DataModel(R.drawable.ic_my_intro, "My Intro");
        drawerItem[4] = new DataModel(R.drawable.ic_notification, " Notification");
        drawerItem[5] = new DataModel(R.drawable.ic_logout, "Logout");




        // getSupportActionBar().setDisplayHomeAsUpEnabled(false);getSupportActionBar().setHomeButtonEnabled(false);

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();
        //Fragment fragment = new ConnectFragment();
        Fragment fragment = new FixturesFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(videocall, new IntentFilter("videocall"));


        search_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragsearch = new SearchUserFragment();
                FragmentManager fragmentManagersearch = getSupportFragmentManager();
                fragmentManagersearch.beginTransaction().replace(R.id.content_frame, fragsearch).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public void initData() {


    }

    @Override
    public void initListeners() {
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.drawerCheck();
            }
        });

    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {

            case 0:
                fragment = new FixturesFragment();
                // fragment = new Upload_service();
                //  fragment = new ConnectFragment();
                break;

            case 1:
                mDrawerLayout.closeDrawers();
                Intent intent2 = new Intent(this, Memberships.class);
                startActivity(intent2);
                break;

            case 2:
                mDrawerLayout.closeDrawers();
//                Intent intent = new Intent(this, MyAccountFragment.class);
//                startActivity(intent);
                Fragment myAccount = new MyAccountFragment();
                FragmentManager fragmentManagerAccount = getSupportFragmentManager();
                fragmentManagerAccount.beginTransaction().replace(R.id.content_frame, myAccount).commit();
                // fragment = new My_chanlel();
                break;


            case 3:
                // fragment = new Memberships();
                mDrawerLayout.closeDrawers();
                Intent intent1 = new Intent(this, My_chanlel.class);
                startActivity(intent1);
                // fragment = new My_chanlel();

                break;

//            case 4:
//                mDrawerLayout.closeDrawers();
//                startActivity(new Intent(this, MyEpisodActivity.class));
//
//                break;
//            case 5:
//                // fragment = new FixturesFragment();
//                // fragment = new FixturesFragment();
//                // fragment = new Memberships();
//                fragment = new MyAlbum();
//
//                break;
//            case 6:
////                fragment = new MyAlbum();
////                Intent intent = new Intent(this, MyAccountActivity.class);
////                startActivity(intent);
//
//                mDrawerLayout.closeDrawers();
//                Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
//                shareIntent.setType("text/plain");
//                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject here");
//                String app_url = " https://play.google.com/store/apps/details?id=my.example.javatpoint";
//                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, app_url);
//                startActivity(Intent.createChooser(shareIntent, "Share via"));
//
//
//
//                //  logout();
//                break;
//            case 7:
////                Intent intent = new Intent(this, MyAccountActivity.class);
////                startActivity(intent);
//                mDrawerLayout.closeDrawers();
//                Intent shareIntent1 = new Intent(android.content.Intent.ACTION_SEND);
//                shareIntent1.setType("text/plain");
//                shareIntent1.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject here");
//                String app_url1 = " https://play.google.com/store/apps/details?id=my.example.javatpoint";
//                shareIntent1.putExtra(android.content.Intent.EXTRA_TEXT, app_url1);
//                startActivity(Intent.createChooser(shareIntent1, "Share via"));
//
//
//
//                // logout();
//                break;
//            case 4:
////                Intent intent = new Intent(this, MyAccountActivity.class);
////                startActivity(intent);
//                mDrawerLayout.closeDrawers();
//                Intent shareIntent2 = new Intent(android.content.Intent.ACTION_SEND);
//                shareIntent2.setType("text/plain");
//                shareIntent2.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject here");
//                String app_url2 = " https://play.google.com/store/apps/details?id=my.example.javatpoint";
//                shareIntent2.putExtra(android.content.Intent.EXTRA_TEXT, app_url2);
//                startActivity(Intent.createChooser(shareIntent2, "Share via"));
//
//                //logout();
//                break;
//            case 4:
//                mDrawerLayout.closeDrawers();
//                Intent intentmyintro = new Intent(this, MyIntroActivity.class);
//                startActivity(intentmyintro);


                //logout();
//                break;
            case 4:
                Intent notification = new Intent(this, MyNotificationActivity.class);
                startActivity(notification);
                break;

            case 5:
//                Intent intent = new Intent(this, MyAccountActivity.class);
//                startActivity(intent);

                logout();
                break;

            default:
                break;

        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack(null).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            // setTitle(mNavigationDrawerItemTitles[position]);
            // mDrawerLayout.closeDrawer(mDrawerList);
            mDrawerLayout.closeDrawers();

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        //toolbar.setTitle(mTitle);
        //toolbartxt.setText(mTitle.toString());

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        // hide the title bar  0
        setSupportActionBar(toolbar);
        (getSupportActionBar()).setDisplayShowHomeEnabled(false);
    }

    void setupDrawerToggle() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, null, R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);

        }

    }

    void logout() {
        mDrawerLayout.closeDrawers();

        new FancyGifDialog.Builder(this)
                .setTitle("Log out")
                .setMessage("Are you sure logout from Cable app?")
                .setNegativeBtnText("Cancel")
                .setPositiveBtnBackground("#FF4081")
                .setPositiveBtnText("Ok")
                .setNegativeBtnBackground("#FFA9A7A8")
                .setGifResource(R.drawable.logoutt)   //Pass your Gif here
                .isCancellable(true)
                .OnPositiveClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {

                        if (GlobalClass.isNetworkConnected(MainActivity.this)) {
                            logout(MainActivity.this, CSPreferences.readString(MainActivity.this, "tooken"), CSPreferences.readString(MainActivity.this, "tooken"));

                        } else {

                            Toast.makeText(MainActivity.this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                        }

//                        Toast.makeText(MainActivity.this, "Logout", Toast.LENGTH_SHORT).show();
//                        mDrawerLayout.closeDrawers();
//                        CSPreferences.clearPref(MainActivity.this);
//                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
//                                Intent.FLAG_ACTIVITY_CLEAR_TASK |
//                                Intent.FLAG_ACTIVITY_NEW_TASK);
//                        startActivity(intent);
                        //onBackPressed();
                    }
                })
                .OnNegativeClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
    }

    // LogOut APi................

    public void logout(final Context context, String auth, String tooken) {
        dailogshow(context);
        Call<Logout_model> userpost_responseCall = ApiClient.getClient().app_logout(GlobalClass.apikey, "Bearer " + auth, tooken);
        userpost_responseCall.enqueue(new Callback<Logout_model>() {
            @Override
            public void onResponse(Call<Logout_model> call, Response<Logout_model> response) {
                dailoghide(context);

                if (response.code() == 200) {
                    Toast.makeText(MainActivity.this, "Logout", Toast.LENGTH_SHORT).show();
                    mDrawerLayout.closeDrawers();
                    CSPreferences.clearPref(MainActivity.this);
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_CLEAR_TASK |
                            Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();

                } else {
                    GlobalClass.showtost(context, "" + response.message());
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<Logout_model> call, Throwable t) {

                dailoghide(context);
                t.printStackTrace();
                Toast.makeText(context, "Poor Connection." + t.toString(), Toast.LENGTH_SHORT).show();
                Log.d("dddddd", "onFailure: " + t.getMessage());
            }
        });
    }

    ProgressDialog pd;

    public void dailogshow(Context context) {
        pd = new ProgressDialog(context);
        pd.setMessage("loading...");
        pd.setCancelable(false);
        pd.show();
    }

    RelativeLayout relativeLayout;
    Button Accept;

    public void dailoghide(Context context) {
        pd.dismiss();
    }

    private final BroadcastReceiver videocall = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, android.content.Intent intent) {

            try {
                relativeLayout.setVisibility(View.VISIBLE);
                Log.d("Notification Response", "kapil bansal" + intent.getDataString());

                showDialog(context,"Friend Request");

            } catch (Exception e) {

            }
        }
    };

    public void showDialog(Context activity, String msg) {
        final Dialog dialog = new Dialog(activity);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);

        window.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.FILL_PARENT);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialogaccetreject);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));


        RelativeLayout roolll = (RelativeLayout) dialog.findViewById(R.id.roolll);
        TextView txt_content = (TextView) dialog.findViewById(R.id.txt_content);
        TextView hostesstxt = (TextView) dialog.findViewById(R.id.hostesstxt);
        Button Accept = (Button) dialog.findViewById(R.id.Accept);
        Button reject = (Button) dialog.findViewById(R.id.reject);
        ImageView dialogButton = (ImageView) dialog.findViewById(R.id.closeImg);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

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


}
