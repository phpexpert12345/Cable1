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
import java.util.List;

import cable.social.app.R;
import cable.social.app.activity.SeriesEpisodeActivity;
import cable.social.app.model.SeasonSeries;

public class MyPlaylist_video_Adapter extends RecyclerView.Adapter<MyPlaylist_video_Adapter.ViewHolder>{

    Context context;
    List<SeasonSeries.Datum> seasonSeriesLists = new ArrayList<>();


    // RecyclerView recyclerView;
    public MyPlaylist_video_Adapter(Context context, List<SeasonSeries.Datum> seasonSeriesList) {
        this.context = context;
        this.seasonSeriesLists = seasonSeriesList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.myplaylistrow, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        SeasonSeries.Datum data  = seasonSeriesLists.get(position);

        holder.title.setText(data.getSeriesName());

        Glide.with(context)
                .load(data.getSeriesCover())
                .fitCenter()
                .placeholder(R.drawable.logo)
                .error(R.drawable.logo)
                .into(holder.imageView);


        holder.Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, SeriesEpisodeActivity.class);

                i.putExtra("series_id",data.getSeriesId());

                context.startActivity(i);

            }
        });


    }


    @Override
    public int getItemCount() {
        return seasonSeriesLists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView,Add;
        public TextView title;

        public ViewHolder(View itemView) {
            super(itemView);

            Add = itemView.findViewById(R.id.add);
            imageView = itemView.findViewById(R.id.imgg);
            title = itemView.findViewById(R.id.tital_name);
        }
    }
}
