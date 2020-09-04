package cable.social.app.adadpter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import cable.social.app.R;

import cable.social.app.activity.MainActivity;
import cable.social.app.fragment.SearchVideoFragment;
import cable.social.app.model.Category_model;

import java.util.ArrayList;
import java.util.List;

public class Category_adapter extends RecyclerView.Adapter<Category_adapter.ViewHolder> {

    private Context context;
    private ArrayList<Category_model.CategoyList> categoyLists = new ArrayList<>();
    private List<Category_model.CategoyList> displayedList = new ArrayList<>();

    // RecyclerView recyclerView;
    public Category_adapter(Context context, ArrayList<Category_model.CategoyList> categoyLists) {
        this.context = context;
        this.categoyLists = categoyLists;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.category_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Category_model.CategoyList categoyList = categoyLists.get(position);

        Glide.with(context)
                .load(categoyList.getCategoryPhoto())
                .fitCenter()
                .placeholder(R.drawable.logo)
                .into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle=new Bundle();
                bundle.putInt("cat_id", categoyList.getId());
                bundle.putInt("position", position);
                bundle.putParcelableArrayList("cat_list", categoyLists);

                //set Fragmentclass Arguments

                MainActivity myActivity = (MainActivity) context;


                Fragment fragment2 = new SearchVideoFragment();

                fragment2.setArguments(bundle);


//                FragmentManager fragmentManager2 = getActivity().getSupportFragmentManager();
//                fragmentManager2.beginTransaction().replace(R.id.content_frame, fragment2).commit();
                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment2).addToBackStack(null).commit();


            }
        });


//        holder.tital_name.setText(categoyList.getCategoryName());
    }


    public void updateList(ArrayList<Category_model.CategoyList> list){
        this.categoyLists = list;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return categoyLists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
//        public TextView tital_name;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
//            tital_name=itemView.findViewById(R.id.tital_name);

        }
    }
}
