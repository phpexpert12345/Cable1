package cable.social.app.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cable.social.app.Interface.CategorySubcat_interface;
import cable.social.app.Interface.Category_interface;
import cable.social.app.Interface.VideoListInterface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.adadpter.CatTabAdapter;
import cable.social.app.adadpter.SearchVideoAdapter;
import cable.social.app.model.CategorySubList;
import cable.social.app.model.Category_model;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;

public class SearchVideoFragment extends Fragment implements Category_interface, CategorySubcat_interface , VideoListInterface {
    RecyclerView video_recycler,category_recycler;
    SearchVideoAdapter searchVideoAdapter;
    CatTabAdapter catTabAdapter;
    private List<Map<String,String>>videoList=new LinkedList<>();
    private List<Map<String,String>>catList=new LinkedList<>();

    ArrayList<Category_model.CategoyList> categoyLists = new ArrayList<>();
    private ArrayList<CategorySubList.Datum> subCategorylist = new ArrayList<>();

    private int cat_id=-1,position;
    View view ;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

         view =inflater.inflate(R.layout.frag_video_search,container,false);
        if (view != null){
            InputMethodManager imm = (InputMethodManager)
                    getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()!=null) {
            cat_id = getArguments().getInt("cat_id");
            position = getArguments().getInt("position");
            categoyLists= getArguments().getParcelableArrayList("cat_list");

        }
        if (view != null){
            InputMethodManager imm = (InputMethodManager)
                    getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        getViewId(view);
    }
    private void getViewId(View view){
        category_recycler=view.findViewById(R.id.category_recycler);
        video_recycler=view.findViewById(R.id.video_recycler);
        video_recycler.setHasFixedSize(true);
        video_recycler.setLayoutManager(new GridLayoutManager(getActivity(),2));
        category_recycler.setHasFixedSize(true);
        category_recycler.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));


        catTabAdapter=new CatTabAdapter(getActivity(),categoyLists,this,position);
        category_recycler.setAdapter(catTabAdapter);

        searchVideoAdapter=new SearchVideoAdapter(getActivity(),subCategorylist);
        video_recycler.setAdapter(searchVideoAdapter);

        if(cat_id<0){
            cat_id=2;

            if (GlobalClass.isNetworkConnected(getActivity())) {
                WebapiCall categorylist = new WebapiCall();
                categorylist.category_list(getActivity(), this, CSPreferences.readString(getActivity(), "tooken"));
            } else {
                Toast.makeText(getActivity(), GlobalClass.nointernet, Toast.LENGTH_LONG).show();
            }
        }else {
            ServerCall(cat_id);
        }





    }

    @Override
    public void category_list(ArrayList<Category_model.CategoyList> list) {
        ServerCall(cat_id);

        categoyLists.clear();
        categoyLists.addAll(list);
        category_recycler.getAdapter().notifyDataSetChanged();

    }

    @Override
    public void categorysub_list(ArrayList<CategorySubList.Datum> list) {

        if(list.size()==0){
            video_recycler.setVisibility(View.GONE);
            return;
        }
        video_recycler.setVisibility(View.VISIBLE);

        subCategorylist.clear();
        subCategorylist.addAll(list);
        video_recycler.getAdapter().notifyDataSetChanged();

    }

    @Override
    public void VideoListInterface(int i) {
ServerCall(i);
    }


    public void ServerCall(int i){
        if (GlobalClass.isNetworkConnected(getActivity())) {
            WebapiCall webapiCall = new WebapiCall();
            webapiCall.channelSubCategory(getActivity(), CSPreferences.readString(getActivity(), "tooken"), this, String.valueOf(i));
        } else {

            Toast.makeText(getActivity(), GlobalClass.nointernet, Toast.LENGTH_LONG).show();
        }
    }


}
