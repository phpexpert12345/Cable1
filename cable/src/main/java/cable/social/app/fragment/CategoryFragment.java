package cable.social.app.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cable.social.app.Interface.Category_interface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.adadpter.Category_adapter;
import cable.social.app.adadpter.Category_allAdapter;
import cable.social.app.model.Category_model;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;


public class CategoryFragment extends Fragment implements Category_interface {

    private RecyclerView categoryrecycleview;
    private Category_adapter category_adapter;
    Category_allAdapter category_allAdapter;
    private EditText searchField;
    private TextView search_txt,no_result;
    private String search_key;

    private ArrayList<Category_model.CategoyList> categoyLists = new ArrayList<>();

    public CategoryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_category, container, false);
        categoryrecycleview = rootView.findViewById(R.id.recycleviewcategory);
        searchField =  rootView.findViewById(R.id.search_field);
        search_txt = rootView.findViewById(R.id.search_txt);
        no_result = rootView.findViewById(R.id.no_result);



        //LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        categoryrecycleview.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        //categoryrecycleview.setLayoutManager(layoutManager);

        category_adapter = new Category_adapter(getActivity(), categoyLists);
        categoryrecycleview.setAdapter(category_adapter);


        if (GlobalClass.isNetworkConnected(getActivity())) {
            WebapiCall categorylist = new WebapiCall();
            categorylist.category_list(getActivity(), this, CSPreferences.readString(getActivity(), "tooken"));
        } else {
            Toast.makeText(getActivity(), GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }


        searchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                filter(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
                filter(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

                // filter your list from your input
                filter(s.toString());
                //you can use runnable postDelayed like 500 ms to delay search text
            }
        });


        search_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                search_key = searchField.getText().toString();

                filter(search_key);
                Toast.makeText(getActivity(),"Search Result of " +search_key,Toast.LENGTH_SHORT).show();
            }
        });




        return rootView;

    }


    private void filter(String text){
        ArrayList<Category_model.CategoyList> temp = new ArrayList();
        for(Category_model.CategoyList d: categoyLists){
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if(d.getCategoryName().toLowerCase().contains(text.toLowerCase())){
                temp.add(d);
            }
        }
        //update recyclerview
        category_adapter.updateList(temp);




    }




    @Override
    public void category_list(ArrayList<Category_model.CategoyList> list) {

        if(list.size()==0){
            no_result.setVisibility(View.VISIBLE);
        }else{
            no_result.setVisibility(View.GONE);

        }


        categoyLists.clear();
        categoyLists.addAll(list);
        categoryrecycleview.getAdapter().notifyDataSetChanged();

    }
}

