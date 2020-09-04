package cable.social.app.adadpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cable.social.app.Interface.VideoListInterface;
import cable.social.app.Interface.Video_detail_Interfae;
import cable.social.app.R;
import cable.social.app.model.Category_model;

public class CatTabAdapter extends RecyclerView.Adapter<CatTabAdapter.ProductViewHolder>  {


    //this context we will use to inflate the layout
    private Context mCtx;
    VideoListInterface videoListInterface;

    //we are storing all the products in a list
    private ArrayList<Category_model.CategoyList> productList;
    private int lastposition=0;

    //getting the context and product list with constructor
    public CatTabAdapter(Context mCtx, ArrayList<Category_model.CategoyList> productList , VideoListInterface videoListInterface,int lastposition) {
        this.mCtx = mCtx;
        this.productList = productList;
        this.videoListInterface = videoListInterface;
        this.lastposition = lastposition;
    }

    @Override
    public CatTabAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.cat_tab_item, null);
        return new CatTabAdapter.ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CatTabAdapter.ProductViewHolder holder, int position) {
        //getting the product of the specified position
        Category_model.CategoyList product = productList.get(position);
        holder.tab_tv.setText(product.getCategoryName());
        if(lastposition==position){
            holder.tab_tv.setBackgroundResource(R.drawable.blue_btn_bg);
        }else {
            holder.tab_tv.setBackground(null);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lastposition=position;
                notifyDataSetChanged();
                videoListInterface.VideoListInterface(product.getId());

            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }




    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView tab_tv;
        public ProductViewHolder(View itemView) {
            super(itemView);
            tab_tv = itemView.findViewById(R.id.tab_tv);
        }
    }
}