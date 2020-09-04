package cable.social.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import cable.social.app.Interface.CustomerIntroVideo_interface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.adadpter.MyIntroVideo_Adapter;
import cable.social.app.databinding.ActivityMyIntroBinding;
import cable.social.app.model.CustomerIntroVideo_pojo;
import cable.social.app.utility.BaseActivity;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;
import cable.social.app.video_filter.ui.activity.VideoActivity;

import java.util.ArrayList;

public class MyIntroActivity extends BaseActivity implements CustomerIntroVideo_interface {
    ActivityMyIntroBinding binding;
    MyIntroVideo_Adapter myIntroVideo_adapter;

    private ArrayList<CustomerIntroVideo_pojo.Datum> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_intro);
        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.addnewintrovideo);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                doMyThing();
            }
        });

    }


    private void doMyThing() {
        Intent intent = new Intent(MyIntroActivity.this, VideoActivity.class);
        startActivity(intent);
    }

    @Override
    public void initData() {
        binding.toolBar.menuBtn.setVisibility(View.GONE);
        binding.toolBar.tvToolbarTitle.setVisibility(View.GONE);
       // binding.toolBar.tvToolbarTitle.setText(R.string.my_intro);
        binding.toolBar.search.setVisibility(View.GONE);
        binding.toolBar.imageView10.setVisibility(View.GONE);

        binding.myintrolist.setLayoutManager(new GridLayoutManager(this, 2));
        myIntroVideo_adapter = new MyIntroVideo_Adapter(this, data);
        binding.myintrolist.setAdapter(myIntroVideo_adapter);
        if (GlobalClass.isNetworkConnected(MyIntroActivity.this)) {
            WebapiCall webapiCall = new WebapiCall();
            webapiCall.customerIntroVideo(this, CSPreferences.readString(this, "tooken"), CSPreferences.readString(this,"auth_key"), this);
        } else {

            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void initListeners() {
        binding.toolBar.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        {

        }
    }

    @Override
    public void CustomerIntroVideo(ArrayList<CustomerIntroVideo_pojo.Datum> list) {

           data.clear();
                    data.addAll(list);
                      binding.myintrolist.getAdapter().notifyDataSetChanged();
    }


}