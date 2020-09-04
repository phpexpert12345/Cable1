package cable.social.app.adadpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import cable.social.app.R;
import cable.social.app.model.Slider_model;

import java.util.ArrayList;

public class Premium_video_Adapter extends RecyclerView.Adapter<Premium_video_Adapter.ViewHolder> {

    Context context;
    ArrayList<Slider_model.PremiumVideoList> primevideoLists = new ArrayList<>();

    // RecyclerView recyclerView;
    public Premium_video_Adapter(Context context, ArrayList<Slider_model.PremiumVideoList> primevideoLists) {
        this.context = context;
        this.primevideoLists = primevideoLists;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.premium, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Slider_model.PremiumVideoList primevideo = primevideoLists.get(position);

        Glide.with(context)
                .load(primevideo.getMovieThumbnail())
                .fitCenter()
                .placeholder(R.drawable.logo)
                .into(holder.poster_image);
        holder.textView.setText(primevideo.getVideoTitle());
    }


    @Override
    public int getItemCount() {

        return primevideoLists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView poster_image;
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            poster_image = itemView.findViewById(R.id.poster_image);
            textView = itemView.findViewById(R.id.tital_name);

        }
    }
}
