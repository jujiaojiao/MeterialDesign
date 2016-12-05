package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private RecyclerView recycler;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设置toolbar
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        // 显示标题和子标题
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        toolbar.setTitle("Meterial");
        // 显示导航按钮
        toolbar.setNavigationIcon(R.mipmap.mleft);
        toolbar.setNavigationOnClickListener(this);

        for (int i = 0;i<100;i++){
            list.add(new String("这是第"+i+"个item"));
        }
        recycler = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        recycler.setLayoutManager(layoutManager);
        Adapter adapter = new Adapter(this,list);
        recycler.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_action1:
                Toast.makeText(this, "Action1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toolbar_action2:
                Toast.makeText(this, "Action2", Toast.LENGTH_SHORT).show();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        finish();
//        Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
    }
}
