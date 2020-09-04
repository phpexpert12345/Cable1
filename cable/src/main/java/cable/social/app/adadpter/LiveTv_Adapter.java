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
import cable.social.app.model.LiveCustomerResponse;

import java.util.ArrayList;

public class LiveTv_Adapter extends RecyclerView.Adapter<LiveTv_Adapter.ViewHolder> {

    Context context;
    ArrayList<LiveCustomerResponse.Datum> arrayList = new ArrayList<>();

    // RecyclerView recyclerView;
    public LiveTv_Adapter(Context context, ArrayList<LiveCustomerResponse.Datum> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }

    @Override
    public LiveTv_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.live_tv_row, parent, false);
        LiveTv_Adapter.ViewHolder viewHolder = new LiveTv_Adapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LiveTv_Adapter.ViewHolder holder, int position) {
        Glide.with(context)
                .load(arrayList.get(position).getChannelLogo())
                .fitCenter()
                .placeholder(R.drawable.logo)
                .into(holder.imageView);
        holder.textView.setText(arrayList.get(position).getChannelName());
        holder.textdate.setText(arrayList.get(position).getExpiredDate());
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView, textdate;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.tital_name);
            textdate = itemView.findViewById(R.id.textdate);


        }
    }
}