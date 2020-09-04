package cable.social.app.adadpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Map;

import cable.social.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class MyNotiAdapter extends RecyclerView.Adapter<MyNotiAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Map<String,String>> productList;

    //getting the context and product list with constructor
    public MyNotiAdapter(Context mCtx, List<Map<String,String>> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.my_noti_item, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        Map<String,String> product = productList.get(position);

        Glide.with(mCtx).load(product.get("userimg")).into(holder.user_civ);
        if(position==productList.size()-1){
            holder.line_view.setVisibility(View.GONE);
        }else {
            holder.line_view.setVisibility(View.VISIBLE);
        }
        holder.name_tv.setText(product.get("name"));


    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        CircleImageView user_civ;
        View line_view;
        TextView name_tv;

        public ProductViewHolder(View itemView) {
            super(itemView);
            user_civ = itemView.findViewById(R.id.user_civ);
            line_view = itemView.findViewById(R.id.line_view);
            name_tv = itemView.findViewById(R.id.name_tv);
        }
    }
}
