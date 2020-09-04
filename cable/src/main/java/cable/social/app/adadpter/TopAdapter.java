package cable.social.app.adadpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.model.Invite_lists_Model;
import cable.social.app.model.Slider_model;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Slider_model.SliderList> productList;

    //getting the context and product list with constructor
    public TopAdapter(Context mCtx, List<Slider_model.SliderList> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.fragment_image, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        Slider_model.SliderList product = productList.get(position);


        Glide.with(mCtx).load(product.getSliderImage()).into(holder.imageview);

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imageview;

        public ProductViewHolder(View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.imageview);
        }
    }
}
