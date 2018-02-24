package com.bwei.ssp.keep_dome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwei.ssp.keep_dome.adapter.City_list_Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView city_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       city_list = (RecyclerView) findViewById(R.id.city_list);
        city_list.setLayoutManager(new GridLayoutManager(this,4));
        List<String>citylist =new ArrayList<>();
        citylist.add("北京");
        citylist.add("深圳");
        citylist.add("上海");
        citylist.add("广州");
        citylist.add("成都");
        citylist.add("杭州");
        citylist.add("南京");
        City_list_Adapter city_list_adapter = new City_list_Adapter(citylist, this);
        city_list.setAdapter(city_list_adapter);
//        city_list_adapter.setListenr(new City_list_Adapter.setOnclickListenr() {
//            @Override
//            public void clickListen(View v, int position) {
//                v.setBackgroundResource(R.drawable.city_tv_back_end);
//            }
//        });
    }
}
