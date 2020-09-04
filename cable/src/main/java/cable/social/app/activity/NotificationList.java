package cable.social.app.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import cable.social.app.Interface.FriendListInterface;
import cable.social.app.Interface.InvitedNotificationListInterface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.adadpter.Notification_Adapter;
import cable.social.app.databinding.ActivityNotificationListBinding;
import cable.social.app.model.FriendListPoJO;
import cable.social.app.model.InvitedNotificationListPOJO;
import cable.social.app.utility.BaseActivity;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;

public class NotificationList extends BaseActivity implements InvitedNotificationListInterface {
    ActivityNotificationListBinding binding;
    Notification_Adapter notification_adapter;
    ArrayList<InvitedNotificationListPOJO.Datum> arrayList = new ArrayList<>();
    TextView notfound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_list);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notification_list);
    }

    @Override
    public void initData() {
        binding.toolBar.menuBtn.setVisibility(View.GONE);
        binding.toolBar.backBtn.setVisibility(View.VISIBLE);
        binding.toolBar.search.setVisibility(View.GONE);
        binding.toolBar.imageView10.setVisibility(View.GONE);

        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(NotificationList.this, LinearLayoutManager.VERTICAL, false);

        binding.recycleviewNotification.setLayoutManager(horizontalLayoutManagaer);
        notification_adapter = new Notification_Adapter(this, arrayList);
        binding.recycleviewNotification.setAdapter(notification_adapter);

        if (GlobalClass.isNetworkConnected(this)) {
            WebapiCall webapiCall = new WebapiCall();
            webapiCall.invitedNotificationList(this, CSPreferences.readString(this, "tooken"),
                    CSPreferences.readString(this, "auth_key"), this, binding.notfound);

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
    }


    @Override
    public void invitedNotificationListInterface(ArrayList<InvitedNotificationListPOJO.Datum> list) {
        arrayList.clear();
        arrayList.addAll(list);
        binding.recycleviewNotification.getAdapter().notifyDataSetChanged();

    }
}
