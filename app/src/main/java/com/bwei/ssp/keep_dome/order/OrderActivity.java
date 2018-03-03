package com.bwei.ssp.keep_dome.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bwei.ssp.keep_dome.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class OrderActivity extends AppCompatActivity {

    @InjectView(R.id.but_No_Member)
    Button butNoMember;
    @InjectView(R.id.but_Member)
    Button butMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order2);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.but_No_Member, R.id.but_Member})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_No_Member:
                   startActivity(new Intent(OrderActivity.this,NoMemberActivity.class));
                break;
            case R.id.but_Member:
                startActivity(new Intent(OrderActivity.this,MemberActivity.class));

                break;
        }
    }
}
