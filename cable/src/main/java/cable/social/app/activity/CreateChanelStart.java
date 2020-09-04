package cable.social.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.Objects;

import cable.social.app.R;
import cable.social.app.utility.CSPreferences;
import de.hdodenhof.circleimageview.CircleImageView;

public class CreateChanelStart extends AppCompatActivity {

    TextView Name;
    CircleImageView user_Img;
    String ImagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_chanel_start);

        Name = findViewById(R.id.user_name);
        user_Img = findViewById(R.id.profile_crt_channel);

        Intent intent = getIntent();

        if(intent.hasExtra("path")){


            File imgFile = new  File(Objects.requireNonNull(intent.getStringExtra("path")));

            if(imgFile.exists()){
                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                user_Img.setImageBitmap(myBitmap);
            }
        }

       Name.setText( "Welcome " +  CSPreferences.readString(getApplicationContext(),"name"));
    }

    public void CreateChannel(View view) {

        Intent intent = new Intent(this, CreateChannelActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

        finish();

    }

    public void Watchit(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

        finish();


    }
}
