package cable.social.app.adadpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cable.social.app.Interface.FriendList;
import cable.social.app.Interface.User_list;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.model.Category_model;
import cable.social.app.model.FriendListModel;
import cable.social.app.model.UserList;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;

public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<FriendListModel.Data.FriendList> friendLists = new ArrayList<>();

    FriendList user_list_interface;

    // RecyclerView recyclerView;
    public FriendListAdapter(Context context, ArrayList<FriendListModel.Data.FriendList> friendLists, FriendList user_list_interface) {
        this.context = context;
        this.friendLists = friendLists;
        this.user_list_interface = user_list_interface;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.friend_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FriendListModel.Data.FriendList friendList = friendLists.get(position);

        Glide.with(context)
                .load(friendList.getCustomerProfilePic())
                .fitCenter()
                .placeholder(R.drawable.logo)
                .into(holder.UserImg);


//        if(userList.getChannelName().isEmpty()){
//            holder.ChannlRL.setVisibility(View.GONE);
//        }else {
//            Glide.with(context)
//                    .load(userList.getChannelLogoImageUrl())
//                    .fitCenter()
//                    .placeholder(R.drawable.logo)
//                    .into(holder.ChnlImage);
//
//            holder.ChannelName.setText(userList.getChannelName());
//        }
//
//
//
        holder.UserName.setText(friendList.getCustomerName());
        holder.MobileNo.setText(friendList.getCustomerMobileNumber());
//        holder.time.setText(friendList.getCreatedAt());
//
//        if(userList.getRequestStatus().equals("sent")){
//            holder.AddFriend.setVisibility(View.GONE);
//            holder.Request_sent.setVisibility(View.VISIBLE);
//
//
//        }else if(userList.getRequestStatus().equals("send")){
//
//            holder.AddFriend.setVisibility(View.VISIBLE);
//            holder.Request_sent.setVisibility(View.GONE);
//
//
//        }



//
//        holder.AddFriend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (GlobalClass.isNetworkConnected(context)) {
//                    WebapiCall categorylist = new WebapiCall();
//                    categorylist.FriendRequestSend(context, CSPreferences.readString(context, "tooken"),CSPreferences.readString(context, "auth_key"),userList.getCustomerId(),user_list_interface,position);
//                } else {
//                    Toast.makeText(context, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
//                }
//            }
//        });


    }


    public void updateList(ArrayList<FriendListModel.Data.FriendList> list){
        this.friendLists = list;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return friendLists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView UserImg;
        public TextView UserName,MobileNo,time;
        public RelativeLayout ChannlRL;


        public ViewHolder(View itemView) {
            super(itemView);
            UserImg=itemView.findViewById(R.id.profile_image);
            UserName = itemView.findViewById(R.id.user_name);
            MobileNo = itemView.findViewById(R.id.user_no);
//            time = itemView.findViewById(R.id.time);




        }
    }
}
