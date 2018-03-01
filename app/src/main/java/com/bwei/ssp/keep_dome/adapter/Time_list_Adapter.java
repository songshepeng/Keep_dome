package com.bwei.ssp.keep_dome.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwei.ssp.keep_dome.R;
import com.bwei.ssp.keep_dome.bean.StateBean;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by lenovo on 2018/2/24.
 */

public class Time_list_Adapter extends RecyclerView.Adapter<Time_list_Adapter.Myhoder> {
   List<String>citylist;
   Context context;
    setOnclickListenr listenr;

    public Time_list_Adapter(List<String> citylist, Context context) {
        this.citylist = citylist;
        this.context = context;
    }
    private int thisPosition=-1;
    //定义值保存当前的id
    public int getthisPosition() {
        return thisPosition;
    }
    //再定义一个int类型的返回值方法
    public void setThisPosition(int thisPosition) {
        this.thisPosition = thisPosition;
    }
    private boolean b=true;

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public void setListenr(setOnclickListenr listenr) {
        this.listenr = listenr;
    }

    @Override
    public Myhoder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(context).inflate(R.layout.time_item, parent, false);
        Myhoder myhoder = new Myhoder(inflate);
        return myhoder;
    }

    @Override
    public void onBindViewHolder(final Myhoder holder, final int position) {

        holder.city_tv.setText(citylist.get(position));
        final int i =1;
        final Myhoder recViewHolderLeft = (Myhoder) holder;
        holder.city_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = holder.city_tv.getText().toString();
                listenr.clickListen(v,position,s);
                StateBean stateBean = new StateBean(false);
                EventBus.getDefault().postSticky(stateBean);
                }
        });
        boolean b = isB();

            if (position == getthisPosition()) {
                recViewHolderLeft.city_tv.setTextColor(Color.WHITE);
                Resources resources = context.getResources();
                Drawable drawable = resources.getDrawable(R.drawable.time_tv_bg);
                recViewHolderLeft.city_tv.setBackgroundDrawable(drawable);
            }else {
                recViewHolderLeft.city_tv.setTextColor(Color.GRAY);
                Resources resources = context.getResources();
                Drawable drawable = resources.getDrawable(R.drawable.none_checked);
                recViewHolderLeft.city_tv.setBackgroundDrawable(drawable);
            }

    }

    @Override
    public int getItemCount() {
        return citylist.size();
    }
    public class Myhoder extends RecyclerView.ViewHolder {
        TextView city_tv;
        public Myhoder(View itemView) {
            super(itemView);
            city_tv= itemView.findViewById(R.id.time_tv);
        }
    }
    public interface setOnclickListenr{
        void  clickListen(View v, int position,String string);
    }
}
