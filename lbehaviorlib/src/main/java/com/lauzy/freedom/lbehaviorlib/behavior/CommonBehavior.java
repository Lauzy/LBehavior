package com.lauzy.freedom.lbehaviorlib.behavior;


import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;

import com.lauzy.freedom.lbehaviorlib.anim.CommonAnim;
import com.lauzy.freedom.lbehaviorlib.anim.LBottomBehaviorAnim;

@SuppressWarnings("unused")
public class CommonBehavior extends CoordinatorLayout.Behavior<View> {
    private static final String LYTAG = LTitleBehavior.class.getSimpleName();
    protected CommonAnim mCommonAnim;
    private boolean isHide;
    private boolean canScroll = true;
    private int mTotalScrollY;
    protected boolean isInit = true; //防止new Anim导致的parent 和child坐标变化

    private int mDuration = 400;
    private Interpolator mInterpolator = new LinearOutSlowInInterpolator();
    private int minScrollY = 5;//触发滑动动画最小距离
    private int scrollYDistance = 40;//设置最小滑动距离

    public CommonBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /*//判断垂直滑动
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }*/

    public CommonBehavior setDuration(int duration) {
        mDuration = duration;
        return this;
    }

    public CommonBehavior setInterpolator(Interpolator interpolator) {
        mInterpolator = interpolator;
        return this;
    }

    public CommonBehavior setMinScrollY(int minScrollY) {
        this.minScrollY = minScrollY;
        return this;
    }

    public CommonBehavior setScrollYDistance(int scrollYDistance) {
        this.scrollYDistance = scrollYDistance;
        return this;
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
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
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
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        if (canScroll) {
            mTotalScrollY += dyConsumed;
            if (Math.abs(dyConsumed) > minScrollY || Math.abs(mTotalScrollY) > scrollYDistance) {
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
        }
    }

    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View child, final View target) {
        super.onStopNestedScroll(coordinatorLayout, child, target);
    }

    public void setCanScroll(boolean canScroll) {
        this.canScroll = canScroll;
    }

    public void show() {
        if (mCommonAnim != null) {
            isHide = false;
            mCommonAnim.show();
        }
    }

    public void hide() {
        if (mCommonAnim != null) {
            isHide = true;
            mCommonAnim.hide();
        }
    }

    public static CommonBehavior from(View view) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (!(params instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) params).getBehavior();
        if (!(behavior instanceof CommonBehavior)) {
            throw new IllegalArgumentException("The view's behavior isn't an instance of CommonBehavior. Try to check the [app:layout_behavior]");
        }
        return (CommonBehavior) behavior;
    }
}
