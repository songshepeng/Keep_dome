package com.bwei.ssp.keep_dome;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.ssp.keep_dome.adapter.Time_list_Adapter;
import com.bwei.ssp.keep_dome.adapter.Timepm_list_Adapter;
import com.bwei.ssp.keep_dome.adapter.Venue_list_Adapter;
import com.bwei.ssp.keep_dome.bean.PmBean;
import com.bwei.ssp.keep_dome.bean.StateBean;
import com.bwei.ssp.keep_dome.bean.Venue_bean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class BespeakActivity extends AppCompatActivity {

    @InjectView(R.id.back)
    ImageView back;
    @InjectView(R.id.kefu)
    ImageView kefu;
    @InjectView(R.id.venue)
    TextView venue;
    @InjectView(R.id.time)
    TextView time;
    @InjectView(R.id.sure)
    Button sure;
    @InjectView(R.id.show_time)
    LinearLayout showTime;
    private View venue_view;
    private PopupWindow window;
    private View time_view;
    private PopupWindow timewindow;
    private boolean isam;
    private Timepm_list_Adapter time_list_adapter1;
    private boolean ispm;
    private Time_list_Adapter time_list_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bespeak);
        ButterKnife.inject(this);
        EventBus.getDefault().register(this);
        // 3.0Android Studio 用ButterKnife  在defaultConfig 添加 javaCompileOptions { annotationProcessorOptions { includeCompileClasspath = true } }
        time.setClickable(false);
        sure.setClickable(false);
    }

    @OnClick({R.id.back, R.id.kefu, R.id.venue, R.id.time, R.id.sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                Toast.makeText(this, "返回", Toast.LENGTH_LONG).show();
                break;
            case R.id.kefu:
                Toast.makeText(this, "客服", Toast.LENGTH_LONG).show();
                break;
            case R.id.venue:
                getVenue();
                break;
            case R.id.time:
                getTimelist();
                break;
            case R.id.sure:
                Toast.makeText(this, "确定", Toast.LENGTH_LONG).show();
                break;
        }
    }


    private void getVenue() {
        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        venue_view = View.inflate(this, R.layout.venue, null);
        getVenue_data();
        window = new PopupWindow(venue_view, width, height/2, true);
        window.setFocusable(true);
        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F8F8F8")));
        // TODO: 2016/5/17 设置可以触摸弹出框以外的区域
        window.setOutsideTouchable(true);
        // TODO：更新popupwindow的状态
        window.update();
        // TODO: 2016/5/17 以下拉的方式显示，并且可以设置显示的位置
        window.showAsDropDown(showTime, 0, 20);
    }

    private void getVenue_data() {
        TextView back = venue_view.findViewById(R.id.back);
        RecyclerView venue_list = venue_view.findViewById(R.id.venue_list);
        Venue_bean venue_bean = new Venue_bean("DIDI高尔夫佳佳俱乐部", "北京市朝阳区光英路150号");
        Venue_bean venue_bean1 = new Venue_bean("DIDI高尔夫海鹏俱乐部", "北京市朝阳区光英路150号");
        List<Venue_bean> list =new ArrayList<>();
        list.add(venue_bean);
        list.add(venue_bean1);
        venue_list.setLayoutManager(new LinearLayoutManager(this));
        final Venue_list_Adapter venue_list_adapter = new Venue_list_Adapter(list, this);
        venue_list.setAdapter(venue_list_adapter);
        venue_list_adapter.setListenr(new Venue_list_Adapter.setOnclickListenr() {
            @Override
            public void clickListen(View v, int position, String str) {
                venue_list_adapter.setThisPosition(position);
                //绑定当前点击的id
                venue_list_adapter.notifyDataSetChanged();
                //嫑忘记刷新适配器
                venue.setText(str);
                time.setClickable(true);
               // window.dismiss();
            }


        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
            }
        });
        venue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e("**", "1: " );
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("**", "2: " );
            }
            @Override
            public void afterTextChanged(Editable s) {
                Log.e("**", "3: " );
                time.setTextColor(Color.parseColor("#228822"));
            }
        });
    }

    private void getTimelist() {
        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        time_view = View.inflate(this, R.layout.time, null);
        getTime_data();
        timewindow = new PopupWindow(time_view, width, height/2, true);
        timewindow.setFocusable(true);
        timewindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F8F8F8")));
        // TODO: 2016/5/17 设置可以触摸弹出框以外的区域
        timewindow.setOutsideTouchable(true);
        // TODO：更新popupwindow的状态
        timewindow.update();
        // TODO: 2016/5/17 以下拉的方式显示，并且可以设置显示的位置
        timewindow.showAsDropDown(showTime, 0, 20);
    }
    private void getTime_data() {
        TextView back = time_view.findViewById(R.id.back);
        RecyclerView am_list = time_view.findViewById(R.id.am_list);
        RecyclerView pm_list = time_view.findViewById(R.id.pm_list);
        am_list.setLayoutManager(new GridLayoutManager(this,4));
        pm_list.setLayoutManager(new GridLayoutManager(this,4));
        List<String>amlist =new ArrayList<>();
        amlist.add("10:00");
        amlist.add("11:00");
        amlist.add("12:00");
        List<String>pmlist =new ArrayList<>();
        pmlist.add("13:00");
        pmlist.add("14:00");
        pmlist.add("15:00");
        pmlist.add("16:00");
        pmlist.add("17:00");
        pmlist.add("18:00");
        pmlist.add("19:00");
        pmlist.add("20:00");
        time_list_adapter = new Time_list_Adapter(amlist, this);
        am_list.setAdapter(time_list_adapter);
        time_list_adapter1 = new Timepm_list_Adapter(pmlist, this);
        pm_list.setAdapter(time_list_adapter1);

        time_list_adapter.setListenr(new Time_list_Adapter.setOnclickListenr() {
            @Override
            public void clickListen(View v, int position, String str) {
                time_list_adapter.setThisPosition(position);
                //绑定当前点击的id
                time_list_adapter.notifyDataSetChanged();
                //嫑忘记刷新适配器
                time.setText(str);
                time_list_adapter1.setB(isam);
               // timewindow.dismiss();
                time_list_adapter1.setListenr(new Timepm_list_Adapter.setOnclickListenr() {
                    @Override
                    public void clickListen(View v, int position, String str) {
                        time_list_adapter1.setThisPosition(position);
                        //绑定当前点击的id
                        time_list_adapter1.notifyDataSetChanged();
                        //嫑忘记刷新适配器
                      //  time.setText(str);
                        // timewindow.dismiss();
                        time_list_adapter.setB(ispm);

                    }
                });
            }
        });

        time_list_adapter1.setListenr(new Timepm_list_Adapter.setOnclickListenr() {
            @Override
            public void clickListen(View v, int position, String str) {
                time_list_adapter1.setThisPosition(position);
                //绑定当前点击的id
                time_list_adapter1.notifyDataSetChanged();
                //嫑忘记刷新适配器
                 time.setText(str);
               // timewindow.dismiss();
                time_list_adapter.setB(ispm);
                time_list_adapter.setListenr(new Time_list_Adapter.setOnclickListenr() {
                    @Override
                    public void clickListen(View v, int position, String string) {
                        time_list_adapter.setThisPosition(position);
                        //绑定当前点击的id
                        time_list_adapter.notifyDataSetChanged();
                        //嫑忘记刷新适配器
                       // time.setText(str);
                        time_list_adapter1.setB(isam);
                    }
                });
            }
        });
        time.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e("**", "1: " );
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("**", "2: " );
            }
            @Override
            public void afterTextChanged(Editable s) {
                Log.e("**", "3: " );
                sure.setClickable(true);
                Resources resources = BespeakActivity.this.getResources();
                Drawable drawable = resources.getDrawable(R.drawable.time_tv_bg);
                sure.setBackgroundDrawable(drawable);
               // Toast.makeText(BespeakActivity.this,"请点击确认",Toast.LENGTH_LONG).show();
            }
        });
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true) //在ui线程执行
    public void onDataSynEvent(StateBean event) {
        isam = event.isIstrus();
        Log.e("***", "event---->" + event.isIstrus()+"");
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true) //在ui线程执行
    public void onPmDataSynEvent(PmBean event) {
       ispm =  event.isIspm();
        Log.e("***", "pmevent---->" + event.isIspm()+"");
    }
}
