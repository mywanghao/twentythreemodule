package com.example.hao.twenty_three_module.factorypattern;

/**
 * Created by hao on 2016/3/12.
 */
public interface FactoryBouncyBall  {
    BouncyBall getCreateBouncyBall();
}

class FactoryBlackBouncyBall implements  FactoryBouncyBall{


    @Override
    public BouncyBall getCreateBouncyBall() {
        return new BlackBouncyBall();
    }
}



class FactoryBlueBouncyBall implements  FactoryBouncyBall{


    @Override
    public BouncyBall getCreateBouncyBall() {
        return new BlueBouncyBall();
    }
}


