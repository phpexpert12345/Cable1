package cable.social.app.adadpter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Map;

import cable.social.app.Interface.FreindRequestInterface;
import cable.social.app.Interface.FriendListInterface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.model.FriendRequest;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;
import de.hdodenhof.circleimageview.CircleImageView;

public class FriendRequestNotiAdaper extends RecyclerView.Adapter<FriendRequestNotiAdaper.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<FriendRequest.Datum> productList;
    FreindRequestInterface freindRequestInterface;

    //getting the context and product list with constructor
    public FriendRequestNotiAdaper(Context mCtx, List<FriendRequest.Datum> productList, FreindRequestInterface friendListInterface) {
        this.mCtx = mCtx;
        this.productList = productList;
        this.freindRequestInterface = friendListInterface;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.friend_request_item, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        FriendRequest.Datum product = productList.get(position);
        Glide.with(mCtx).load(product.getCustomerProfilePic()).into(holder.user_civ);
        if(position==productList.size()-1){
            holder.line_view.setVisibility(View.GONE);
        }else {
            holder.line_view.setVisibility(View.VISIBLE);
        }


        holder.Accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                serverCall("2",product.getCustomerId());
            }
        });

        holder.Reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                serverCall("0",product.getCustomerId());
            }
        });

        holder.name_tv.setText(product.getCustomerName() + "" + product.getCustomerLastName());

    }

    private void serverCall(String invite_status,String customer_id) {

        if (GlobalClass.isNetworkConnected(mCtx)) {
            WebapiCall webapiCall = new WebapiCall();
            webapiCall.FriendRequestAction(mCtx, CSPreferences.readString(mCtx, "tooken"),  CSPreferences.readString(mCtx, "auth_key"),invite_status,customer_id,freindRequestInterface);
        } else {
            Toast.makeText(mCtx, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }


    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        CircleImageView user_civ;
        View line_view;
        TextView name_tv;
        ImageView Accept,Reject;

        public ProductViewHolder(View itemView) {
            super(itemView);
            user_civ = itemView.findViewById(R.id.user_civ);
            line_view = itemView.findViewById(R.id.line_view);
            name_tv = itemView.findViewById(R.id.name_tv);
            Accept = itemView.findViewById(R.id.accept);
            Reject = itemView.findViewById(R.id.reject);
        }
    }
}
