package cable.social.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import cable.social.app.R;

public class UploadIntroActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView rotate_iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_intro);
        getViewId();
    }
    private void getViewId(){
        rotate_iv=findViewById(R.id.rotate_iv);
        setListners();
    }
    private void setListners(){
        rotate_iv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rotate_iv:
                startActivity(new Intent(UploadIntroActivity.this,CreateIntroVideoActivity.class));
                break;
        }
    }
}