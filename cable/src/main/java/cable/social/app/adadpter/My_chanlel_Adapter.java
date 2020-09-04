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
import cable.social.app.model.ChannelList_Model;
import de.hdodenhof.circleimageview.CircleImageView;

import java.util.ArrayList;

public class My_chanlel_Adapter extends RecyclerView.Adapter<My_chanlel_Adapter.ViewHolder>{

    Context context;
    ArrayList<ChannelList_Model.Data> arrayList = new ArrayList<>();
    // RecyclerView recyclerView;
    public My_chanlel_Adapter(Context context, ArrayList<ChannelList_Model.Data> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.my_chanal_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        Glide.with(context)
                .load(arrayList.get(position).getChannelLogo())
                .fitCenter()
                .into(holder.imageView);

        holder.textView.setText(arrayList.get(position).getChannelName());
        holder.like.setText(arrayList.get(position).getTotalLike() + " Likes");
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
//        public ImageView imageView;


        CircleImageView imageView;
        public TextView textView;
        public TextView like;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.textView);
            like = itemView.findViewById(R.id.like);



        }
    }
}