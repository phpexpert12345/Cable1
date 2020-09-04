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
import cable.social.app.activity.ShowVideoActivity;
import cable.social.app.model.CustomerIntroVideo_pojo;

import java.util.ArrayList;

public class MyIntroVideo_Adapter extends RecyclerView.Adapter<MyIntroVideo_Adapter.ViewHolder> {

    Context context;
    public ArrayList<CustomerIntroVideo_pojo.Datum> data ;


    // RecyclerView recyclerView;
    public MyIntroVideo_Adapter(Context context, ArrayList<CustomerIntroVideo_pojo.Datum> data) {
        this.context = context;
        this.data = data;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.my_intro_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context)
                .load(data.get(position).getIntroThumnail())
                .fitCenter()
                .placeholder(R.drawable.logo)
                .error(R.drawable.logo)
                .into(holder.imageView);
        holder.tital_name.setText(data.get(position).getTitle());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowVideoActivity.class);
                intent.putExtra("video", data.get(position).getIntroVideo());
                intent.putExtra("videoThumbnail", data.get(position).getIntroThumnail());
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

