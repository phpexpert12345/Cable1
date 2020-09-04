package cable.social.app.adadpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.model.ArrayListCustomerId;
import cable.social.app.model.VideoDetailModel;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;

import java.util.ArrayList;

public class Invitation_invite_adapter extends RecyclerView.Adapter<Invitation_invite_adapter.ViewHolder> {

    Context context;
    ArrayList<VideoDetailModel.Data.InviteList> invitrarrayList = new ArrayList<>();

    // RecyclerView recyclerView;
    public Invitation_invite_adapter(Context context, ArrayList<VideoDetailModel.Data.InviteList> invitrarrayList) {
        this.context = context;
        this.invitrarrayList = invitrarrayList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.invite_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context)
                .load(invitrarrayList.get(position).getCustomerProfilePic())
                .fitCenter()
                .into(holder.profile_image);

        holder.name.setText(invitrarrayList.get(position).getCustomerName());

//        if (invitrarrayList.get(position).getInviteStatus().equals("0")){
//            holder.invite.setText("Invite");
//        }else {
//            holder.invite.setText("Pending");
//
//        }
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//
//        holder.invite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (GlobalClass.isNetworkConnected(context)) {
//                    WebapiCall webapiCall = new WebapiCall();
//                    ArrayList<String> ages = new ArrayList<>();
//                    ages.add(invitrarrayList.get(position).getCustomerId().toString());
//
//
//                    ArrayListCustomerId arrayListAge = new ArrayListCustomerId(ages);
//
//                    webapiCall.friendRequestSend(context, CSPreferences.readString(context, "tooken"),
//                            CSPreferences.readString(context, "auth_key"),invitrarrayList.get(position).getCustomerId().toString());
//                } else {
//
//                    Toast.makeText(context, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
//                }
//            }
//        });


    }


    @Override
    public int getItemCount() {
        return invitrarrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView profile_image;
        public TextView name, phone;

        public ViewHolder(View itemView) {
            super(itemView);
            profile_image = itemView.findViewById(R.id.profile_image_invite);
            name = itemView.findViewById(R.id.name_invite);
            phone = itemView.findViewById(R.id.phone_invite);
//            invite = itemView.findViewById(R.id.invite);
        }
    }
}


