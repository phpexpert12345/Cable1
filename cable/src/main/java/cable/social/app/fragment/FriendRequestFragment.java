package cable.social.app.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

import cable.social.app.Interface.FreindRequestInterface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.adadpter.Category_allAdapter;
import cable.social.app.adadpter.FriendRequestNotiAdaper;
import cable.social.app.adadpter.Notifaction_Adapter;
import cable.social.app.model.AllNotificationModel;
import cable.social.app.model.FriendRequest;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;

public class FriendRequestFragment extends Fragment implements FreindRequestInterface {
    RecyclerView rvnotification;
    Notifaction_Adapter notifaction_adapter;
    Category_allAdapter category_allAdapter;

    List<FriendRequest.Datum>friendRequestNotiList=new LinkedList<>();
    FriendRequestNotiAdaper friendRequestNotiAdaper;

    Context mContext;

    public FriendRequestFragment(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_notification, container, false);
        rvnotification = rootView.findViewById(R.id.rvnotification);

        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvnotification.setLayoutManager(verticalLayoutManager);

//        notifaction_adapter = new Notifaction_Adapter(getActivity());
//        rvnotification.setAdapter(notifaction_adapter);

        serverCall();




        return rootView;

    }

    @Override
    public void RequestList(List<FriendRequest.Datum> list) {
        //

        if(list.size()>0) {
            friendRequestNotiList.clear();
            friendRequestNotiList.addAll(list);
            friendRequestNotiAdaper = new FriendRequestNotiAdaper(mContext, friendRequestNotiList, this);
            rvnotification.setAdapter(friendRequestNotiAdaper);
        }

    }

    @Override
    public void AllNotificationList(List<AllNotificationModel.Datum> list) {

    }

    @Override
    public void InviteResponse(String message) {
        GlobalClass.showtost(mContext, message);

        serverCall();
    }


   public void serverCall(){
        if (GlobalClass.isNetworkConnected(mContext)) {
            WebapiCall webapiCall = new WebapiCall();

            Log.d("token", CSPreferences.readString(mContext, "tooken"));

            webapiCall.getFriendRequest(mContext, CSPreferences.readString(mContext, "tooken"),  CSPreferences.readString(mContext, "auth_key"), this);


        } else {

            Toast.makeText(mContext, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }
    }

}
