package cable.social.app.adadpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cable.social.app.R;
import cable.social.app.model.Slider_model;

public class Recent_video_Adapter extends RecyclerView.Adapter<Recent_video_Adapter.ViewHolder>{

    Context context;
    List<Slider_model.RecentVideo> recentVideos = new ArrayList<>();

    // RecyclerView recyclerView;
    public Recent_video_Adapter(Context context, List<Slider_model.RecentVideo> list) {
        this.context = context;
        this.recentVideos = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.gernal, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Slider_model.RecentVideo recentVideo = recentVideos.get(position);

        Glide.with(context)
                .load(recentVideo.getMovieThumbnail())
                .fitCenter()
                .placeholder(R.drawable.img)
                .into(holder.Recent_Image);
        holder.Recent_Title.setText(recentVideo.getVideoTitle());

    }


    @Override
    public int getItemCount() {
        return recentVideos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView Recent_Image;
        public TextView Recent_Title;


        public ViewHolder(View itemView) {
            super(itemView);

            Recent_Image = (ImageView)itemView.findViewById(R.id.recent_img);
            Recent_Title = (TextView)itemView.findViewById(R.id.recent_tital_name);


        }
    }
}
