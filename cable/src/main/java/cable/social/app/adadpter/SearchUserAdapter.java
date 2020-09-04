package cable.social.app.adadpter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cable.social.app.Interface.User_list;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.activity.MainActivity;
import cable.social.app.activity.OtherUserAccount;
import cable.social.app.fragment.SearchVideoFragment;
import cable.social.app.model.Category_model;
import cable.social.app.model.UserList;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;

public class SearchUserAdapter extends RecyclerView.Adapter<SearchUserAdapter.ViewHolder> {

    private Context context;
    private ArrayList<UserList.Datum> userlists = new ArrayList<>();
    private List<Category_model.CategoyList> displayedList = new ArrayList<>();

    User_list user_list_interface;

    // RecyclerView recyclerView;
    public SearchUserAdapter(Context context, ArrayList<UserList.Datum> categoyLists, User_list user_list_interface) {
        this.context = context;
        this.userlists = categoyLists;
        this.user_list_interface = user_list_interface;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.search_user_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserList.Datum userList = userlists.get(position);

        Glide.with(context)
                .load(userList.getCustomerProfilePic())
                .fitCenter()
                .placeholder(R.drawable.logo)
                .into(holder.UserImg);


if(userList.getChannelName().isEmpty()){
    holder.ChannlRL.setVisibility(View.GONE);
}else {
    Glide.with(context)
            .load(userList.getChannelLogoImageUrl())
            .fitCenter()
            .placeholder(R.drawable.logo)
            .into(holder.ChnlImage);

    holder.ChannelName.setText(userList.getChannelName());
}



        holder.CustomerName.setText(userList.getCustomerName());
        holder.UserName.setText(userList.getCustomerUsername());

        if(userList.getRequestStatus().equals("sent")){
            holder.AddFriend.setVisibility(View.GONE);
            holder.Request_sent.setVisibility(View.VISIBLE);


        }else if(userList.getRequestStatus().equals("send")){

            holder.AddFriend.setVisibility(View.VISIBLE);
            holder.Request_sent.setVisibility(View.GONE);

        }
        holder.UserImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(context, OtherUserAccount.class);
                i.putExtra("user_id",userList.getCustomerId());
                context.startActivity(i);
            }
        });




        holder.AddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GlobalClass.isNetworkConnected(context)) {
                    WebapiCall categorylist = new WebapiCall();
                    categorylist.FriendRequestSend(context, CSPreferences.readString(context, "tooken"),CSPreferences.readString(context, "auth_key"),userList.getCustomerId(),user_list_interface,position);
                } else {
                    Toast.makeText(context, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }
            }
        });


    }


    public void updateList(ArrayList<UserList.Datum> list){
        this.userlists = list;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return userlists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ChnlImage,UserImg,AddFriend,Request_sent;
        public TextView CustomerName,UserName,ChannelName;
        public RelativeLayout ChannlRL;


        public ViewHolder(View itemView) {
            super(itemView);
            UserImg=itemView.findViewById(R.id.user_img_s);
            CustomerName=itemView.findViewById(R.id.customer_name_s);

            UserName = itemView.findViewById(R.id.user_name_s);
            ChannelName = itemView.findViewById(R.id.channel_name_s);
            ChnlImage=itemView.findViewById(R.id.chnl_img_s);
            ChannlRL=itemView.findViewById(R.id.chnl_rl_s);
            AddFriend=itemView.findViewById(R.id.add_friennd);
            Request_sent=itemView.findViewById(R.id.request_sent);



        }
    }
}
