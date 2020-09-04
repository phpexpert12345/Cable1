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

public class Primium_video_adapters extends RecyclerView.Adapter<Primium_video_adapters.ViewHolder>{

    Context context;
    ArrayList<Slider_model.FreeVideoList> PremiumCommunityUsers_list = new ArrayList<>();

    // RecyclerView recyclerView;
    public Primium_video_adapters(Context context,ArrayList<Slider_model.FreeVideoList> PremiumCommunityUsers_list) {
        this.context = context;
        this.PremiumCommunityUsers_list = PremiumCommunityUsers_list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.premium, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Slider_model.FreeVideoList arraylist = PremiumCommunityUsers_list.get(position);
        holder.textView.setVisibility(View.GONE);

        Glide.with(context)
                .load(arraylist.getMoviePoster())
                .fitCenter()
                .placeholder(R.drawable.logo)
                .into(holder.poster_image);
        holder.textView.setText(arraylist.getSeoTitle());
      //  holder.textView_date.setText(arraylist.get());


    }


    @Override
    public int getItemCount() {
        return PremiumCommunityUsers_list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView poster_image;
        public TextView textView,textView_date,tital_name;
        public ViewHolder(View itemView) {
            super(itemView);
            poster_image =itemView.findViewById(R.id.poster_image);
            textView =itemView.findViewById(R.id.star_);
            textView_date =itemView.findViewById(R.id.textView_date);
            tital_name =itemView.findViewById(R.id.tital_name);

        }
    }
}
