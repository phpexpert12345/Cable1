package cable.social.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cable.social.app.R;

public class MovieInfoActivity extends AppCompatActivity implements View.OnClickListener {

    Button next_btn;
    EditText title_et,desc_et,re_year_et,duration_et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);
        getViewId();
    }
    private void getViewId(){
        next_btn=findViewById(R.id.next_btn);
        title_et=findViewById(R.id.title_et);
        desc_et=findViewById(R.id.desc_et);
        re_year_et=findViewById(R.id.re_year_et);
        duration_et=findViewById(R.id.duration_et);
        setListners();
    }
    private void setListners(){
        next_btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.next_btn:
                break;
        }
    }
}