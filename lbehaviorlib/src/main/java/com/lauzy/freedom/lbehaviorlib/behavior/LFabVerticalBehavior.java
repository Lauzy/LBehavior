package com.lauzy.freedom.lbehaviorlib.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

import com.lauzy.freedom.lbehaviorlib.anim.LFabVerticalBehaviorAnim;


public class LFabVerticalBehavior extends CommonBehavior {

    public LFabVerticalBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return super.layoutDependsOn(parent, child, dependency);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        /*if (isInit) {
            mCommonAnim = new LFabVerticalBehaviorAnim(parent, child);
            isInit = false;
        }*/
        return super.onDependentViewChanged(parent, child, dependency);
    }

    //判断垂直滑动
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child,
                                       View directTargetChild, View target, int nestedScrollAxes) {
        if (isInit) {
            mCommonAnim = new LFabVerticalBehaviorAnim(coordinatorLayout, child);
            isInit = false;
        }
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }
}
