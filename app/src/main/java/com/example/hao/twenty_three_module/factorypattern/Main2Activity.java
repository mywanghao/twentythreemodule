package com.example.hao.twenty_three_module.factorypattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.example.hao.twenty_three_module.R;


/**
 * 一个完整的弹弹球工厂
 */
public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        ViewGroup group = (ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content);

        ViewGroup group = (ViewGroup) findViewById(R.id.main_id);
        BounctBallProxy.createoBounctBall(group,BounctBallProxy.BLUE_BOUNCTBALL,10);


    //    Log.e("TAA","Main2Activity--------");

    }
}
