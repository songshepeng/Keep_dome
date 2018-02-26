package com.bwei.ssp.keep_dome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.bwei.ssp.keep_dome.adapter.Search_list_Adapter;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private EditText search_content;
    private RecyclerView search_list;
    private ArrayList<String> searchlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        search_list = (RecyclerView) findViewById(R.id.search_list);
        search_content = (EditText) findViewById(R.id.search_content);
        TextView back = (TextView) findViewById(R.id.back);
        search_content.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    //回车键触发搜索
                    switch (event.getAction()) {
                        case KeyEvent.ACTION_UP:

                            //解决消费两次onEditorAction事件
                            String s = search_content.getText().toString();
                            //此处做判断 后台是否有数据 根据结果 跳转不同的界面
                            Log.e("**", s);

                            Intent intent = new Intent(SearchActivity.this, SearchresultActivity.class);
                            intent.putExtra("searchtv", s);
                            startActivity(intent);

//                             Intent intent = new Intent(SearchActivity.this, OrderActivity.class);
//                             startActivity(intent);


                            return true;
                    }
                    return true;
                    //指定onEditorAction被if判断消费
                }
                return false;
            }
        });
        searchlist = new ArrayList<>();
        searchlist.add("DIDI高尔夫俱乐部佳佳店");
        searchlist.add("DIDI高尔夫俱乐部佳佳店");
        searchlist.add("DIDI高尔夫俱乐部佳佳店");
        searchlist.add("DIDI高尔夫俱乐部佳佳店");
        searchlist.add("DIDI高尔夫俱乐部佳佳店");
        search_list.setLayoutManager(new LinearLayoutManager(this));
        search_list.addItemDecoration(new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        Search_list_Adapter search_list_adapter = new Search_list_Adapter(searchlist, this);
        search_list.setAdapter(search_list_adapter);

        search_list_adapter.setListenr(new Search_list_Adapter.setOnclickListenr() {
            @Override
            public void clickListen(View v, int position) {
                //推荐列表做的点击事件
                Intent intent = new Intent(SearchActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
