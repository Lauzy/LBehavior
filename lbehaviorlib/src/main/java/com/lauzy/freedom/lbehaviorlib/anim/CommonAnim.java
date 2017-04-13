package com.lauzy.freedom.lbehaviorlib.anim;


import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.Interpolator;

public abstract class CommonAnim {

    public Interpolator interpolator = new LinearOutSlowInInterpolator();

    public int duration = 400;

    public Interpolator getInterpolator() {
        return interpolator;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public abstract void show();

    public abstract void hide();
}
