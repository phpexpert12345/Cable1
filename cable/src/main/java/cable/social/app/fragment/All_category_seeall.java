package cable.social.app.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import cable.social.app.Interface.CategorySubcat_interface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.adadpter.Category_seellAdapter;
import cable.social.app.model.CategorySubList;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;
import cable.social.app.utility.RecyclerItemClickListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link All_category_seeall#newInstance} factory method to
 * create an instance of this fragment.
 */
public class All_category_seeall extends Fragment implements CategorySubcat_interface {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ArrayList<CategorySubList.Datum> data = new ArrayList<>();
    // TODO: Rename and change types of parameters
    private String cat_id;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    RecyclerView cat_recycleview;
    Category_seellAdapter category_seellAdapter;
    TextView txtnodata;

    public All_category_seeall() {
        // Required empty public constructor
    }

    View view;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment All_category_seeall.
     */
    // TODO: Rename and change types and number of parameters
    public static All_category_seeall newInstance(String param1, String param2) {
        All_category_seeall fragment = new All_category_seeall();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            cat_id = getArguments().getString("cat_id");
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_all_category_seeall, container, false);
        cat_recycleview = view.findViewById(R.id.cat_recycleview);
        txtnodata = view.findViewById(R.id.txtnodata);

        cat_recycleview.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        category_seellAdapter = new Category_seellAdapter(getActivity(), data);
        cat_recycleview.setAdapter(category_seellAdapter);

//        String cat_id = getArguments().getString("cat_id");

        if (GlobalClass.isNetworkConnected(getActivity())) {
            WebapiCall webapiCall = new WebapiCall();
            webapiCall.channelSubCategory(getActivity(), CSPreferences.readString(getActivity(), "tooken"), this, cat_id);
        } else {

            Toast.makeText(getActivity(), GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void categorysub_list(ArrayList<CategorySubList.Datum> list) {
            data.clear();
            data.addAll(list);
            cat_recycleview.getAdapter().notifyDataSetChanged();


    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
