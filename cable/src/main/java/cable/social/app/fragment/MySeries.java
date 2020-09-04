package cable.social.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import cable.social.app.R;
import cable.social.app.adadpter.MyPlaylist_video_Adapter;

public class MySeries extends Fragment {

    RecyclerView recyclerView;
    MyPlaylist_video_Adapter premium_video_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_myseries, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

//        premium_video_adapter = new MyPlaylist_video_Adapter(getActivity());
//        recyclerView.setAdapter(premium_video_adapter);

        return view;
    }
}
