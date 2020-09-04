package cable.social.app.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cable.social.app.Interface.Invite_list_interface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.adadpter.Invitation_Adapter;
import cable.social.app.databinding.ActivityInvitationListBinding;
import cable.social.app.model.Invite_lists_Model;
import cable.social.app.utility.BaseActivity;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;

public class Invitation_list extends BaseActivity implements Invite_list_interface {

    RecyclerView invtaion_recycley;
    Invitation_Adapter invitation_adapter;
    ActivityInvitationListBinding binding;
    ArrayList<Invite_lists_Model.Datum> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_invitation_list);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_invitation_list);
        invtaion_recycley = findViewById(R.id.invtaion_recycley);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        binding.invtaionRecycley.setLayoutManager(layoutManager);
         invitation_adapter = new Invitation_Adapter(this,arrayList);
        invtaion_recycley.setAdapter(invitation_adapter);

        if (GlobalClass.isNetworkConnected(this)) {
            WebapiCall webapiCall = new WebapiCall();
            webapiCall.invite_list(this, CSPreferences.readString(this, "tooken"), this);
        } else {

            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void invite_list_interface(ArrayList<Invite_lists_Model.Datum> list) {
        arrayList.clear();
        arrayList.addAll(list);
        invtaion_recycley.getAdapter().notifyDataSetChanged();

    }


    @Override
    public void initData() {
        binding.toolBar.menuBtn.setVisibility(View.GONE);
        binding.toolBar.tvToolbarTitle.setVisibility(View.GONE);
        // binding.toolBar.tvToolbarTitle.setText(R.string.my_intro);
        binding.toolBar.search.setVisibility(View.GONE);
        binding.toolBar.imageView10.setVisibility(View.GONE);
    }


    @Override
    public void initListeners() {
        binding.toolBar.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
