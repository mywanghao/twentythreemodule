package com.example.hao.twenty_three_module.factorypattern;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

import com.example.hao.twenty_three_module.R;
import com.example.hao.twenty_three_module.view.BouncyBallView;

/**
 * Created by hao on 2016/3/12.
 * 产品类
 */
public interface BouncyBall {

    public void createBouncyBall(ViewGroup view);


}


/**
 * 黑色的球
 */
class BlackBouncyBall implements  BouncyBall{


    @Override
    public void createBouncyBall(ViewGroup view) {

        View inflat =  View.inflate(view.getContext(),R.layout.layout_bouncyball,null);
        ((BouncyBallView)inflat.findViewById(R.id.bouncyball)).setBouncyBallColor(Color.BLACK);
        view.addView(inflat);

    }
}


/**
 * 蓝色的球
 */
class BlueBouncyBall implements  BouncyBall{


    @Override
    public void createBouncyBall(ViewGroup view) {

       View inflat =  View.inflate(view.getContext(),R.layout.layout_bouncyball,null);
        ((BouncyBallView)inflat.findViewById(R.id.bouncyball)).setBouncyBallColor(Color.BLUE);
      view.addView(inflat);

    }
}




