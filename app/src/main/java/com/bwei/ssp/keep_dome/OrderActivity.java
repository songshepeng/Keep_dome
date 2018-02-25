package com.bwei.ssp.keep_dome;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.bwei.ssp.keep_dome.adapter.MyLvAdapter;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvDistance;
    private TextView mTvPrice;
    private TextView mTvCity;
    private TextView mTitleName;
    private ImageView mImgSearch;
    private ImageView mImgBack;
    private RecyclerView mLv;
    private RecyclerViewHeader mLvHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initView();
        initData();
        setListener();
    }

    private void setListener() {
        mImgBack.setOnClickListener(this);
        mImgSearch.setOnClickListener(this);
        mTvCity.setOnClickListener(this);
        mTvPrice.setOnClickListener(this);
        mTvDistance.setOnClickListener(this);
    }

    private void initData() {

        setData();
        mLvHeader.attachTo(mLv);
    }

    private void setData() {
        List<Data> list = new ArrayList<>();

        Data data = new Data(R.drawable.a1, "950/人", "￥899.00 超级会员卡专享", "北京CBD国际高尔夫俱乐部"
                , "5km", "北京市朝阳区高碑店路99号");
        Data data1 = new Data(R.drawable.a2, "950/人", "￥899.00 超级会员卡专享", "北京CBD国际高尔夫俱乐部"
                , "5km", "北京市朝阳区高碑店路99号");
        list.add(data);
        list.add(data1);
        MyLvAdapter adapter = new MyLvAdapter(this, list);
        mLv.setLayoutManager(new LinearLayoutManager(this));
        mLv.setAdapter(adapter);
    }

    private void initView() {
        mImgBack = (ImageView) findViewById(R.id.bt_imgBack);
        mImgSearch = (ImageView) findViewById(R.id.bt_imgSearch);
        mTitleName = (TextView) findViewById(R.id.tv_titleName);
        mTvCity = (TextView) findViewById(R.id.tv_city);
        mTvPrice = (TextView) findViewById(R.id.tv_price);
        mTvDistance = (TextView) findViewById(R.id.tv_distance);
        mLv = (RecyclerView) findViewById(R.id.lv);
        mLvHeader = (RecyclerViewHeader) findViewById(R.id.lv_header);

    }


    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        Drawable checkedDrawable = getResources().getDrawable(R.drawable.checked_shape);
        Drawable normalDrawable = getResources().getDrawable(R.drawable.normal_shape);
        switch (v.getId()) {
            case R.id.bt_imgBack:
                finish();
                break;
            case R.id.bt_imgSearch:
                Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_city:
                mTvCity.setBackgroundDrawable(checkedDrawable);
                mTvPrice.setBackgroundDrawable(normalDrawable);
                mTvDistance.setBackgroundDrawable(normalDrawable);
                mTvCity.setTextColor(Color.WHITE);
                mTvPrice.setTextColor(Color.GRAY);
                mTvDistance.setTextColor(Color.GRAY);
                break;
            case R.id.tv_price:
                mTvCity.setBackgroundDrawable(normalDrawable);
                mTvPrice.setBackgroundDrawable(checkedDrawable);
                mTvDistance.setBackgroundDrawable(normalDrawable);
                mTvCity.setTextColor(Color.GRAY);
                mTvPrice.setTextColor(Color.WHITE);
                mTvDistance.setTextColor(Color.GRAY);
                break;
            case R.id.tv_distance:
                mTvCity.setTextColor(Color.GRAY);
                mTvPrice.setTextColor(Color.GRAY);
                mTvDistance.setTextColor(Color.WHITE);
                mTvCity.setBackgroundDrawable(normalDrawable);
                mTvPrice.setBackgroundDrawable(normalDrawable);
                mTvDistance.setBackgroundDrawable(checkedDrawable);

                break;
        }
    }
}
