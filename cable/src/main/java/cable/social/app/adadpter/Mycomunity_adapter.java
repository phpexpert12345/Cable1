package cable.social.app.adadpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import cable.social.app.R;
import cable.social.app.model.Slider_model;

import java.util.ArrayList;

public class Mycomunity_adapter extends RecyclerView.Adapter<Mycomunity_adapter.ViewHolder> {

    Context context;
    ArrayList<Slider_model.MyCommunityUsersList> myCommunityUsersList_list;

    // RecyclerView recyclerView;
    public Mycomunity_adapter(Context context, ArrayList<Slider_model.MyCommunityUsersList> MyCommunityUsersList_list) {
        this.context = context;
        this.myCommunityUsersList_list = MyCommunityUsersList_list;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.my_comunity_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.nouse.setVisibility(View.GONE);
        Slider_model.MyCommunityUsersList myCommunityUsersList = myCommunityUsersList_list.get(position);
        Glide.with(context)
                .load(myCommunityUsersList.getChannelCoverImage())
                .into(holder.imageView);

    }


    @Override
    public int getItemCount() {
        return myCommunityUsersList_list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public RadioButton nouse;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img);
            nouse = itemView.findViewById(R.id.nouse);

        }
    }
}

