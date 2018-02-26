package com.bwei.ssp.keep_dome.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bwei.ssp.keep_dome.Data;
import com.bwei.ssp.keep_dome.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 子非鱼 on 2018/2/25.
 */

public class MyLvAdapter extends RecyclerView.Adapter<MyLvAdapter.MyHolder> {

    private Context context;
    private List<Data> list;
    private List<String> datas = new ArrayList<>();

    public MyLvAdapter(Context context, List<Data> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lv_item, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Glide.with(context)
                .load(list.get(position).getImgUrl())
                .centerCrop()
                .into(holder.mPicture);
        holder.mPrice.setText(list.get(position).getPrice());
        holder.mVip.setText(list.get(position).getVip());
        holder.mClubName.setText(list.get(position).getClubName());
        holder.mDistance.setText(list.get(position).getDistance());
        holder.mPosition.setText(list.get(position).getPosition());
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private final ImageView mPicture;
        private final TextView mPrice;
        private final TextView mVip;
        private final TextView mClubName;
        private final TextView mDistance;
        private final TextView mPosition;

        public MyHolder(View itemView) {
            super(itemView);
            mPicture = itemView.findViewById(R.id.Image_introductionPicture);
            mPrice = itemView.findViewById(R.id.tv_price);
            mVip = itemView.findViewById(R.id.tv_vip);
            mClubName = itemView.findViewById(R.id.tv_clubName);
            mDistance = itemView.findViewById(R.id.tv_distance);
            mPosition = itemView.findViewById(R.id.tv_geographicalPosition);

        }
    }

}
