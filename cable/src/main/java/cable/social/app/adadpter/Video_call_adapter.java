package cable.social.app.adadpter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import cable.social.app.R;

import cable.social.app.model.FriendListPoJO;
import cable.social.app.tokbox.VideocallActivity;

public class Video_call_adapter extends RecyclerView.Adapter<Video_call_adapter.ViewHolder> {

    Context context;
    ArrayList<FriendListPoJO.FriendList> arrayListvideo = new ArrayList<>();
    // RecyclerView recyclerView;
    public Video_call_adapter(Context context, ArrayList<FriendListPoJO.FriendList> arrayList) {
        this.context = context;
        this.arrayListvideo = arrayList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.videochat_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        Glide.with(context)
                .load(arrayListvideo.get(position).getCustomerProfilePic())
                .fitCenter()
                .placeholder(R.drawable.logo)
                .into(holder.profileimage);


         holder.profileName.setText(arrayListvideo.get(position).getCustomerName());


        holder.imgvideocall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, VideocallActivity.class).putExtra("price_", "no"));


            }
        });


    }


    @Override
    public int getItemCount() {
        return arrayListvideo.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgvideocall, imgaudiocall, profileimage;
        public TextView profileName;

        public ViewHolder(View itemView) {
            super(itemView);
            imgvideocall = itemView.findViewById(R.id.imgvideocall);
            imgaudiocall = itemView.findViewById(R.id.imgaudiocall);
            profileName = itemView.findViewById(R.id.profileName);
            profileimage = itemView.findViewById(R.id.profileimage);

        }
    }
}

