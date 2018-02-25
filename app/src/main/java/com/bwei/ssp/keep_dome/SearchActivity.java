package com.bwei.ssp.keep_dome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {

    private EditText search_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        search_content = (EditText) findViewById(R.id.search_content);
        search_content.setFocusable(true);
        search_content.setFocusableInTouchMode(true);
        search_content.requestFocus();
    }


}
