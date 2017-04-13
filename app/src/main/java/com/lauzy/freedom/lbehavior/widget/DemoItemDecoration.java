package com.lauzy.freedom.lbehavior.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;


public class DemoItemDecoration extends RecyclerView.ItemDecoration {

    private Paint mPaint;
    private int mTitleHeight;
    private static int COLOR_STYLE = Color.parseColor("#FFFFFF");

    public DemoItemDecoration(Context context) {
        mPaint = new Paint();
//        float toolbarHeight = 40 + DensityUtils.px2dp(context, ScreenUtils.getStatusHeight(context));
        float toolbarHeight = 48; //默认toolbar高度48dp
        mTitleHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, toolbarHeight, context.getResources().getDisplayMetrics());
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        if (position == 0) {
            outRect.set(0, mTitleHeight, 0, 0);
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int position = params.getViewLayoutPosition();
            if (position == 0) {
                drawEmpty(c, left, right, child, params, position);
            }else {
                // do something
            }
        }
    }

    private void drawEmpty(Canvas c, int left, int right, View child, RecyclerView.LayoutParams params, int position) {
        mPaint.setColor(COLOR_STYLE);
        c.drawRect(left, child.getTop() - params.topMargin - mTitleHeight, right, child.getTop() - params.topMargin, mPaint);
    }
}
