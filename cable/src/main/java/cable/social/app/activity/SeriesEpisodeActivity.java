package cable.social.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cable.social.app.Interface.SeriesInterface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.model.SeriesList;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;

public class SeriesEpisodeActivity extends AppCompatActivity implements SeriesInterface {

    List<SeriesList.Data.Season> serieszList = new ArrayList<>();
    List<SeriesList.Data.Season.Episode> episodeList = new ArrayList<>();
    List<String> seasonName = new ArrayList<>();
    List<String> episodeName = new ArrayList<>();

    ArrayAdapter season_spnr_adapter,episode_spnr_adapter;
    Spinner SeriesSpinner,EpisodeSpinner;

    LinearLayout ll,EpisodeLL;
    String series_id,season_id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_episode);

        series_id = getIntent().getStringExtra("series_id");

        SeriesSpinner = (Spinner) findViewById(R.id.series_spnr);
        EpisodeSpinner = (Spinner) findViewById(R.id.episode_spnr);
        ll = (LinearLayout)findViewById(R.id.series_panchayat_linear);
        EpisodeLL = (LinearLayout)findViewById(R.id.episode_ll);


        if (GlobalClass.isNetworkConnected(this)) {
            WebapiCall sliderlist = new WebapiCall();
            sliderlist.getSeasons(this, this, CSPreferences.readString(this, "tooken"), CSPreferences.readString(this, "auth_key"),series_id);
        } else {
            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }


        SeriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    EpisodeLL.setVisibility(View.GONE);
                } else if(serieszList.size()== i-1) {
                    EpisodeLL.setVisibility(View.GONE);
                    Intent intent = new Intent(SeriesEpisodeActivity.this,EpisodInfoActivity.class);
                    intent.putExtra("from",1);
                    intent.putExtra("series_id",series_id);
                    startActivity(intent);

                }else{
                        EpisodeLL.setVisibility(View.VISIBLE);
                        episodeName.clear();
                        episodeName.add("Episode");
                        episodeList.clear();
                        episodeList.addAll(serieszList.get(i-1).getEpisodes());

                        season_id = String.valueOf(serieszList.get(i-1).getSeasonId());


                        for (int j = 0; j < episodeList.size(); j++) {

                            if(episodeList.get(j).getVideoTitle()!=null) {
                                episodeName.add(episodeList.get(j).getVideoTitle());
                            }
                        }


                        episodeName.add("Upload new Episode");
                        updateAdapter();
                    }
                }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });




        EpisodeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              if(episodeList.size()== i-1) {
                    Intent intent = new Intent(SeriesEpisodeActivity.this,EpisodInfoActivity.class);
                    intent.putExtra("from",2);
                    intent.putExtra("series_id",series_id);
                    intent.putExtra("season_id",season_id);
                    startActivity(intent);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });







    }


    public void updateAdapter(){
        episode_spnr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, episodeName);
        EpisodeSpinner.setAdapter(episode_spnr_adapter);
    }



    @Override
    public void SeriesList(List<SeriesList.Data.Season> seriesList) {
        if(seriesList.size()>0) {
            ll.setVisibility(View.VISIBLE);
//            this.serieszList = seriesList;
            seasonName.clear();
            seasonName.add("Seasons");
            serieszList.clear();
            serieszList.addAll(seriesList);

            for (int i = 0; i < seriesList.size(); i++) {
//                for (int k = 0; k < serieszList.get(i).g(); k++) {

                if(serieszList.get(i).getSeasonTitle()!=null) {

                    seasonName.add(serieszList.get(i).getSeasonTitle());
                }
//                }
            }

            seasonName.add("Start New Season");

            season_spnr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, seasonName);
            SeriesSpinner.setAdapter(season_spnr_adapter);
        }else{
            GlobalClass.showtost(this,"No Series Found");
        }
    }


    public void close(View view) {
        finish();
    }
}