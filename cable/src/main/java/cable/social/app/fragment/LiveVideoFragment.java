package cable.social.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import cable.social.app.Interface.LiveCustomer_interface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;

import cable.social.app.adadpter.LiveTv_Adapter;
import cable.social.app.model.LiveCustomerResponse;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LiveVideoFragment#newInstance} factory method to
 * create an instance of getActivity() fragment.
 */
public class LiveVideoFragment extends Fragment implements LiveCustomer_interface {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    LiveTv_Adapter liveTv_adapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<LiveCustomerResponse.Datum> arrayList = new ArrayList<>();
    RecyclerView recycleview_gernalvideo, recyclerView_Premimvideo, recycleviewsocal_commnicate;


    public LiveVideoFragment() {
        // Required empty public constructor
    }

    /**
     * Use getActivity() factory method to create a new instance of
     * getActivity() fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LiveVideoFragment newInstance(String param1, String param2) {
        LiveVideoFragment fragment = new LiveVideoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    RecyclerView recycleview_livetv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_livevideo, container, false);
        recycleview_livetv = view.findViewById(R.id.recycleview_livetv);


        LinearLayoutManager verticalLayoutManager_live = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recycleview_livetv.setLayoutManager(verticalLayoutManager_live);
        liveTv_adapter = new LiveTv_Adapter(getActivity(),arrayList);
        recycleview_livetv.setAdapter(liveTv_adapter);
        // Inflate the layout for getActivity() fragment




//        if (GlobalClass.isNetworkConnected(getActivity())) {
//            WebapiCall webapiCall = new WebapiCall();
//            webapiCall.livecustomerList(getActivity(), CSPreferences.readString(getActivity(), "tooken"), this);
//        } else {
//
//            Toast.makeText(getActivity(), GlobalClass.nointernet, Toast.LENGTH_LONG).show();
//        }

        return view;
    }

    @Override
    public void channelCategory(ArrayList<LiveCustomerResponse.Datum> list) {

        if(list.size()>0) {
            arrayList.clear();
            arrayList.addAll(list);
            recycleview_livetv.getAdapter().notifyDataSetChanged();
        }
    }
}
