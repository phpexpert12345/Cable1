package cable.social.app.adadpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cable.social.app.R;
import cable.social.app.activity.Video_deatil;
import cable.social.app.model.VideoDetailModel;


public class Cast_Adapter extends RecyclerView.Adapter<Cast_Adapter.ViewHolder> {

    Context context;

    ArrayList<VideoDetailModel.Data.Genre> genricarrayList = new ArrayList<>();

    public Cast_Adapter(Video_deatil video_deatil, ArrayList<VideoDetailModel.Data.Genre> genricarrayList) {
        this.context = video_deatil;
        this.genricarrayList = genricarrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.cost_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return genricarrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}
