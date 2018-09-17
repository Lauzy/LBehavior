package com.lauzy.freedom.lbehaviorlib.anim;

import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.Interpolator;

import com.lauzy.freedom.lbehaviorlib.IBehaviorAnim;

/**
 * Desc : 抽象动画类，统一设置属性
 * Author : lauzy
 * Date : 2018/9/17
 * Email : freedompaladin@gmail.com
 */
public abstract class AbsBehaviorAnim implements IBehaviorAnim {

    private Interpolator mInterpolator = new LinearOutSlowInInterpolator();
    private int mDuration = 400;

    @Override
    public Interpolator getInterpolator() {
        return mInterpolator;
    }

    @Override
    public void setInterpolator(Interpolator interpolator) {
        mInterpolator = interpolator;
    }

    @Override
    public int getDuration() {
        return mDuration;
    }

    @Override
    public void setDuration(int duration) {
        mDuration = duration;
    }

    @Override
    public abstract void show();

    @Override
    public abstract void hide();

}
