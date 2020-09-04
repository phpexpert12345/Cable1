package cable.social.app.adadpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import cable.social.app.Interface.FreindRequestInterface;
import cable.social.app.R;
import cable.social.app.model.AllNotificationModel;
import cable.social.app.model.FriendRequest;

public class Notifaction_Adapter extends RecyclerView.Adapter<Notifaction_Adapter.ViewHolder>{

    Context context;
    List<AllNotificationModel.Datum> allNotification;
    FreindRequestInterface freindRequestInterface;



    // RecyclerView recyclerView;
    public Notifaction_Adapter(Context context, List<AllNotificationModel.Datum> productList, FreindRequestInterface friendListInterface) {
        this.context = context;
        this.allNotification = productList;
        this.freindRequestInterface = friendListInterface;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.notifacton_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        AllNotificationModel.Datum notification = allNotification.get(position);



//        if (position%2==0){
//            holder.layout.setBackgroundResource(R.drawable.dialod_selectorroundd);
//        }

        holder.name.setText(notification.getCustomerName());
        holder.time.setText(notification.getCreatedAt());

        if(notification.getStatus().equals("2")) {
            holder.description.setText("you and " + notification.getCustomerName() + " become Friends");
        }else  if(notification.getStatus().equals("1")) {
            holder.description.setText( notification.getCustomerName() + " sent you Friend Request");
        }else if(notification.getStatus().equals("0")){
            holder.description.setText(  "  you denied Friend Request of " + notification.getCustomerName() );

        }


        Glide.with(context).load(notification.getCustomerProfilePic()).into(holder.profile);





    }


    @Override
    public int getItemCount() {
        return allNotification.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView profile;
        public TextView name,time,description;
        public RelativeLayout layout;

        public ViewHolder(View itemView) {
            super(itemView);
            layout=itemView.findViewById(R.id.rl_not_row);
            name = itemView.findViewById(R.id.user_name);
            time = itemView.findViewById(R.id.time);
            description = itemView.findViewById(R.id.description);
            profile = itemView.findViewById(R.id.profile_image);

        }
    }
}

