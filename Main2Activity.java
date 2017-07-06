package com.wordpress.keepup395.pro_chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {
    int[] images={ R.drawable.camera,R.drawable.contact,R.drawable.disk,R.drawable.email,
            R.drawable.gallery,R.drawable.menu,R.drawable.msg,R.drawable.settings};
    String [] NAMES= {"Pulser 200","Bajaj ct1000","Suzuki gs","Honda Activa","Bajaj cxdx"};
    String [] VehicleNo={"OD-02X-3212","OD-07X-6512","OD-02Y-3612","OD-02W-0212","OD-02X-3265","OD-02R-3092","OD-02X-3912","OD-02P-3912",};
String [] price={"R.s-100","R.s-170","R.s-110","R.s-130","R.s-200","R.s-120","R.s-150"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView listView=(ListView)findViewById(R.id.list_view);
        customadapter customAdapter = new customadapter();
        listView.setAdapter(customAdapter);


    }
    class customadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customitem,null);
            ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
            TextView textView_name=(TextView)view.findViewById(R.id.textView_name);
            TextView textView_number=(TextView)view.findViewById(R.id.textView_number);
            TextView textView_price=(TextView)view.findViewById(R.id.textView_price);

            imageView.setImageResource(images[i]);
            textView_name.setText(NAMES[i]);
            textView_number.setText(VehicleNo[i]);
            textView_price.setText(price[i]);

            return view;
        }


    }
}
