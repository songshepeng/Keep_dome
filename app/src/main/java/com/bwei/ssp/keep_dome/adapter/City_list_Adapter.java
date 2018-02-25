package com.bwei.ssp.keep_dome.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bwei.ssp.keep_dome.R;

import java.util.List;

/**
 * Created by lenovo on 2018/2/24.
 */

public class City_list_Adapter extends RecyclerView.Adapter<City_list_Adapter.Myhoder> {
   List<String>citylist;
   Context context;
    setOnclickListenr listenr;


    public City_list_Adapter(List<String> citylist, Context context) {
        this.citylist = citylist;
        this.context = context;
    }
    private int thisPosition;
    //定义值保存当前的id
    public int getthisPosition() {
        return thisPosition;
    }
    //再定义一个int类型的返回值方法
    public void setThisPosition(int thisPosition) {
        this.thisPosition = thisPosition;
    }
    public void setListenr(setOnclickListenr listenr) {
        this.listenr = listenr;
    }

    @Override
    public Myhoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.city_item, null);
        Myhoder myhoder = new Myhoder(inflate);
        return myhoder;
    }

    @Override
    public void onBindViewHolder(final Myhoder holder, final int position) {
        holder.city_tv.setText(citylist.get(position));
        final int i =1;
        final Myhoder recViewHolderLeft = (Myhoder) holder;
        if (position == getthisPosition()) {
            recViewHolderLeft.city_tv.setTextColor(Color.WHITE);
            Resources resources = context.getResources();
            Drawable drawable = resources.getDrawable(R.drawable.city_tv_end);
            recViewHolderLeft.city_tv.setBackgroundDrawable(drawable);
        }else {
            recViewHolderLeft.city_tv.setTextColor(Color.GRAY);
            Resources resources = context.getResources();
            Drawable drawable = resources.getDrawable(R.drawable.city_tv_back);
            recViewHolderLeft.city_tv.setBackgroundDrawable(drawable);
        }

        holder.city_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenr.clickListen(v,position);
                }
        });
    }
    @Override
    public int getItemCount() {
        return citylist.size();
    }
    public class Myhoder extends RecyclerView.ViewHolder {
        Button city_tv;
        public Myhoder(View itemView) {
            super(itemView);
            city_tv= itemView.findViewById(R.id.city_tv);

        }
    }

    public interface setOnclickListenr{
        void  clickListen(View v,int position);
    }
}
