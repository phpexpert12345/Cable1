package cable.social.app.adadpter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import cable.social.app.R;

import cable.social.app.activity.Video_deatil;
import cable.social.app.model.Slider_model;

import java.util.ArrayList;

public class SaliderAdapter extends RecyclerView.Adapter<SaliderAdapter.ViewHolder> {

    Context context;
    ArrayList<Slider_model.SliderList> categoyLists = new ArrayList<>();
    ViewPager2 viewPager2;

    // RecyclerView recyclerView;
    public SaliderAdapter(Context context, ArrayList<Slider_model.SliderList> salider, ViewPager2 pager) {
        this.context = context;
        this.categoyLists = salider;
        this.viewPager2 = pager;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       /* LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.category_row, parent, false);
        SaliderAdapter.ViewHolder viewHolder = new SaliderAdapter.ViewHolder(listItem);
*/


        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_image,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Slider_model.SliderList categoyList = categoyLists.get(position);

        Glide.with(context)
                .load(categoyList.getSliderImage())
                .fitCenter()
                .placeholder(R.drawable.logo)
                .into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Video_deatil.class);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return categoyLists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView tital_name;

        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}
