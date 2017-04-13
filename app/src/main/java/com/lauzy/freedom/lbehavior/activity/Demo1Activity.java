package com.lauzy.freedom.lbehavior.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.lauzy.freedom.lbehavior.R;
import com.lauzy.freedom.lbehavior.adapter.DemoAdapter;
import com.lauzy.freedom.lbehavior.widget.DemoItemDecoration;
import com.lauzy.freedom.lbehaviorlib.behavior.CommonBehavior;


public class Demo1Activity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_demo1);
        findViewById(R.id.fab_mode).setOnClickListener(this);
        findViewById(R.id.fab2_mode).setOnClickListener(this);
        findViewById(R.id.fab3_mode).setOnClickListener(this);
        FloatingActionButton fab4 = (FloatingActionButton) findViewById(R.id.fab4_mode);
        fab4.setOnClickListener(this);

        CommonBehavior.from(fab4).setCanScroll(false);//禁止右上角悬浮按钮动画
        loadData();
    }

    private void loadData() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new DemoAdapter(this));
        mRecyclerView.addItemDecoration(new DemoItemDecoration(this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_mode:
                Toast.makeText(this, "Fab1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab2_mode:
                Toast.makeText(this, "Fab2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab3_mode:
                Toast.makeText(this, "Fab3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab4_mode:
                Toast.makeText(this, "Fab4", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
