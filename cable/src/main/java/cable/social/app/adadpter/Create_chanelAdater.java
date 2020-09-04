package cable.social.app.adadpter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import cable.social.app.R;
import cable.social.app.model.ChannelCategory_Pojo;
import cable.social.app.model.ChannelLogoList;

public class Create_chanelAdater extends RecyclerView.Adapter<Create_chanelAdater.ViewHolder> {

    Context context;
    int lastposition = -1;
    ItemClick itemClick;
    ArrayList<ChannelLogoList.Datum> arrayList;

    public interface ItemClick {
        void getId(String id);
    }

    // RecyclerView recyclerView;
    public Create_chanelAdater(Context context, ArrayList<ChannelLogoList.Datum> arrayList, ItemClick itemClick) {
        this.context = context;
        this.arrayList = arrayList;
        this.itemClick = itemClick;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.channel_cate_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Glide.with(context)
                .load(arrayList.get(position).getChannelLogoImage())
                .fitCenter()
                .placeholder(R.drawable.logo)
                .into(holder.imageView);


        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lastposition = position;
                itemClick.getId(arrayList.get(position).getId() + "");
                notifyDataSetChanged();
            }
        });

        if (lastposition == position) {
            holder.card_view.setCardBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            holder.card_view.setCardBackgroundColor(Color.parseColor("#020338"));
        }
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        CardView card_view;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            card_view = itemView.findViewById(R.id.card_view);

        }
    }
}

/*extends RecyclerView.Adapter<Create_chanelAdater.ViewHolder>{
    private int selectedStarPosition = -1;

    Context context;

    // RecyclerView recyclerView;
    public Create_chanelAdater(Context context) {
        this.context = context;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.socialcommunity, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);

        }

        @Override
        public void onClick(View view) {
            selectedStarPosition = getAdapterPosition();
           *//* notifyItemRangeChanged(0, subscribePlansLists.size());
            Log.d("sdadsa",subscribePlansLists.get(selectedStarPosition).getActualPlanPrice());

            membership_interface.getdata(subscribePlansLists.get(selectedStarPosition).getActualPlanPrice(),subscribePlansLists.get(selectedStarPosition).getPlanName());
*//*
            //cardView.setBackgroundColor(context.getResources().getColor(R.color.white));
            //  context.startActivity(new Intent(context, Payment.class));

        }
        public void bindData( int position) {
           // r_button.setChecked(position == selectedStarPosition);


        }
    }
}
*/