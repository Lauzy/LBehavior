## LBehavior 简单实现标题栏、导航栏、悬浮按钮的滑动动画


[![](https://jitpack.io/v/Lauzy/LBehavior.svg)](https://jitpack.io/#Lauzy/LBehavior)


## 效果图


<img src="/screenshoots/screen1.gif" alt="screenshot" title="screenshot" width="270" height="460" /> <img src="/screenshoots/screen2.gif" alt="screenshot" title="screenshot" width="270" height="460" /> <img src="/screenshoots/screen3.gif" alt="screenshot" title="screenshot" width="270" height="460" />


## 博客介绍

简书:[http://www.jianshu.com/p/2974d8ffc3a5](http://www.jianshu.com/p/2974d8ffc3a5)

个人网站:[http://lauzy.me/2017/04/14/Behavior/](http://lauzy.me/2017/04/14/Behavior/)

## 下载

```java
    allprojects {
	    repositories {
		    ...
		    maven { url 'https://jitpack.io' }
	    }
	}

    dependencies {
        compile 'com.android.support:design:25.3.1'(latestVersion)
        compile 'com.github.Lauzy:LBehavior:VERSION_CODE'
	}
```
最新版本号，点击[这里](https://github.com/Lauzy/LBehavior/releases)

## 用法


基本使用：


根布局需为CoordinatorLayout，类似FrameLayout
```xml
    <android.support.design.widget.CoordinatorLayout
        ...>
		<FloatingActionButton
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

## Tips

1、因为根布局为CoordinatorLayout，所以使用时Toolbar可能会遮盖RecyclerView顶部的item，BottomBar也可能会遮盖底部item。
可以参考知乎首页设置顶部留白，具体可为RecyclerView添加一个占位的ItemDecoration，或者顶部加一个占位的View，若场景比较固定可简单设置Padding，Margin等，
详情可见Demo，简单处理了这种情况。


2、FloatingActionButton的elevation若大于BottomBar的elevation，则FloatingActionButton动画覆盖在BottomBar上层，反之则在下层，为gif的下部两个按钮的效果。


## Demo

欢迎下载项目和[体验Apk](https://github.com/Lauzy/LBehavior/raw/master/apk/demo.apk).

## 开源协议
```
Copyright 2017 Lauzy

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```