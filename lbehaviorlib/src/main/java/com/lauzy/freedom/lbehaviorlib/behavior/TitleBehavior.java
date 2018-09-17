package com.lauzy.freedom.lbehaviorlib.behavior;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.lauzy.freedom.lbehaviorlib.IBehavior;
import com.lauzy.freedom.lbehaviorlib.IBehaviorAnim;
import com.lauzy.freedom.lbehaviorlib.anim.TitleBehaviorAnim;

public class TitleBehavior extends CommonBehavior implements IBehavior {

    public TitleBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @NonNull
    @Override
    public IBehaviorAnim createBehaviorAnim(CoordinatorLayout coordinatorLayout, View child) {
        return new TitleBehaviorAnim(child);
    }
}
