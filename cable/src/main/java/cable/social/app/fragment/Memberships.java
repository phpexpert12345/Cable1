package cable.social.app.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cable.social.app.Interface.Membership_interface;
import cable.social.app.Interface.SubscribePlans_inteface;
import cable.social.app.Interface.WebapiCall;
import cable.social.app.R;
import cable.social.app.activity.Payment;
import cable.social.app.adadpter.MembershipAdapter;
import cable.social.app.model.SubscribePlans_model;
import cable.social.app.utility.BaseActivity;
import cable.social.app.utility.CSPreferences;
import cable.social.app.utility.GlobalClass;

import static android.view.View.VISIBLE;

public class Memberships extends BaseActivity implements SubscribePlans_inteface, Membership_interface {
  
//    private OnFragmentInteractionListener mListener;

 

  
//    ArrayList<SubscribePlans_model.SubscribePlansList> subscribePlansLists = new ArrayList<>();

//    RecyclerView membership_recycle;
//    MembershipAdapter membershipAdapter;
//    TextView preice_tital;
//    Button payment;
//    CardView planshow;


    String price_,tital_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_memberships);
//        membership_recycle=findViewById(R.id.membership_recycle);
//        preice_tital=findViewById(R.id.preice);
//        payment=findViewById(R.id.payment);
//        planshow=findViewById(R.id.planshow);


//        LinearLayoutManager layoutManager = new LinearLayoutManager(Memberships.this, LinearLayoutManager.VERTICAL, false);
//        membership_recycle.setLayoutManager(layoutManager);
//
//        membershipAdapter = new MembershipAdapter(Memberships.this,subscribePlansLists,this);
//        membership_recycle.setAdapter(membershipAdapter);
//
//
//        if (GlobalClass.isNetworkConnected(Memberships.this)) {
//            WebapiCall webapiCall = new WebapiCall();
//            webapiCall.subscribe_list_list(Memberships.this,this, CSPreferences.readString(this,"tooken"));
//
//
//        } else {
//
//            Toast.makeText(this, GlobalClass.nointernet, Toast.LENGTH_LONG).show();
//        }
//
//
//
//        payment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                startActivity(new Intent(Memberships.this, Payment.class).putExtra("price_",price_).putExtra("tital_",tital_));
//            }
//        });

        
    }



    @Override
    public void subscribe_list(ArrayList<SubscribePlans_model.SubscribePlansList> list) {
//        subscribePlansLists.clear();
//        subscribePlansLists.addAll(list);
//        membership_recycle.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void getdata(String price, String tital) {

        Log.d("dfsdfsd",price);
        tital_ = tital;
        price_ = price;
//        preice_tital.setText("$" +price+"/"+tital);
//        planshow.setVisibility(VISIBLE);
    }



    @Override
    public void initData() {

    }

    @Override
    public void initListeners() {
        
    }

    public void Close(View view) {
        finish();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
