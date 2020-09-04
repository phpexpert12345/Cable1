package cable.social.app.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cable.social.app.R;
import cable.social.app.activity.AlloptionActivity;
import cable.social.app.activity.LoginActivity;
import cable.social.app.activity.MainActivity;
import cable.social.app.activity.MyNotificationActivity;
import cable.social.app.utility.BaseActivity;
import cable.social.app.utility.CSPreferences;


public class SplashActivity extends AppCompatActivity {

    private static int splashTimeOut = 5000;
    private ImageView logo;
    private ImageView ivRototate;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ivRototate = findViewById(R.id.ivRototate);


//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                String auth_key = auth_key = CSPreferences.readString(SplashActivity2.this, "auth_key");
//                if (!auth_key.isEmpty()) {
//                    // Intent i = new Intent(SplashActivity.this, ExampleActivity.class);
//                    Intent i = new Intent(SplashActivity2.this, AlloptionActivity.class);
//                    startActivity(i);
//                    finish();
//                } else {
//                    // Intent i = new Intent(SplashActivity.this, ExampleActivity.class);
//                    Intent i = new Intent(SplashActivity2.this, LoginActivity.class);
//                    startActivity(i);
//                    finish();
//                }
//
//            }
//        }, splashTimeOut);
//
//        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mysplashanimation);
//        logo.startAnimation(myanim);



//        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ivRototate.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));
//        Common.printKeyHash(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String auth_key = auth_key = CSPreferences.readString(SplashActivity.this, "auth_key");
                if (!auth_key.isEmpty()) {
                    // Intent i = new Intent(SplashActivity.this, ExampleActivity.class);
//                    Intent i = new Intent(SplashActivity.this, AlloptionActivity.class);
//                    startActivity(i);

                    Intent intent= getIntent();
                    if(intent!=null && intent.hasExtra("body")){
                        Intent MoveToNext = new Intent(SplashActivity.this, MyNotificationActivity.class);
                        startActivity(MoveToNext);
                        finish();
                    }else {
                        Intent MoveToNext = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(MoveToNext);
                        finish();
                    }
                } else {
                    // Intent i = new Intent(SplashActivity.this, ExampleActivity.class);
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        }, splashTimeOut);




    }


}





