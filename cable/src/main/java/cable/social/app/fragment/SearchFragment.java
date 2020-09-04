package cable.social.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import cable.social.app.Interface.Category_interface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.adadpter.Category_adapter;
import cable.social.app.adadpter.Category_allAdapter;
import cable.social.app.model.Category_model;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;
import cable.social.app.utility.RecyclerItemClickListener;

import java.util.ArrayList;


public class SearchFragment extends Fragment implements Category_interface {

    RecyclerView categoryrecycleview, recycleviewvatical;
    Category_adapter category_adapter;
    Category_allAdapter category_allAdapter;


    ArrayList<Category_model.CategoyList> categoyLists = new ArrayList<>();

    public SearchFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        categoryrecycleview = rootView.findViewById(R.id.recycleviewcategory);
        recycleviewvatical = rootView.findViewById(R.id.recycleviewvatical);

        //LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        categoryrecycleview.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        //categoryrecycleview.setLayoutManager(layoutManager);

        category_adapter = new Category_adapter(getActivity(), categoyLists);
        categoryrecycleview.setAdapter(category_adapter);


        categoryrecycleview.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Fragment fragment2 = new All_category_seeall();
                        FragmentManager fragmentManager2 = getActivity().getSupportFragmentManager();
                        fragmentManager2.beginTransaction().replace(R.id.content_frame, fragment2).commit();


                    }
                }));


        if (GlobalClass.isNetworkConnected(getActivity())) {
            WebapiCall categorylist = new WebapiCall();
            categorylist.category_list(getActivity(), this, CSPreferences.readString(getActivity(), "tooken"));


        } else {

            Toast.makeText(getActivity(), GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }







      /*  LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recycleviewvatical.setLayoutManager(verticalLayoutManager);


        category_allAdapter = new Category_allAdapter(getActivity());
        recycleviewvatical.setAdapter(category_allAdapter);*/

        return rootView;

    }

    @Override
    public void category_list(ArrayList<Category_model.CategoyList> list) {
        categoyLists.clear();
        categoyLists.addAll(list);
        categoryrecycleview.getAdapter().notifyDataSetChanged();

    }
}

