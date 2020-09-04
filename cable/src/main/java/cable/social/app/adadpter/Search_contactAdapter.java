package cable.social.app.adadpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import cable.social.app.R;


public class Search_contactAdapter extends RecyclerView.Adapter<Search_contactAdapter.ViewHolder>{

    Context context;

    // RecyclerView recyclerView;
    public Search_contactAdapter(Context context) {
        this.context = context;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.search_contact_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*    Intent intent = new Intent(context, VideocallActivity.class);
                context.startActivity(intent);*/

            }
        });

    }


    @Override
    public int getItemCount() {
        return 20;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView,call;
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.camra);
            call=itemView.findViewById(R.id.call);

        }
    }
}


