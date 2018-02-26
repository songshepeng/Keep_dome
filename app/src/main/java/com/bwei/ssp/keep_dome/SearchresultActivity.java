package com.bwei.ssp.keep_dome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchresultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresult);
        Intent intent = getIntent();
        String searchtv = intent.getStringExtra("searchtv");
        CardView cardview = (CardView) findViewById(R.id.cardview);
        ImageView back = (ImageView) findViewById(R.id.back);
        TextView tv = (TextView) findViewById(R.id.tv);
        TextView updata_tv = (TextView) findViewById(R.id.updata_tv);
        cardview.setRadius(8);//设置图片圆角的半径大小
        tv.setText(searchtv);
        updata_tv.setText("“"+searchtv+"”");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
