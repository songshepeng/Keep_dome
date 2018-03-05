package com.bwei.ssp.keep_dome.window;

import android.app.AlertDialog;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.ssp.keep_dome.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class SomeWindowActivity extends AppCompatActivity {

    @InjectView(R.id.only_one)
    Button onlyOne;
    @InjectView(R.id.toplimit)
    Button toplimit;
    @InjectView(R.id.Continue_to_experience)
    Button ContinueToExperience;
    @InjectView(R.id.Multiple_experiences)
    Button MultipleExperiences;
    @InjectView(R.id.give_up_time)
    Button giveUpTime;
    @InjectView(R.id.pay_no)
    Button payNo;
    @InjectView(R.id.pay_yes)
    Button payYes;
    @InjectView(R.id.pay_yes_curriculum)
    Button payYesCurriculum;
    @InjectView(R.id.again_buy)
    Button againBuy;
    @InjectView(R.id.del_ordel)
    Button delOrdel;
    @InjectView(R.id.Booking_pay_yes)
    Button BookingPayYes;
    @InjectView(R.id.cancel_reservation)
    Button cancelReservation;
    @InjectView(R.id.give_up_pay)
    Button giveUpPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_some_window);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.only_one)
    public void onViewClicked() {
        getOnlyone();
    }

    private void getOnlyone() {
        final View only_view = View.inflate(this, R.layout.only_one_layout, null);
        final AlertDialog builder = new AlertDialog.Builder(this)
                .setView(only_view)
                .show();
        final Button give_up = only_view.findViewById(R.id.give_up);
        final Button Continue = only_view.findViewById(R.id.Continue);
        builder.show();
        give_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                give_up.setTextColor(Color.WHITE);
                Resources resources = getResources();
                Drawable drawable = resources.getDrawable(R.drawable.time_tv_bg);
                give_up.setBackgroundDrawable(drawable);
                builder.dismiss();
            }
        });
        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Continue.setTextColor(Color.WHITE);
                Resources resources = getResources();
                Drawable drawable = resources.getDrawable(R.drawable.time_tv_bg);
                Continue.setBackgroundDrawable(drawable);
                Toast.makeText(v.getContext(), "继续订购", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.toplimit)
    public void onViewClicked1() {
        getToplimit();
    }

    private void getToplimit() {
        final View toplimit = View.inflate(this, R.layout.toplimit_layout, null);
        final AlertDialog builder = new AlertDialog.Builder(this)
                .setView(toplimit)
                .show();
        final Button toplimit_sure = toplimit.findViewById(R.id.toplimit_sure);
        toplimit_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toplimit_sure.setTextColor(Color.WHITE);
                Resources resources = getResources();
                Drawable drawable = resources.getDrawable(R.drawable.time_tv_bg);
                toplimit_sure.setBackgroundDrawable(drawable);
                Toast.makeText(v.getContext(), "确定", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.Continue_to_experience)
    public void onViewClicked2() {
        final View only_view = View.inflate(this, R.layout.continue_to_experience, null);
        final AlertDialog builder = new AlertDialog.Builder(this)
                .setView(only_view)
                .show();
        final Button give_up = only_view.findViewById(R.id.give_up);
        final Button Continue = only_view.findViewById(R.id.Continue);
        builder.show();
        give_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                give_up.setTextColor(Color.WHITE);
                Resources resources = getResources();
                Drawable drawable = resources.getDrawable(R.drawable.time_tv_bg);
                give_up.setBackgroundDrawable(drawable);
                builder.dismiss();
            }
        });
        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Continue.setTextColor(Color.WHITE);
                Resources resources = getResources();
                Drawable drawable = resources.getDrawable(R.drawable.time_tv_bg);
                Continue.setBackgroundDrawable(drawable);
                Toast.makeText(v.getContext(), "继续体验", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.Multiple_experiences)
    public void onViewClicked3() {
        final View only_view = View.inflate(this, R.layout.multiple_experiences, null);
        final AlertDialog builder = new AlertDialog.Builder(this)
                .setView(only_view)
                .show();
        final Button give_up = only_view.findViewById(R.id.give_up);
        final Button Continue = only_view.findViewById(R.id.Continue);
        builder.show();
        give_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                give_up.setTextColor(Color.WHITE);
                Resources resources = getResources();
                Drawable drawable = resources.getDrawable(R.drawable.time_tv_bg);
                give_up.setBackgroundDrawable(drawable);
                builder.dismiss();
            }
        });
        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Continue.setTextColor(Color.WHITE);
                Resources resources = getResources();
                Drawable drawable = resources.getDrawable(R.drawable.time_tv_bg);
                Continue.setBackgroundDrawable(drawable);
                Toast.makeText(v.getContext(), "立即开通", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.give_up_time)
    public void onViewClicked4() {
        final View only_view = View.inflate(this, R.layout.give_up_time, null);
        final AlertDialog builder = new AlertDialog.Builder(this)
                .setView(only_view)
                .show();
        final Button give_up = only_view.findViewById(R.id.give_up);
        final Button Continue = only_view.findViewById(R.id.Continue);
        builder.show();
        give_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                give_up.setTextColor(Color.WHITE);
                Resources resources = getResources();
                Drawable drawable = resources.getDrawable(R.drawable.but_bag_red);
                give_up.setBackgroundDrawable(drawable);
                Toast.makeText(v.getContext(), "取消", Toast.LENGTH_SHORT).show();

            }
        });
        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Continue.setTextColor(Color.WHITE);
                Resources resources = getResources();
                Drawable drawable = resources.getDrawable(R.drawable.but_bag_red);
                Continue.setBackgroundDrawable(drawable);
                Toast.makeText(v.getContext(), "确认", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.pay_no)
    public void onViewClicked5() {
        final View only_view = View.inflate(this, R.layout.pay_no, null);
        final AlertDialog builder = new AlertDialog.Builder(this)
                .setView(only_view)
                .show();
        final TextView give_up = only_view.findViewById(R.id.back);
        final Button Continue = only_view.findViewById(R.id.again_pay);
        builder.show();
        give_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "取消", Toast.LENGTH_SHORT).show();
                builder.dismiss();
            }
        });
        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Continue.setTextColor(Color.WHITE);
                Resources resources = getResources();
                Drawable drawable = resources.getDrawable(R.drawable.but_bag_red);
                Continue.setBackgroundDrawable(drawable);
                Toast.makeText(v.getContext(), "重新支付", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.pay_yes)
    public void onViewClicked6() {
        final View only_view = View.inflate(this, R.layout.pay_yes, null);
        final AlertDialog builder = new AlertDialog.Builder(this)
                .setView(only_view)
                .show();
        final TextView give_up = only_view.findViewById(R.id.back);
        final Button Continue = only_view.findViewById(R.id.again_pay);
        builder.show();
        give_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "取消", Toast.LENGTH_SHORT).show();
                builder.dismiss();
            }
        });
        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Continue.setTextColor(Color.WHITE);
                Resources resources = getResources();
                Drawable drawable = resources.getDrawable(R.drawable.time_tv_bg);
                Continue.setBackgroundDrawable(drawable);
                Toast.makeText(v.getContext(), "去选课", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.pay_yes_curriculum)
    public void onViewClicked7() {
        final View only_view = View.inflate(this, R.layout.pay_yes_curriculum, null);
        final AlertDialog builder = new AlertDialog.Builder(this)
                .setView(only_view)
                .show();
        final TextView give_up = only_view.findViewById(R.id.back);
        final Button Continue = only_view.findViewById(R.id.again_pay);
        builder.show();
        give_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "取消", Toast.LENGTH_SHORT).show();
                builder.dismiss();
            }
        });
        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Continue.setTextColor(Color.WHITE);
                Resources resources = getResources();
                Drawable drawable = resources.getDrawable(R.drawable.time_tv_bg);
                Continue.setBackgroundDrawable(drawable);
                Toast.makeText(v.getContext(), "立即预约", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.again_buy)
    public void onViewClicked8() {
        final View toplimit = View.inflate(this, R.layout.again_buy, null);
        final AlertDialog builder = new AlertDialog.Builder(this)
                .setView(toplimit)
                .show();
        final Button toplimit_sure = toplimit.findViewById(R.id.toplimit_sure);
        toplimit_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toplimit_sure.setTextColor(Color.WHITE);
                Resources resources = getResources();
                Drawable drawable = resources.getDrawable(R.drawable.time_tv_bg);
                toplimit_sure.setBackgroundDrawable(drawable);
                Toast.makeText(v.getContext(), "确定", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.del_ordel)
    public void onViewClicked9() {
        final View only_view = View.inflate(this, R.layout.del_ordel, null);
        final AlertDialog builder = new AlertDialog.Builder(this)
                .setView(only_view)
                .show();
        final Button give_up = only_view.findViewById(R.id.give_up);
        final Button Continue = only_view.findViewById(R.id.Continue);
        builder.show();
        give_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                give_up.setTextColor(Color.WHITE);
                Resources resources = getResources();
                Drawable drawable = resources.getDrawable(R.drawable.but_bag_red);
                give_up.setBackgroundDrawable(drawable);
                Toast.makeText(v.getContext(), "取消", Toast.LENGTH_SHORT).show();

            }
        });
        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Continue.setTextColor(Color.WHITE);
                Resources resources = getResources();
                Drawable drawable = resources.getDrawable(R.drawable.but_bag_red);
                Continue.setBackgroundDrawable(drawable);
                Toast.makeText(v.getContext(), "确认", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.Booking_pay_yes)
    public void onViewClicked11() {
        final View only_view = View.inflate(this, R.layout.booking_pay_yes, null);
        final AlertDialog builder = new AlertDialog.Builder(this)
                .setView(only_view)
                .show();
        final TextView give_up = only_view.findViewById(R.id.back);
        final Button Continue = only_view.findViewById(R.id.again_pay);
        builder.show();
        give_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "取消", Toast.LENGTH_SHORT).show();
                builder.dismiss();
            }
        });
        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Continue.setTextColor(Color.WHITE);
                Resources resources = getResources();
                Drawable drawable = resources.getDrawable(R.drawable.time_tv_bg);
                Continue.setBackgroundDrawable(drawable);
                Toast.makeText(v.getContext(), "查看详情", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.cancel_reservation)
    public void onViewClicked12() {
        final View only_view = View.inflate(this, R.layout.cancel_reservation, null);
        final AlertDialog builder = new AlertDialog.Builder(this)
                .setView(only_view)
                .show();
        final Button give_up = only_view.findViewById(R.id.give_up);
        final Button Continue = only_view.findViewById(R.id.Continue);
        builder.show();
        give_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                give_up.setTextColor(Color.WHITE);
                Resources resources = getResources();
                Drawable drawable = resources.getDrawable(R.drawable.but_bag_red);
                give_up.setBackgroundDrawable(drawable);
                Toast.makeText(v.getContext(), "取消", Toast.LENGTH_SHORT).show();

            }
        });
        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Continue.setTextColor(Color.WHITE);
                Resources resources = getResources();
                Drawable drawable = resources.getDrawable(R.drawable.but_bag_red);
                Continue.setBackgroundDrawable(drawable);
                Toast.makeText(v.getContext(), "确认", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.give_up_pay)
    public void onViewClicked13() {
        final View only_view = View.inflate(this, R.layout.give_up_pay, null);
        final AlertDialog builder = new AlertDialog.Builder(this)
                .setView(only_view)
                .show();
        final Button give_up = only_view.findViewById(R.id.give_up);
        final Button Continue = only_view.findViewById(R.id.Continue);
        builder.show();
        give_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                give_up.setTextColor(Color.WHITE);
                Resources resources = getResources();
                Drawable drawable = resources.getDrawable(R.drawable.time_tv_bg);
                give_up.setBackgroundDrawable(drawable);
                builder.dismiss();
            }
        });
        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Continue.setTextColor(Color.WHITE);
                Resources resources = getResources();
                Drawable drawable = resources.getDrawable(R.drawable.time_tv_bg);
                Continue.setBackgroundDrawable(drawable);
                Toast.makeText(v.getContext(), "继续支付", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
