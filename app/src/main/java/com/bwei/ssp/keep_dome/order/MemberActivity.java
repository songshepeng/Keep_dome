package com.bwei.ssp.keep_dome.order;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.ssp.keep_dome.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MemberActivity extends AppCompatActivity {

    @InjectView(R.id.order_back)
    ImageView orderBack;
    @InjectView(R.id.fenxiang)
    TextView fenxiang;
    @InjectView(R.id.field_name)
    TextView fieldName;
    @InjectView(R.id.order_time)
    TextView orderTime;
    @InjectView(R.id.order_address)
    TextView orderAddress;
    @InjectView(R.id.jian)
    TextView jian;
    @InjectView(R.id.number)
    TextView number;
    @InjectView(R.id.jia)
    TextView jia;
    @InjectView(R.id.noMember_numbr)
    TextView noMemberNumbr;
    @InjectView(R.id.price)
    TextView price;
    @InjectView(R.id.img_sure)
    ImageView imgSure;
    @InjectView(R.id.price_sum)
    TextView priceSum;
    @InjectView(R.id.order_sure_but)
    Button orderSureBut;
    @InjectView(R.id.hide)
    RelativeLayout hide;
    private int number_count;
    private int price_count;
    private int sum_price;
    private  boolean istrue=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        ButterKnife.inject(this);
        String s = number.getText().toString();
        number_count = Integer.parseInt(s);
        String s1 = price.getText().toString();
        price_count = Integer.parseInt(s1);
    }

    @OnClick({R.id.order_back, R.id.fenxiang, R.id.jian, R.id.jia, R.id.img_sure, R.id.order_sure_but})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.order_back:
                finish();
                break;
            case R.id.fenxiang:
                Toast.makeText(this, "分享", Toast.LENGTH_LONG).show();
                break;
            case R.id.jian:
                number_count--;
                if (number_count == 0) {
                    jian.setClickable(false);
                }
                number.setText(number_count + "");
                jian.setTextColor(Color.parseColor("#56B4CC"));
                jia.setTextColor(Color.GRAY);
                sum_price = number_count * price_count;
                priceSum.setText(sum_price + ".00");
                break;
            case R.id.jia:
                number_count++;
                jian.setClickable(true);
                number.setText(number_count + "");
                jia.setTextColor(Color.parseColor("#56B4CC"));
                jian.setTextColor(Color.GRAY);
                sum_price = number_count * price_count;
                priceSum.setText(sum_price + ".00");
                break;
            case R.id.img_sure:
                if (istrue==false){
                    imgSure.setBackgroundResource(R.mipmap.sure);
                    hide.setVisibility(View.VISIBLE);
                    sum_price = number_count * price_count;
                    if (sum_price>0){
                        priceSum.setText((sum_price-50) + ".00");
                    }
                    istrue=true;
                }else if(istrue==true){
                    imgSure.setBackgroundResource(R.mipmap.no_sure);
                    hide.setVisibility(View.GONE);
                    sum_price = number_count * price_count;
                    priceSum.setText(sum_price + ".00");
                    istrue=false;
                }

                break;
            case R.id.order_sure_but:
                break;
        }
    }
}
