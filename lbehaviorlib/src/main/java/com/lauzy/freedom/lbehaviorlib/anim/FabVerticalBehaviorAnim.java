package com.lauzy.freedom.lbehaviorlib.anim;

import android.animation.ValueAnimator;
import android.view.View;

import com.lauzy.freedom.lbehaviorlib.IBehaviorAnim;

/**
 * Desc : FloatingActionBar 垂直动画
 * Author : lauzy
 * Date : 2018/9/17
 * Email : freedompaladin@gmail.com
 */
public class FabVerticalBehaviorAnim extends AbsBehaviorAnim implements IBehaviorAnim {

    private float mViewY;
    private View mFabView;
    private float mOriginalY;

    public FabVerticalBehaviorAnim(View parentView, View fabView) {
        mFabView = fabView;
        if (parentView != null && fabView != null) {
            mViewY = parentView.getHeight() - fabView.getY();
            mOriginalY = fabView.getY();
        }
    }

    @Override
    public void show() {
        ValueAnimator animator = ValueAnimator.ofFloat(mFabView.getY(), mOriginalY);
        animator.setDuration(getDuration());
        animator.setInterpolator(getInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mFabView.setY((Float) valueAnimator.getAnimatedValue());
            }
        });
        animator.start();
    }

    @Override
    public void hide() {
        ValueAnimator animator = ValueAnimator.ofFloat(mOriginalY, mOriginalY + mViewY);
        animator.setDuration(getDuration());
        animator.setInterpolator(getInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mFabView.setY((Float) valueAnimator.getAnimatedValue());
            }
        });
        animator.start();
    }
}
