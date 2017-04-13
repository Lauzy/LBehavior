## LBehavior 简单实现标题栏、导航栏滑动动画


[![](https://jitpack.io/v/Lauzy/LBehavior.svg)](https://jitpack.io/#Lauzy/LBehavior)


#效果图


<img src="/screenshoots/screen1.gif" alt="screenshot" title="screenshot" width="270" height="460" /> <img src="/screenshoots/screen2.gif" alt="screenshot" title="screenshot" width="270" height="460" /> <img src="/screenshoots/screen3.gif" alt="screenshot" title="screenshot" width="270" height="460" />


#Download
```java
    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

    dependencies {
	        compile 'com.github.Lauzy:LBehavior:1.0.1'
	}

```

#Usage


基本使用：


根布局需为CoordinatorLayout，类似FrameLayout
```xml
    <android.support.design.widget.CoordinatorLayout
        ...>
		<View
 			...
			app:layout_behavior="@string/fab_vertical_behavior/>
    </android.support.design.widget.CoordinatorLayout>
```


根据不同的View在xml中设置不同的layout_behavior



参数     							|	说明
-----------------------------------|-----------------------
@string/title_view_behavior   		|   顶部标题栏
@string/bottom_view_behavior   	|   底部导航栏
@string/fab_scale_behavior   		|   浮动按钮（缩放）
@string/fab_vertical_behavior   	|    浮动按钮（上下滑动）



自定义(均设有默认值，可不使用)：


| 方法           	 		|    参数           	| 说明  					|
| ------------------------- |------------------ | --------------------- |
| setMinScrollY				| int y 			| 设置触发动画的最小滑动距离，如 setMinScrollY(10)为滑动10像素才可触发动画，默认为5.|
| setScrollYDistance		| int y      	    | 设置触发动画的滑动距离，防止用户缓慢滑动时单次滑动距离一直小于setMinScrollY的最小滑动距离导致无法触发动画.如设置此值为100，则用户即便缓慢滑动，当滑动距离达到100时也可触发动画.默认为40.|
| setDuration				| int duration     	| 设置动画持续时间.默认为400ms.|
| setInterpolator			| Interpolator interpolator | 设置动画插补器，修饰动画效果.默认模式为LinearOutSlowInInterpolator. [Interpolator官方文档](https://developer.android.google.cn/reference/android/view/animation/Interpolator.html)|


```java

	CommonBehavior.from(mFloatingActionButton).show();//代码控制显示
	CommonBehavior.from(mFloatingActionButton).hide();//隐藏

	CommonBehavior.from(mFloatingActionButton)
		.setMinScrollY(20)
		.setScrollYDistance(100)
		.setDuration(1000)
		.setInterpolator(new LinearOutSlowInInterpolator());
```


##Apk and More Info

For more usage, you can download or clone the demo. You can also [download the demo apk]().








