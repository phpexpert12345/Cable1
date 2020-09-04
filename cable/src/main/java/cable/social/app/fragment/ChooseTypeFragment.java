package cable.social.app.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;
import java.util.List;

import cable.social.app.Interface.SeriesInterface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.activity.CreateMovieActivity;
import cable.social.app.activity.EpisodInfoActivity;
import cable.social.app.activity.MainActivity;
import cable.social.app.model.SeriesList;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;

public class ChooseTypeFragment extends Fragment implements View.OnClickListener {

    ImageView episod_iv, shortmovie_iv, back;
//    Button next_btn;

    List<SeriesList.Data.Season> serieszList = new ArrayList<>();
    List<String> seasonName = new ArrayList<>();

    ArrayAdapter season_spnr_adapter;
    Spinner SeriesSpinner;
    LinearLayout ll;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_choose_type_activty, container, false);

        episod_iv = rootView.findViewById(R.id.episod_iv);
        shortmovie_iv = rootView.findViewById(R.id.shortmovie_iv);


//        back = rootView.findViewById(R.id.back);
//        tvseries_iv=findViewById(R.id.tvseries_iv);
//        next_btn=findViewById(R.id.next_btn);
        setListners();


        checkpermissions(getActivity());



        return rootView;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_choose_type_activty);
//
//        checkpermissions(this);
//
//        getViewId();
//    }

//    private void getViewId() {
//        episod_iv = findViewById(R.id.episod_iv);
//        shortmovie_iv = findViewById(R.id.shortmovie_iv);
//        back = findViewById(R.id.back);
////        tvseries_iv=findViewById(R.id.tvseries_iv);
////        next_btn=findViewById(R.id.next_btn);
//        setListners();
//    }
    private void setListners() {
//        tvseries_iv.setOnClickListener(this);
        episod_iv.setOnClickListener(this);
        shortmovie_iv.setOnClickListener(this);
//        back.setOnClickListener(this);
//        next_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.tvseries_iv:
//                startActivity(new Intent(ChooseTypeActivty.this,CreateTvSeriesActivity.class));
//                break;
            case R.id.shortmovie_iv:
                startActivity(new Intent(getActivity(), CreateMovieActivity.class));
                break;
            case R.id.episod_iv:
                showCustomDialog();
                break;
//            case R.id.next_btn:
//                break;
//            case R.id.back:
////                finish();
//                break;
        }


    }


    public void checkpermissions(Activity context) {
        if (Build.VERSION.SDK_INT >= 23) {
            new TedPermission(context)
                    .setPermissionListener(permissionListener)
                    //.setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                    .setPermissions(
                            android.Manifest.permission.INTERNET,
                            android.Manifest.permission.CAMERA,
                            android.Manifest.permission.READ_EXTERNAL_STORAGE,
                            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
                    .check();
        }


    }

    PermissionListener permissionListener = new PermissionListener() {
        @Override
        public void onPermissionGranted() {

        }

        @Override
        public void onPermissionDenied(ArrayList<String> deniedPermissions) {

        }

    };


    private void showCustomDialog() {

        final Dialog dialog = new Dialog(getActivity());


        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.show();
        dialog.getWindow().setAttributes(lp);

// Include dialog.xml file
        dialog.setContentView(R.layout.my_dialog);
        dialog.show();


        Button yes =  (Button)dialog.findViewById(R.id.dialog_yes);
        Button no = (Button)dialog.findViewById(R.id.dialog_no);
        SeriesSpinner = (Spinner) dialog.findViewById(R.id.series_spnr);
         ll = (LinearLayout)dialog.findViewById(R.id.series_panchayat_linear);


        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), EpisodInfoActivity.class);
                intent.putExtra("from",0);
                startActivity(intent);

                dialog.dismiss();


            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                getMySeries();

                dialog.dismiss();

                startActivity(new Intent(getActivity(),MyTotalSeries.class));

            }
        });

//
//        SeriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
//
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                if(i==0){
//
//                }else {
////                    GlobalClass.showtost(ChooseTypeActivty.this, serieszList.get(i-1).getSeasonTitle() + serieszList.get(i-1).getSeasonId());
//
//                    Intent intent = new Intent(getActivity(), EpisodInfoActivity.class);
//
//                    intent.putExtra("season_id",String.valueOf(serieszList.get(i-1).getSeasonId()));
//
//                    Log.d("season_id", String.valueOf(serieszList.get(i-1).getSeasonId()));
//
//                    startActivity(intent);
//
//
//                    dialog.dismiss();
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });



    }

//    private void getMySeries() {
//        if (GlobalClass.isNetworkConnected(getActivity())) {
//            WebapiCall sliderlist = new WebapiCall();
//            sliderlist.getSeasons(this, getActivity(), CSPreferences.readString(getActivity(), "tooken"), CSPreferences.readString(getActivity(), "auth_key"));
//        } else {
//
//            Toast.makeText(getActivity(), GlobalClass.nointernet, Toast.LENGTH_LONG).show();
//        }
//    }
//
//
//    @Override
//    public void SeriesList(List<SeriesList.Season> seriesList) {
//
//        if(seriesList.size()>0) {
//            ll.setVisibility(View.VISIBLE);
////            this.serieszList = seriesList;
//            seasonName.clear();
//            seasonName.add("Select Season");
//            serieszList.clear();
//            serieszList.addAll(seriesList);
//
//            for (int i = 0; i < seriesList.size(); i++) {
////                for (int k = 0; k < serieszList.get(i).g(); k++) {
//
//                if(serieszList.get(i).getSeasonTitle()!=null) {
//
//                    seasonName.add(serieszList.get(i).getSeasonTitle());
//                }
////                }
//            }
//
//            season_spnr_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, seasonName);
//            SeriesSpinner.setAdapter(season_spnr_adapter);
//        }else{
//            GlobalClass.showtost(getActivity(),"No Series Found");
//        }
//
//
//    }
}