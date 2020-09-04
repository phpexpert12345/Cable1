package cable.social.app.adadpter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import cable.social.app.R;
import cable.social.app.activity.MyEpisodActivity;
import cable.social.app.model.Slider_model;
import cable.social.app.utility.CSPreferences;

import java.util.ArrayList;

public class SocialCommunity_Adapter extends RecyclerView.Adapter<SocialCommunity_Adapter.ViewHolder>{

    Context context;
    ArrayList<Slider_model.SocialCommunityUser> myCommunityUsersList_list;

    // RecyclerView recyclerView;
    public SocialCommunity_Adapter(Context context, ArrayList<Slider_model.SocialCommunityUser> MyCommunityUsersList_list) {
        this.context = context;
        this.myCommunityUsersList_list = MyCommunityUsersList_list;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.socialcommunity, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }




    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Slider_model.SocialCommunityUser myCommunityUsersList = myCommunityUsersList_list.get(position);
        Glide.with(context)
                .load(myCommunityUsersList.getChannelLogoImageUrl())
                .placeholder(R.drawable.channel_logo)
                .fitCenter()
                .into(holder.imageView);

        if(myCommunityUsersList.getChannelName().length()>6) {
            holder.name.setText(myCommunityUsersList.getChannelName().substring(0,6) + "...");
        }else{
            holder.name.setText(myCommunityUsersList.getChannelName());

        }


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CSPreferences.putString(context,"user_id_for_video", String.valueOf(myCommunityUsersList.getCustomerId()));
                context.startActivity(new Intent(context, MyEpisodActivity.class));
            }
        });
    }



    @Override
    public int getItemCount() {

//        return myCommunityUsersList_list.size();
        return myCommunityUsersList_list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView name;
        CardView cardView;
//        public RadioButton nouse;

        public ViewHolder(View itemView) {
            super(itemView);

                    imageView =itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            cardView = itemView.findViewById(R.id.card_view_social);


        }
    }
}
