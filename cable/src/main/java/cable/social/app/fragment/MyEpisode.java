package cable.social.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cable.social.app.Interface.VideoFetched_interface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.adadpter.MyEpisodeAdaper;
import cable.social.app.model.MyVideo;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;

public class MyEpisode extends Fragment implements VideoFetched_interface {
    private RecyclerView episod_recycler;

    private List<MyVideo.Datum>episodeList=new LinkedList<>();




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_my_episode,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        episod_recycler=view.findViewById(R.id.episod_recycler);
        episod_recycler.setLayoutManager(new GridLayoutManager(getActivity(),2));

        MyEpisodeAdaper myEpisodeAdaper=new MyEpisodeAdaper(getActivity(),episodeList);
        episod_recycler.setAdapter(myEpisodeAdaper);


        if (GlobalClass.isNetworkConnected(getActivity())) {
            WebapiCall categorylist = new WebapiCall();
            categorylist.my_video_list(getActivity(), this, CSPreferences.readString(getActivity(), "tooken"),CSPreferences.readString(getActivity(), "user_id_for_video"),"1");
        } else {
            Toast.makeText(getActivity(), GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }


    }


    @Override
    public void Fetched(List<MyVideo.Datum> list) {
        if(list.size()>0) {
            episod_recycler.setVisibility(View.VISIBLE);

            episodeList.clear();
            episodeList.addAll(list);
            episod_recycler.getAdapter().notifyDataSetChanged();
        }else {
            episod_recycler.setVisibility(View.GONE);
        }


    }
}
