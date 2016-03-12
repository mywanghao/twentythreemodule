package com.example.hao.twenty_three_module.factorypattern;

import android.util.Log;
import android.view.ViewGroup;

/**
 * Created by hao on 2016/3/12.
 * 弹弹球制造工厂的代理人
 */
public class BounctBallProxy {

    public final static int BLACK_BOUNCTBALL = 1;
    public final static int BLUE_BOUNCTBALL = 2;


    public BounctBallProxy(ViewGroup viewGroup) {


    }


    /**
     * 如果要对每个球进行修改 还可以添加 tag
     *
     * @param viewGroup
     * @param bounctballKine
     */
    public static void createoBounctBall(ViewGroup viewGroup, int bounctballKine) {

        BouncyBall start = null;

        switch (bounctballKine) {

            case BLACK_BOUNCTBALL:
                start = new FactoryBlackBouncyBall().getCreateBouncyBall();
                Log.e("TAA", "createoBounctBall--------BLACK");

                break;

            case BLUE_BOUNCTBALL:
                start = new FactoryBlueBouncyBall().getCreateBouncyBall();
                Log.e("TAA", "createoBounctBall--------BLUE");
                break;

        }

        if (start != null) {
            start.createBouncyBall(viewGroup);
            Log.e("TAA", "createoBounctBall--------start-------");

        }

    }


    /**
     * 如果要对每个球进行修改 还可以添加 tag
     * 创建多个
     *
     * @param viewGroup
     * @param bounctballKine
     */
    public static void createoBounctBall(ViewGroup viewGroup, int bounctballKine, int num) {

        for (int x = 0; x < num; x++) {
            createoBounctBall(viewGroup, bounctballKine);
        }

    }


}
