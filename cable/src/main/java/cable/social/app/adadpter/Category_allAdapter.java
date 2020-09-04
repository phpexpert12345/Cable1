package cable.social.app.adadpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import cable.social.app.R;

public class Category_allAdapter  extends RecyclerView.Adapter<Category_allAdapter.ViewHolder>{

    Context context;

    // RecyclerView recyclerView;
    public Category_allAdapter(Context context) {
        this.context = context;

    }
    @Override
    public Category_allAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.category_row_all, parent, false);
        Category_allAdapter.ViewHolder viewHolder = new Category_allAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Category_allAdapter.ViewHolder holder, int position) {

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}