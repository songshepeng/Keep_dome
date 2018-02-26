package com.bwei.ssp.keep_dome.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwei.ssp.keep_dome.R;

import java.util.List;

/**
 * Created by lenovo on 2018/2/24.
 */

public class Search_list_Adapter extends RecyclerView.Adapter<Search_list_Adapter.Myhoder> {
   List<String>citylist;
   Context context;
    setOnclickListenr listenr;


    public Search_list_Adapter(List<String> citylist, Context context) {
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
        View inflate = View.inflate(context, R.layout.search_item, null);
        Myhoder myhoder = new Myhoder(inflate);
        return myhoder;
    }

    @Override
    public void onBindViewHolder(final Myhoder holder, final int position) {
        holder.search_tv.setText(citylist.get(position));
        final Myhoder recViewHolderLeft = (Myhoder) holder;
        holder.search_tv.setOnClickListener(new View.OnClickListener() {
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
        TextView search_tv;
        public Myhoder(View itemView) {
            super(itemView);
            search_tv=  itemView.findViewById(R.id.search_tv);
        }
    }

    public interface setOnclickListenr{
        void  clickListen(View v, int position);
    }
}
