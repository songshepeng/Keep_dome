package com.bwei.ssp.keep_dome.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwei.ssp.keep_dome.R;
import com.bwei.ssp.keep_dome.bean.Venue_bean;

import java.util.List;

/**
 * Created by lenovo on 2018/2/24.
 */

public class Venue_list_Adapter extends RecyclerView.Adapter<Venue_list_Adapter.Myhoder> {
   List<Venue_bean>citylist;
   Context context;
    setOnclickListenr listenr;


    public Venue_list_Adapter(List<Venue_bean> citylist, Context context) {
        this.citylist = citylist;
        this.context = context;
    }
    private int thisPosition =-1;
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
        View inflate = View.inflate(context, R.layout.venue_item, null);
        Myhoder myhoder = new Myhoder(inflate);
        return myhoder;
    }

    @Override
    public void onBindViewHolder(final Myhoder holder, final int position) {
        holder.shop_name.setText(citylist.get(position).getShop_name());
        holder.shop_address.setText(citylist.get(position).getShop_address());
        final int i =1;
        final Myhoder recViewHolderLeft = (Myhoder) holder;
        holder.bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = holder.shop_name.getText().toString();
                listenr.clickListen(v,position,s);

                }
        });
        if (position == getthisPosition()) {
            Resources resources = context.getResources();
            Drawable drawable = resources.getDrawable(R.drawable.venue_bg);
            recViewHolderLeft.bag.setBackgroundDrawable(drawable);
            recViewHolderLeft.shop_sure.setVisibility(View.VISIBLE);
        }else {
            Resources resources = context.getResources();
            Drawable drawable = resources.getDrawable(R.drawable.none_checked);
            recViewHolderLeft.bag.setBackgroundDrawable(drawable);
            recViewHolderLeft.shop_sure.setVisibility(View.GONE);
        }
    }
    @Override
    public int getItemCount() {
        return citylist.size();
    }
    public class Myhoder extends RecyclerView.ViewHolder {
        TextView shop_name,shop_address;
        ImageView shop_sure;
        RelativeLayout bag;
        public Myhoder(View itemView) {
            super(itemView);
            shop_name= itemView.findViewById(R.id.shop_name);
            shop_address= itemView.findViewById(R.id.shop_address);
            shop_sure= itemView.findViewById(R.id.shop_sure);
            bag= itemView.findViewById(R.id.bag);
        }
    }

    public interface setOnclickListenr{
        void  clickListen(View v, int position,String str);
    }
}
