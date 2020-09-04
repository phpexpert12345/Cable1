package cable.social.app.adadpter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import cable.social.app.Interface.Membership_interface;
import cable.social.app.R;
import cable.social.app.model.SubscribePlans_model;

import java.util.ArrayList;

public class MembershipAdapter extends RecyclerView.Adapter<MembershipAdapter.ViewHolder> {
    private int selectedStarPosition = -1;
    Membership_interface membership_interface;
    Context context;
    ArrayList<SubscribePlans_model.SubscribePlansList> subscribePlansLists = new ArrayList<>();

    // RecyclerView recyclerView;
    public MembershipAdapter(Context context, ArrayList<SubscribePlans_model.SubscribePlansList> subscribePlansLists,
                             Membership_interface membership_interface) {
        this.context = context;
        this.subscribePlansLists = subscribePlansLists;
        this.membership_interface = membership_interface;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.membership_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        SubscribePlans_model.SubscribePlansList subscribePlansList = subscribePlansLists.get(position);
        Log.d("sjjshajd", subscribePlansList.getCurrency());
        holder.tital_name.setText(subscribePlansLists.get(position).getPlanName());
        holder.price.setText("$" + subscribePlansLists.get(position).getActualPlanPrice());
        if(selectedStarPosition==position){
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.white));
            holder.tital_name.setTextColor(Color.parseColor("#000000"));
            holder.price.setTextColor(Color.parseColor("#000000"));
            holder.discraption.setTextColor(Color.parseColor("#777777"));
        }else {
            holder.tital_name.setTextColor(Color.parseColor("#ffffff"));
            holder.price.setTextColor(Color.parseColor("#ffffff"));
            holder.discraption.setTextColor(Color.parseColor("#ffffff"));
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.blue2));
        }

        holder.bindData(position);


    }


    @Override
    public int getItemCount() {
        return subscribePlansLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView tital_name;
        public TextView price,discraption;
        RadioButton r_button;

        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            tital_name = itemView.findViewById(R.id.tital_name);
            discraption = itemView.findViewById(R.id.discraption);
            price = itemView.findViewById(R.id.price);
            r_button = itemView.findViewById(R.id.r_button);
            cardView = itemView.findViewById(R.id.cardview);
            r_button.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            selectedStarPosition = getAdapterPosition();
            notifyItemRangeChanged(0, subscribePlansLists.size());
            Log.d("sdadsa", subscribePlansLists.get(selectedStarPosition).getActualPlanPrice());

            membership_interface.getdata(subscribePlansLists.get(selectedStarPosition).getActualPlanPrice(), subscribePlansLists.get(selectedStarPosition).getPlanName());




        }

        public void bindData(int position) {
            r_button.setChecked(position == selectedStarPosition);


        }
    }
}
