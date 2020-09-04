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
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cable.social.app.Interface.FriendList;
import cable.social.app.Interface.User_list;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.adadpter.Category_allAdapter;
import cable.social.app.adadpter.FriendListAdapter;
import cable.social.app.adadpter.SearchUserAdapter;
import cable.social.app.model.FriendListModel;
import cable.social.app.model.UserList;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;
import de.hdodenhof.circleimageview.CircleImageView;

public class FriendListFragment extends Fragment implements FriendList {

    private RecyclerView categoryrecycleview;
    private FriendListAdapter friendListAdapter;
    Category_allAdapter category_allAdapter;
    private EditText searchField;
    private TextView search_txt,no_result;
    private String search_key;

    private ArrayList<FriendListModel.Data.FriendList> friendLists = new ArrayList<>();


    public FriendListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.search_user, container, false);
        categoryrecycleview = rootView.findViewById(R.id.recycleviewcategory);
        searchField =  rootView.findViewById(R.id.search_field);
        search_txt = rootView.findViewById(R.id.search_txt);
        no_result = rootView.findViewById(R.id.no_result);


        //LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        categoryrecycleview.setLayoutManager(new LinearLayoutManager(getActivity()));
//        categoryrecycleview.setLayoutManager(layoutManager);

        friendListAdapter = new FriendListAdapter(getActivity(),  friendLists,this);
        categoryrecycleview.setAdapter(friendListAdapter);


        if (GlobalClass.isNetworkConnected(getActivity())) {
            WebapiCall categorylist = new WebapiCall();
            categorylist.MyFriendList(getActivity(),  CSPreferences.readString(getActivity(), "tooken"),CSPreferences.readString(getActivity(), "auth_key"),this);
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
//                Toast.makeText(getActivity(),"Search Result of " +search_key,Toast.LENGTH_SHORT).show();
            }
        });




        return rootView;

    }


    private void filter(String text){
        ArrayList<FriendListModel.Data.FriendList> temp = new ArrayList();
        for(FriendListModel.Data.FriendList d: friendLists){
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if(d.getCustomerName().toLowerCase().contains(text.toLowerCase())){
                temp.add(d);
            }
        }
        //update recyclerview
        friendListAdapter.updateList(temp);

    }



    @Override
    public void FriendList(List<FriendListModel.Data.FriendList> friendList) {

        if(friendList.size()==0){
            no_result.setVisibility(View.VISIBLE);
        }else{
            no_result.setVisibility(View.GONE);

        }


        friendLists.clear();
        friendLists.addAll(friendList);
        categoryrecycleview.getAdapter().notifyDataSetChanged();

    }



}