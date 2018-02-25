package com.bwei.ssp.keep_dome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bwei.ssp.keep_dome.adapter.City_list_Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView city_list;
    private List<String> citylist;
    private TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initdata();
        setdata();
    }
    private void setdata() {
        final City_list_Adapter city_list_adapter = new City_list_Adapter(citylist, this);
        city_list.setAdapter(city_list_adapter);
        city_list_adapter.setListenr(new City_list_Adapter.setOnclickListenr() {
            @Override
            public void clickListen(View v, int position) {
                startActivity(new Intent(MainActivity.this,SearchActivity.class));
                city_list_adapter.setThisPosition(position);
                //绑定当前点击的id
                city_list_adapter.notifyDataSetChanged();
                //嫑忘记刷新适配器
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击x做的逻辑操作
            }
        });
    }
    private void initdata() {
        back = (TextView) findViewById(R.id.back);
        city_list = (RecyclerView) findViewById(R.id.city_list);
        city_list.setLayoutManager(new GridLayoutManager(this,4));
        citylist = new ArrayList<>();
        citylist.add("北京");
        citylist.add("深圳");
        citylist.add("上海");
        citylist.add("广州");
        citylist.add("成都");
        citylist.add("杭州");
        citylist.add("南京");
    }


}
