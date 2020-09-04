package cable.social.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cable.social.app.R;

import java.util.ArrayList;

public class AlloptionActivity extends AppCompatActivity {


    final ArrayList<String> itemTitles = new ArrayList<>();
    
    ImageView imageView,imageView2,imageView3,imageView4,imageView5;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutsss);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AlloptionActivity.this, "add influencer", Toast.LENGTH_SHORT).show();
            }
        });


        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AlloptionActivity.this, "Collaborate Company", Toast.LENGTH_SHORT).show();
            }
        });


        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AlloptionActivity.this, "Shape Marketplace", Toast.LENGTH_SHORT).show();
            }
        });


        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AlloptionActivity.this, "Cable", Toast.LENGTH_SHORT).show();
                Intent MoveToNext = new Intent (AlloptionActivity.this, MainActivity.class);
                startActivity(MoveToNext);

            }
        });



        

       /* // simple text item with numbers 0 ~ 9

        for(int i = 1 ; i < 2 ; i ++){
            itemTitles.add(String.valueOf(i));
        }


        // usage sample
        final CircularListView circularListView = (CircularListView) findViewById(com.jh.circularlist.R.id.my_circular_list);
        adapter = new CircularItemAdapter(getLayoutInflater(), itemTitles);
        circularListView.setAdapter(adapter);
        circularListView.setRadius(100);
        circularListView.setOnItemClickListener(new CircularTouchListener.CircularItemClickListener() {
            @Override
            public void onItemClick(View view, int index) {

                View views = getLayoutInflater().inflate(com.jh.circularlist.R.layout.view_circular_item, null);
                TextView itemView = (TextView) views.findViewById(com.jh.circularlist.R.id.bt_item);
                itemView.setText(String.valueOf(adapter.getCount() + 1));
                adapter.addItem(views);



            }
        });*/



    }



    // you should extends CircularAdapter to add your custom item
   /* private class CircularItemAdapter extends CircularAdapter {

        private ArrayList<String> mItems;
        private LayoutInflater mInflater;
        private ArrayList<View> mItemViews;

        public CircularItemAdapter(LayoutInflater inflater, ArrayList<String> items){
            this.mItemViews = new ArrayList<>();
            this.mItems = items;
            this.mInflater = inflater;

            for(final String s : mItems){
                View view = mInflater.inflate(com.jh.circularlist.R.layout.view_circular_item, null);
                TextView itemView = (TextView) view.findViewById(com.jh.circularlist.R.id.bt_item);
                itemView.setText(s);
                mItemViews.add(view);
            }
        }

        @Override
        public ArrayList<View> getAllViews() {
            return mItemViews;
        }

        @Override
        public int getCount() {
            return mItemViews.size();
        }

        @Override
        public View getItemAt(int i) {
            return mItemViews.get(i);
        }

        @Override
        public void removeItemAt(int i) {
            if(mItemViews.size() > 0) {
                mItemViews.remove(i);
                notifyItemChange();
            }
        }

        @Override
        public void addItem(View view) {
            mItemViews.add(view);
            notifyItemChange();
        }
    }*/

}
