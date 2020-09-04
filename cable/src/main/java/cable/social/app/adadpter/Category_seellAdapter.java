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
import cable.social.app.R;
import cable.social.app.activity.Video_deatil;
import cable.social.app.model.CategorySubList;

import java.util.ArrayList;

public class Category_seellAdapter extends RecyclerView.Adapter<Category_seellAdapter.ViewHolder> {

    Context context;
    private ArrayList<CategorySubList.Datum> data = new ArrayList<>();


    // RecyclerView recyclerView;
    public Category_seellAdapter(Context context, ArrayList<CategorySubList.Datum> data) {
        this.context = context;
        this.data = data;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.cateogoryseeall_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context)
                .load(data.get(position).getMovieThumbnail())
                .fitCenter()
                .placeholder(R.drawable.logo)
                .error(R.drawable.logo)
                .into(holder.imageView);
        holder.tital_name.setText(data.get(position).getSeoTitle());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Video_deatil.class).putExtra("videoId",data.get(position).getId()).putExtra("Ispremiumvideo","no");
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView tital_name;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tital_name = itemView.findViewById(R.id.tital_name);

        }
    }
}

