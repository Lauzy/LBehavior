package com.lauzy.freedom.lbehaviorlib;

import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;

/**
 * Desc : behavior 接口
 * Author : lauzy
 * Date : 2018/9/17
 * Email : freedompaladin@gmail.com
 */
public interface IBehavior {

    @NonNull
    IBehaviorAnim createBehaviorAnim(CoordinatorLayout coordinatorLayout, View child);

    void show();

    void hide();

}
