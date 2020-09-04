package cable.social.app.adadpter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import cable.social.app.R;
import cable.social.app.activity.Video_deatil;
import cable.social.app.model.MyVideo;

public class MyEpisodeAdaper extends RecyclerView.Adapter<MyEpisodeAdaper.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<MyVideo.Datum> productList;
    int isVisible=0;
    //getting the context and product list with constructor
    public MyEpisodeAdaper(Context mCtx, List<MyVideo.Datum> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.episode_item, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        MyVideo.Datum product = productList.get(position);


        Glide.with(mCtx).load(product.getMovieThumbnail()).into(holder.imageView_cover);
        holder.tital_name.setText(product.getVideoTitle());

        if(!product.getTotalLikes().equals("0")) {
            holder.total_like.setText(product.getTotalLikes() + " Likes");
        }
        holder.video_date.setText(product.getReleaseDate());
        if(!product.getTotalViews().equals("0")) {

            holder.total_view.setText(product.getTotalViews() + " Views");
        }

        holder.play_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mCtx, Video_deatil.class);
                i.putExtra("videoId",product.getId());
                i.putExtra("Ispremiumvideo","no");
                mCtx.startActivity(i);
            }
        });





//        holder.dots_iv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(isVisible==0){
//                    isVisible=1;
//                    holder.menu_ll.setVisibility(View.VISIBLE);
//                }else {
//                    isVisible=0;
//                    holder.menu_ll.setVisibility(View.GONE);
//                }
//
//            }
//        });

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


     static class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView_cover;
        LinearLayout play_ll;
        TextView tital_name,total_like,video_date,total_view;


        public ProductViewHolder(View itemView) {
            super(itemView);
//            dots_iv=itemView.findViewById(R.id.dots_iv);
            imageView_cover=itemView.findViewById(R.id.imageView_cover);
//            menu_ll=itemView.findViewById(R.id.menu_ll);
            play_ll=itemView.findViewById(R.id.play_ll);
            tital_name = itemView.findViewById(R.id.tital_name);
            total_like = itemView.findViewById(R.id.total_like_e);
            video_date = itemView.findViewById(R.id.video_date_e);
            total_view = itemView.findViewById(R.id.total_views_e);
        }
    }
}
