package com.lauzy.freedom.lbehavior.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lauzy.freedom.lbehavior.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_activity).setOnClickListener(this);
        findViewById(R.id.btn_diy).setOnClickListener(this);
        findViewById(R.id.btn_fragment).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_activity:
                startActivity(new Intent(MainActivity.this, Demo1Activity.class));
                break;
            case R.id.btn_diy:
                startActivity(new Intent(MainActivity.this, Demo2Activity.class));
                break;
            case R.id.btn_fragment:
                startActivity(new Intent(MainActivity.this, Demo3ActivityWithFragment.class));
                break;
        }
    }
}
