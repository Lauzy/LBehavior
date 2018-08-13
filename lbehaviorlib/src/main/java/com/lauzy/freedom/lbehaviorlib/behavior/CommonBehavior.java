package com.lauzy.freedom.lbehaviorlib.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;

import com.lauzy.freedom.lbehaviorlib.anim.CommonAnim;

public class CommonBehavior extends CoordinatorLayout.Behavior<View> {
    private static final String TAG = "CommonBehavior";
    protected CommonAnim mCommonAnim;
    private boolean isHide;
    private boolean isEnableScroll = true;
    private int mTotalScrollY;
    protected boolean isInit = true; //防止new Anim导致的parent 和child坐标变化

    private int mDuration = 400;
    private Interpolator mInterpolator = new LinearOutSlowInInterpolator();
    private int mMinScrollY = 5;//触发滑动动画最小距离
    private int mScrollYDistance = 40;//设置最小滑动距离

    public CommonBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return super.layoutDependsOn(parent, child, dependency);
    }

    /**
     * 触发滑动嵌套滚动之前调用的方法
     *
     * @param coordinatorLayout coordinatorLayout父布局
     * @param child             使用Behavior的子View
     * @param target            触发滑动嵌套的View(实现NestedScrollingChild接口)
     * @param dx                滑动的X轴距离
     * @param dy                滑动的Y轴距离
     * @param consumed          父布局消费的滑动距离，consumed[0]和consumed[1]代表X和Y方向父布局消费的距离，默认为0
     */
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target,
                                  int dx, int dy, int[] consumed) {
        if (mCommonAnim != null) {
            mCommonAnim.setDuration(mDuration);
            mCommonAnim.setInterpolator(mInterpolator);
        }
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
    }


    /**
     * 滑动嵌套滚动时触发的方法
     *
     * @param coordinatorLayout coordinatorLayout父布局
     * @param child             使用Behavior的子View
     * @param target            触发滑动嵌套的View
     * @param dxConsumed        TargetView消费的X轴距离
     * @param dyConsumed        TargetView消费的Y轴距离
     * @param dxUnconsumed      未被TargetView消费的X轴距离
     * @param dyUnconsumed      未被TargetView消费的Y轴距离(如RecyclerView已经到达顶部或底部，而用户继续滑动，此时dyUnconsumed的值不为0，可处理一些越界事件)
     */
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target,
                               int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        if (!isEnableScroll) {
            return;
        }
        mTotalScrollY += dyConsumed;
        if (Math.abs(dyConsumed) < mMinScrollY && Math.abs(mTotalScrollY) < mScrollYDistance) {
            return;
        }
        if (dyConsumed < 0) {
            if (isHide) {
                mCommonAnim.show();
                isHide = false;
            }
        } else if (dyConsumed > 0) {
            if (!isHide) {
                mCommonAnim.hide();
                isHide = true;
            }
        }
        mTotalScrollY = 0;
    }

    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View child, final View target) {
        super.onStopNestedScroll(coordinatorLayout, child, target);
    }

    public void isEnableScroll(boolean isEnableScroll) {
        this.isEnableScroll = isEnableScroll;
    }

    public void show() {
        if (mCommonAnim == null) {
            return;
        }
        isHide = false;
        mCommonAnim.show();
    }

    public void hide() {
        if (mCommonAnim == null) {
            return;
        }
        isHide = true;
        mCommonAnim.hide();
    }

    public static CommonBehavior from(View view) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (!(params instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) params).getBehavior();
        if (!(behavior instanceof CommonBehavior)) {
            throw new IllegalArgumentException("The view's behavior isn't an instance of CommonBehavior. " +
                    "Try to check the [app:layout_behavior]");
        }
        return (CommonBehavior) behavior;
    }

    /*--- settings ---*/
    public void setDuration(int duration) {
        mDuration = duration;
    }

    public void setInterpolator(Interpolator interpolator) {
        mInterpolator = interpolator;
    }

    public void setMinScrollY(int minScrollY) {
        mMinScrollY = minScrollY;
    }

    public void setScrollYDistance(int scrollYDistance) {
        mScrollYDistance = scrollYDistance;
    }
}
