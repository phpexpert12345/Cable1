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
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cable.social.app.Interface.Category_interface;
import cable.social.app.Interface.User_list;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.adadpter.Category_adapter;
import cable.social.app.adadpter.Category_allAdapter;
import cable.social.app.adadpter.SearchUserAdapter;
import cable.social.app.model.Category_model;
import cable.social.app.model.UserList;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;
import de.hdodenhof.circleimageview.CircleImageView;

public class SearchUserFragment extends Fragment implements User_list{

    private RecyclerView categoryrecycleview;
    private SearchUserAdapter searchUserAdapter;
    Category_allAdapter category_allAdapter;
    private EditText searchField;
    private TextView search_txt,no_result;
    private String search_key;
    CircleImageView MyFriend;

    private ArrayList<UserList.Datum> userLists = new ArrayList<>();


    public SearchUserFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.search_user, container, false);
        categoryrecycleview = rootView.findViewById(R.id.recycleviewcategory);
        searchField =  rootView.findViewById(R.id.search_field);
        search_txt = rootView.findViewById(R.id.search_txt);
        no_result = rootView.findViewById(R.id.no_result);
        MyFriend = rootView.findViewById(R.id.my_friend);


        MyFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragsearch = new FriendListFragment();
                FragmentManager fragmentManagersearch = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
                fragmentManagersearch.beginTransaction().replace(R.id.content_frame, fragsearch).addToBackStack(null).commit();
            }
        });

        Glide.with(this)
                .load(R.drawable.float_icon)
                .fitCenter()
                .placeholder(R.drawable.float_icon)
                .into(MyFriend);




        //LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        categoryrecycleview.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        //categoryrecycleview.setLayoutManager(layoutManager);

        searchUserAdapter = new SearchUserAdapter(getActivity(), userLists,this);
        categoryrecycleview.setAdapter(searchUserAdapter);


        if (GlobalClass.isNetworkConnected(getActivity())) {
            WebapiCall categorylist = new WebapiCall();
            categorylist.ActiveUserList(getActivity(), this, CSPreferences.readString(getActivity(), "tooken"),CSPreferences.readString(getActivity(), "auth_key"));
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
        ArrayList<UserList.Datum> temp = new ArrayList();
        for(UserList.Datum d: userLists){
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if(d.getCustomerUsername().toLowerCase().contains(text.toLowerCase())){
                temp.add(d);
            }
        }
        //update recyclerview
        searchUserAdapter.updateList(temp);




    }

    @Override
    public void UserList(List<UserList.Datum> user_list) {
                if(user_list.size()==0){
            no_result.setVisibility(View.VISIBLE);
        }else{
            no_result.setVisibility(View.GONE);

        }


        userLists.clear();
        userLists.addAll(user_list);
        categoryrecycleview.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void RequestSent(int position) {

        userLists.get(position).setRequestStatus("sent");
        searchUserAdapter.notifyItemChanged(position);


    }


//    @Override
//    public void category_list(ArrayList<Category_model.CategoyList> list) {
//
//        if(list.size()==0){
//            no_result.setVisibility(View.VISIBLE);
//        }else{
//            no_result.setVisibility(View.GONE);
//
//        }


//        categoyLists.clear();
//        categoyLists.addAll(list);
//        categoryrecycleview.getAdapter().notifyDataSetChanged();
//
//    }
}