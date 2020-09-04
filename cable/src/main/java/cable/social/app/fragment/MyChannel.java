package cable.social.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cable.social.app.R;
import cable.social.app.adadpter.Recent_video_Adapter;
import cable.social.app.model.Slider_model;

public class MyChannel extends Fragment {
    Recent_video_Adapter recent_video_adapter;
    RecyclerView recyclerView;
    List<Slider_model.RecentVideo> recentVideoList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mychannel, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);

        LinearLayoutManager horizontalLayoutManagaer1
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManagaer1);
        recent_video_adapter = new Recent_video_Adapter(getActivity(),recentVideoList);
        recyclerView.setAdapter(recent_video_adapter);

        return view;
    }
}