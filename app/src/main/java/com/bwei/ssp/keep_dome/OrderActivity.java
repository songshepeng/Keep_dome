package com.bwei.ssp.keep_dome;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvDistance;
    private TextView mTvPrice;
    private TextView mTvCity;
    private TextView mTitleName;
    private ImageView mImgSearch;
    private ImageView mImgBack;

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

    }

    private void initView() {
        mImgBack = (ImageView) findViewById(R.id.bt_imgBack);
        mImgSearch = (ImageView) findViewById(R.id.bt_imgSearch);
        mTitleName = (TextView) findViewById(R.id.tv_titleName);
        mTvCity = (TextView) findViewById(R.id.tv_city);
        mTvPrice = (TextView) findViewById(R.id.tv_price);
        mTvDistance = (TextView) findViewById(R.id.tv_distance);
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
