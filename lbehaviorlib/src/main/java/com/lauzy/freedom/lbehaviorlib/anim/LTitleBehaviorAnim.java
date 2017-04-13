package com.lauzy.freedom.lbehaviorlib.anim;

import android.animation.ValueAnimator;
import android.view.View;

/**
 * Created by Lauzy on 2017/3/14.
 */

public class LTitleBehaviorAnim extends CommonAnim{

    private View mHeadView;


    public LTitleBehaviorAnim(View headView) {
        mHeadView = headView;
    }

    public void hideTitle() {

    }

    public void showTitle() {
    }

    @Override
    public void show() {
        ValueAnimator animator = ValueAnimator.ofFloat(mHeadView.getY(), 0);
        animator.setDuration(getDuration());
        animator.setInterpolator(getInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mHeadView.setY((Float) valueAnimator.getAnimatedValue());
            }
        });
        animator.start();
    }

    @Override
    public void hide() {
        ValueAnimator animator = ValueAnimator.ofFloat(mHeadView.getY(), -mHeadView.getHeight());
        animator.setDuration(getDuration());
        animator.setInterpolator(getInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mHeadView.setY((Float) valueAnimator.getAnimatedValue());
            }
        });
        animator.start();
    }
}
