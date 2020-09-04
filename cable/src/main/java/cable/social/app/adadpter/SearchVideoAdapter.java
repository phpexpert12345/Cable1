package cable.social.app.adadpter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import cable.social.app.R;
import cable.social.app.activity.Video_deatil;
import cable.social.app.model.CategorySubList;

public class SearchVideoAdapter extends RecyclerView.Adapter<SearchVideoAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    ArrayList<CategorySubList.Datum> productList;

    //getting the context and product list with constructor
    public SearchVideoAdapter(Context mCtx, ArrayList<CategorySubList.Datum> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public SearchVideoAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.video_search_item, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchVideoAdapter.ProductViewHolder holder, int position) {
        //getting the product of the specified position
        CategorySubList.Datum product = productList.get(position);


        Glide.with(mCtx).load(product.getMovieThumbnail()).into(holder.imageview);

        holder.video_title.setText(product.getVideoTitle());
        holder.video_date.setText(product.getUpdatedAt());
        if(!product.getChannelId().isEmpty()) {
            holder.logoRl.setVisibility(View.VISIBLE);
            holder.user_name.setText(product.getChannelName());
            Glide.with(mCtx).load(product.getChannelLogoImageUrl()).into(holder.ChnlImg);
        }else{
            holder.logoRl.setVisibility(View.GONE);

        }



        holder.imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Bundle bundle=new Bundle();
//                bundle.putString("cat_id", String.valueOf(product.getId()));
//                //set Fragmentclass Arguments
//
//                MainActivity myActivity = (MainActivity) mCtx;
//
//
//                Fragment fragment2 = new All_category_seeall();
//
//                fragment2.setArguments(bundle);
//
//
////                FragmentManager fragmentManager2 = getActivity().getSupportFragmentManager();
////                fragmentManager2.beginTransaction().replace(R.id.content_frame, fragment2).commit();
//                myActivity.getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment2).addToBackStack(null).commit();

                Intent intent = new Intent(mCtx, Video_deatil.class).putExtra("videoId", String.valueOf(product.getId())).putExtra("Ispremiumvideo", "no");
                mCtx.startActivity(intent);


            }
        });


    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    static class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imageview, ChnlImg;
        TextView video_title, video_date, user_name;
        RelativeLayout logoRl;

        public ProductViewHolder(View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.imageview);
            video_title = itemView.findViewById(R.id.video_search_title);
            video_date = itemView.findViewById(R.id.video_search_date);
            user_name = itemView.findViewById(R.id.user_name);
            ChnlImg = itemView.findViewById(R.id.chnl_img);
            logoRl = itemView.findViewById(R.id.logo_rl);
        }
    }
}