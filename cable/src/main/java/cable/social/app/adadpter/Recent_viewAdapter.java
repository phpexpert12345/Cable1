package cable.social.app.adadpter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import cable.social.app.R;

import cable.social.app.activity.Video_deatil;
import cable.social.app.model.VideoDetailModel;

import java.util.ArrayList;


public class Recent_viewAdapter extends RecyclerView.Adapter<Recent_viewAdapter.ViewHolder> {

    Context context;
    ArrayList<VideoDetailModel.Data.SimilarVideo> arrayList;

    // RecyclerView recyclerView;
    public Recent_viewAdapter(Context context, ArrayList<VideoDetailModel.Data.SimilarVideo> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.recentaly_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Glide.with(context)
                .load(arrayList.get(position).getMovieThumbnail())
                .fitCenter()
                .placeholder(R.drawable.logo)
                .into(holder.imageView);


        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, Video_deatil.class).putExtra("videoId",arrayList.get(position).getId()).putExtra("Ispremiumvideo","no"));
                ((Activity)context).finish();

            }
        });



    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView tital_name, textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_recent);
            tital_name = itemView.findViewById(R.id.tital_name_recent);
            textView = itemView.findViewById(R.id.textView_recent);

        }
    }
}

