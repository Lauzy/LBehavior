package com.lauzy.freedom.lbehavior.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lauzy.freedom.lbehavior.R;
import com.lauzy.freedom.lbehavior.adapter.DemoAdapter;
import com.lauzy.freedom.lbehavior.widget.DemoItemDecoration;
import com.lauzy.freedom.lbehaviorlib.behavior.CommonBehavior;


public class Demo2Activity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private FloatingActionButton mFab1;
    private FloatingActionButton mFab2;
    private FloatingActionButton mFab3;
    private FloatingActionButton mFab4;
    private Toolbar mToolbar;
    private LinearLayout mLayoutBottom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2_diy);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_demo1);
        mFab1 = (FloatingActionButton) findViewById(R.id.fab_mode);
        mFab2 = (FloatingActionButton) findViewById(R.id.fab2_mode);
        mFab3 = (FloatingActionButton) findViewById(R.id.fab3_mode);
        mFab4 = (FloatingActionButton) findViewById(R.id.fab4_mode);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_common);
        mLayoutBottom = (LinearLayout) findViewById(R.id.layout_bottom);

        mFab1.setOnClickListener(this);
        mFab2.setOnClickListener(this);
        mFab3.setOnClickListener(this);
        mFab4.setOnClickListener(this);
        loadData();

        diyAnim();
    }

    private void diyAnim() {
        CommonBehavior.from(mFab1).setInterpolator(new AnticipateInterpolator());
        CommonBehavior.from(mFab2).setInterpolator(new BounceInterpolator());
        CommonBehavior.from(mFab3).setDuration(1000);
        CommonBehavior.from(mFab3).setInterpolator(new AnticipateOvershootInterpolator());
        CommonBehavior.from(mFab4).setInterpolator(new BounceInterpolator());
        CommonBehavior.from(mFab4).setDuration(800);

        CommonBehavior.from(mToolbar).setDuration(500).setInterpolator(new BounceInterpolator());
        CommonBehavior.from(mLayoutBottom).setDuration(600).setInterpolator(new LinearInterpolator());
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
