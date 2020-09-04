package cable.social.app.adadpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.model.InvitedNotificationListPOJO;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;


public class Notification_Adapter extends RecyclerView.Adapter<Notification_Adapter.ViewHolder>{

    Context context;
    ArrayList<InvitedNotificationListPOJO.Datum> arrayList = new ArrayList<>();
    // RecyclerView recyclerView;
    public Notification_Adapter(Context context, ArrayList<InvitedNotificationListPOJO.Datum> arrayLists) {
        this.context = context;
        this.arrayList = arrayLists;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.custom_dialogaccetreject, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.hostesstxt.setText(arrayList.get(position).getCustomerName());
        holder.hostesstxt.setText(arrayList.get(position).getCustomerMobileNumber());
        holder.Accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GlobalClass.isNetworkConnected(context)) {
                    WebapiCall webapiCall = new WebapiCall();
                    webapiCall.friendRequestAction(context, CSPreferences.readString(context, "tooken"),
                            arrayList.get(position).getCustomerId(),"2", CSPreferences.readString(context, "auth_key"),holder.Accept);

                } else {

                    Toast.makeText(context, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }

            }
        });
    holder.reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GlobalClass.isNetworkConnected(context)) {
                    WebapiCall webapiCall = new WebapiCall();
                    webapiCall.friendRequestAction(context, CSPreferences.readString(context, "tooken"),
                            arrayList.get(position).getCustomerId(),"0", CSPreferences.readString(context, "auth_key"),holder.Accept);

                } else {

                    Toast.makeText(context, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
                }

            }
        });


    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView hostesstxt,txt_content,Accept,reject;
        public ViewHolder(View itemView) {
            super(itemView);

            hostesstxt = itemView.findViewById(R.id.hostesstxt);
            txt_content = itemView.findViewById(R.id.txt_content);
            Accept = itemView.findViewById(R.id.Accept);
            reject = itemView.findViewById(R.id.reject);

        }
    }
}
