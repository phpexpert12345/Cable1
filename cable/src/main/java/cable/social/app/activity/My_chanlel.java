package cable.social.app.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import cable.social.app.Interface.Chanal_list_interface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.adadpter.My_chanlel_Adapter;
import cable.social.app.databinding.FragmentMyChanlelBinding;
import cable.social.app.model.ChannelList_Model;
import cable.social.app.utility.BaseActivity;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;

public class My_chanlel extends BaseActivity implements Chanal_list_interface {


    ImageView Channel_icon;
    Button Edit;
    TextView MyChannel;
    String Channel_logo_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.fragment_my_chanlel);

        Channel_icon = findViewById(R.id.channel_icon);
        Edit = findViewById(R.id.edit_ch);
        MyChannel = findViewById(R.id.my_chanel);


    }

    @Override
    public void initData() {


        if (GlobalClass.isNetworkConnected(My_chanlel.this)) {
            WebapiCall webapiCall = new WebapiCall();
            webapiCall.channelList(My_chanlel.this, CSPreferences.readString(this, "tooken"), CSPreferences.readString(this, "auth_key"), this);
        } else {

            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }


    }


    @Override
    public void chanallist(ChannelList_Model.Data data) {

//        arrayList.clear();
//        arrayList.addAll(list);
//        binding.mychanal.getAdapter().notifyDataSetChanged();


//        MyChannel.setText(data.getChannelName());

        Glide.with(My_chanlel.this)
                .load(data.getChannelLogoImageUrl())
                .fitCenter().placeholder(R.drawable.logo)
                .into(Channel_icon);

        Channel_logo_id = data.getChannel_logo_id();

    }


    @Override
    public void initListeners() {

    }

    public void EditChannel(View view) {
        Intent intent = new Intent(My_chanlel.this, CreateChannelActivity.class);
        startActivity(intent);
    }

    public void Close(View view) {
        finish();
    }
}
