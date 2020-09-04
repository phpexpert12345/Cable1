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


import java.util.ArrayList;

import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.model.ArrayListCustomerId;
import cable.social.app.model.Invite_lists_Model;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;

public class Invitation_Adapter extends RecyclerView.Adapter<Invitation_Adapter.ViewHolder>{

    Context context;
    ArrayList<Invite_lists_Model.Datum> arrayList;
    // RecyclerView recyclerView;
    public Invitation_Adapter(Context context, ArrayList<Invite_lists_Model.Datum> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.invitation_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context)
                .load(arrayList.get(position).getCustomerProfilePic())
                .fitCenter()
                .placeholder(R.drawable.logo)
                .into(holder.imageViewIcon);

        holder.textViewName.setText(arrayList.get(position).getCustomerName());

        if (arrayList.get(position).getInviteStatus().equals("0")){
            holder.invite.setText("Invite");
        }else {
            holder.invite.setText("Pending");
        }


holder.invite.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (GlobalClass.isNetworkConnected(context)) {
            WebapiCall webapiCall = new WebapiCall();
            webapiCall.friendRequestSend(context, CSPreferences.readString(context, "tooken"),
                    CSPreferences.readString(context, "auth_key"),arrayList.get(position).getCustomerId().toString());

        } else {

            Toast.makeText(context, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }
    }
});



    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewIcon;
        public TextView textViewName,invite;
        public ViewHolder(View itemView) {
            super(itemView);
            imageViewIcon = itemView.findViewById(R.id.imageViewIcon);
            textViewName = itemView.findViewById(R.id.textViewName);
            invite = itemView.findViewById(R.id.invite);

        }
    }
}


