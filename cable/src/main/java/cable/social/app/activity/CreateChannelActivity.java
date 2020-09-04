package cable.social.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickResult;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;

import cable.social.app.Interface.Chanal_list_interface;
import cable.social.app.Interface.ChannelCategory_interface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.adadpter.Create_chanelAdater;
import cable.social.app.model.ChannelList_Model;
import cable.social.app.model.ChannelLogoList;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;
import cable.social.app.utility.MyPref;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class CreateChannelActivity extends AppCompatActivity implements ChannelCategory_interface, IPickResult, Chanal_list_interface {
    RecyclerView recyclerView;
    Create_chanelAdater create_chanal;
    //    ArrayList<ChannelCategory_Pojo.Datum> arrayList = new ArrayList<>();
    ArrayList<ChannelLogoList.Datum> arrayList = new ArrayList<>();
    MyPref myPref;
    String channelName="",UserName="",channelCategory="1",filePath="",Channel_logo_id="";
    RequestQueue requestQueue;
    Button save_btn;
    EditText user_name_et,channel_et;
    CircleImageView channel_civ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_channel);

        user_name_et = findViewById(R.id.user_name_et);
        channel_civ = findViewById(R.id.channel_civ);
        channel_et = findViewById(R.id.channel_et);
        save_btn = findViewById(R.id.save_btn);
        recyclerView = findViewById(R.id.create_chanal);
        requestQueue= Volley.newRequestQueue(CreateChannelActivity.this);
        myPref=new MyPref(CreateChannelActivity.this);
        Log.v("TokenId",myPref.getApiToken());


        user_name_et.setText(CSPreferences.readString(this, "user_name"));


        recyclerView.setLayoutManager(new GridLayoutManager(CreateChannelActivity.this, 2));
        create_chanal = new Create_chanelAdater(CreateChannelActivity.this, arrayList, new Create_chanelAdater.ItemClick() {
            @Override
            public void getId(String id) {
                Channel_logo_id=id;
            }
        });
        recyclerView.setAdapter(create_chanal);

        if (GlobalClass.isNetworkConnected(CreateChannelActivity.this)) {
            WebapiCall webapiCall = new WebapiCall();
            webapiCall.channel_logo_list(this, CSPreferences.readString(this, "tooken"), this);
            webapiCall.channelList(this, CSPreferences.readString(this, "tooken"), CSPreferences.readString(this, "auth_key"), this);

        } else {

            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }

        save_btn.setOnClickListener(new View.OnClickListener() {

            MultipartBody.Part part;

            @Override
            public void onClick(View view) {
                Log.v("TokenId", CSPreferences.readString(CreateChannelActivity.this, "tooken"));
                channelName=channel_et.getText().toString();
                UserName=user_name_et.getText().toString();
             if(channelName.isEmpty()){
                    channel_et.setError("Enter channel name");
                }else if(UserName.isEmpty()){
                    user_name_et.setError("Enter UserName");
                }else{

                 if(!filePath.isEmpty()) {
                     File file = new File(filePath);
                     RequestBody fileReqBody = RequestBody.create(MediaType.parse("image/*"), file);
                     part = MultipartBody.Part.createFormData("channel_logo", file.getName(), fileReqBody);

                 }


                 RequestBody cutomerid = RequestBody.create(MediaType.parse("multipart/form-data"), CSPreferences.readString(CreateChannelActivity.this, "auth_key"));
                 RequestBody channelname = RequestBody.create(MediaType.parse("multipart/form-data"), channelName);
                 RequestBody channelcategory = RequestBody.create(MediaType.parse("multipart/form-data"), channelCategory);
                 RequestBody channel_logo_id = RequestBody.create(MediaType.parse("multipart/form-data"), Channel_logo_id);
                 RequestBody customer_username = RequestBody.create(MediaType.parse("multipart/form-data"), UserName);


                    if (GlobalClass.isNetworkConnected(CreateChannelActivity.this)) {
                        CSPreferences.putString(CreateChannelActivity.this, "user_name", UserName);

                        WebapiCall webapiCall = new WebapiCall();
                        webapiCall.addChannel(CreateChannelActivity.this,part, CSPreferences.readString(CreateChannelActivity.this, "tooken"), cutomerid,channelname,channelcategory,customer_username,channel_logo_id, CreateChannelActivity.this);
                    } else {

                        //Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        channel_civ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PickImageDialog.build(new PickSetup()).show(CreateChannelActivity.this);
            }
        });

    }

    @Override
    public void channel_logo_list(ArrayList<ChannelLogoList.Datum> list) {
        arrayList.clear();
        arrayList.addAll(list);
//        arrayList.addAll(list);
//        arrayList.addAll(list);
        recyclerView.getAdapter().notifyDataSetChanged();

    }







    @Override
    public void addChannel(String response) {
        try {
            JSONObject jsonObject=new JSONObject(response);
            Log.v("Reposne",""+jsonObject);
            if(jsonObject.getString("status").equalsIgnoreCase("ok")){
                channel_et.setText("");
                user_name_et.setText("");
                filePath="";
                Toast.makeText(CreateChannelActivity.this,jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                startActivity(new Intent(this,MainActivity.class));
                finish();
            }else {
                Toast.makeText(CreateChannelActivity.this,jsonObject.getString("message"),Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Log.e("ErrorRes",""+e.getMessage());

        }


    }

    public void onPickResult(PickResult r) {
        if (r.getError() == null) {
            filePath=r.getPath();
            channel_civ.setImageBitmap(r.getBitmap());
        } else {
            //Handle possible errors
            //TODO: do what you have to do with r.getError();
            Toast.makeText(this, r.getError().getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void chanallist(ChannelList_Model.Data data) {

        channel_et.setText(data.getChannelName());

        Glide.with(CreateChannelActivity.this)
                .load(data.getChannelLogoImageUrl())
                .fitCenter().placeholder(R.drawable.logo)
                .into(channel_civ);

        Channel_logo_id = data.getChannel_logo_id();





    }

    public void Close(View view) {
        finish();
    }
}
