package cable.social.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cable.social.app.Interface.SeasonSeries;
import cable.social.app.Interface.SeriesInterface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;

import cable.social.app.adadpter.MyPlaylist_video_Adapter;
import cable.social.app.model.SeriesList;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;

public class MyTotalSeries extends AppCompatActivity implements SeasonSeries {
     RecyclerView recyclerView;
    MyPlaylist_video_Adapter gernal_video_adapter;



        @Override
        public void onCreate(Bundle savedInstanceState){

            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_album);

            recyclerView = findViewById(R.id.recyclerView);

            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

            if (GlobalClass.isNetworkConnected(this)) {
                WebapiCall sliderlist = new WebapiCall();
                sliderlist.getSeasonSeries(this, this, CSPreferences.readString(this, "tooken"), CSPreferences.readString(this, "auth_key"));
            } else {

                Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
            }

        }

    public void close(View view) {
            finish();
    }



    @Override
    public void SeasonData(List<cable.social.app.model.SeasonSeries.Datum> seasonSeries) {

            if(seasonSeries.size()>0) {
                gernal_video_adapter = new MyPlaylist_video_Adapter(this, seasonSeries);
                recyclerView.setAdapter(gernal_video_adapter);
            }else {
                GlobalClass.showtost(this,"no Series Found");
            }
    }
}