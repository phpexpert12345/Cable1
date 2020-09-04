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

public class Season_adapter extends RecyclerView.Adapter<Season_adapter.ViewHolder> {

    Context context;
    ArrayList<VideoDetailModel.Data.Genre> seasonsLists = new ArrayList<>();

    // RecyclerView recyclerView;
    public Season_adapter(Context context, ArrayList<VideoDetailModel.Data.Genre> seasonsLists) {
        this.context = context;
        this.seasonsLists = seasonsLists;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.season_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        Glide.with(context)
//                .load(seasonsLists.get(position).getSeasonImage())
//                .fitCenter()
//                .into(holder.profile_image);
//
//        holder.tital.setText(seasonsLists.get(position).getSeasonTitle());
//        holder.decraption.setText(seasonsLists.get(position).getSeasonDescription());
//
////        if (invitrarrayList.get(position).getInviteStatus().equals("0")){
////            holder.invite.setText("Invite");
////        }else {
////            holder.invite.setText("Pending");
////        }
//
//
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

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
        return seasonsLists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView profile_image;
        public TextView tital, decraption, invite;

        public ViewHolder(View itemView) {
            super(itemView);
            profile_image = itemView.findViewById(R.id.profile_image_season);
            tital = itemView.findViewById(R.id.tital_season);
            decraption = itemView.findViewById(R.id.decraption_season);
//            invite = itemView.findViewById(R.id.invite);
        }
    }
}


