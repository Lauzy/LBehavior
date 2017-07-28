## LBehavior: Simple implementation of sliding animation of title bar, bottom bar and floatingActionButton.


[![](https://jitpack.io/v/Lauzy/LBehavior.svg)](https://jitpack.io/#Lauzy/LBehavior)

[中文文档](/README_CN.md)

## ScreenShoot


<img src="/screenshoots/screen1.gif" alt="screenshot" title="screenshot" width="270" height="460" /> <img src="/screenshoots/screen2.gif" alt="screenshot" title="screenshot" width="270" height="460" /> <img src="/screenshoots/screen3.gif" alt="screenshot" title="screenshot" width="270" height="460" />


## Blog Introduce

JianShu: [http://www.jianshu.com/p/2974d8ffc3a5](http://www.jianshu.com/p/2974d8ffc3a5)

Personal WebSite: [http://lauzy.me/2017/04/14/201705Behavior/](http://lauzy.me/2017/04/14/201705Behavior/)

## Download
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
The version code of the latest release can be found [here](https://github.com/Lauzy/LBehavior/releases)

## Usage


Xml file：

The root layout must be CoordinatorLayout，which is similar to FrameLayout
```xml
    <android.support.design.widget.CoordinatorLayout
        ...>
		<FloatingActionButton
 			...
			app:layout_behavior="@string/fab_vertical_behavior/>
    </android.support.design.widget.CoordinatorLayout>
```


Set different layout_behavior in xml file according to different view.



Param     							|	Explanation
-----------------------------------|-----------------------
@string/title_view_behavior   		|   TitleBar
@string/bottom_view_behavior   	|   BottomBar
@string/fab_scale_behavior   		|   FloatingActionButton（scale anim）
@string/fab_vertical_behavior   	|   FloatingActionButton（slide anim）



Custom properties(All have default values)：


| Function           	 	|    Param           	| Explanation  			|
| ------------------------- |------------------ | --------------------- |
| setMinScrollY				| int y 			| Sets the minimum sliding distance for triggering the animation. The default value is 5 pixels.|
| setScrollYDistance		| int y      	    | Sets the sliding distance for triggering the animation. The animation can be triggered when the total sliding distance is greater than this property, even if the single sliding distance is less than the minimum distance. The default value is 40 pixels.|
| setDuration				| int duration     	| Sets the length of the animation. The default value is 400 milliseconds.|
| setInterpolator			| Interpolator interpolator | Sets the interpolator to be used by this animation.The default interpolator is LinearOutSlowInInterpolator. [Interpolator official documentation](https://developer.android.google.cn/reference/android/view/animation/Interpolator.html)|


```java

	CommonBehavior.from(mFloatingActionButton).show();//show the view
	CommonBehavior.from(mFloatingActionButton).hide();//hide

	CommonBehavior.from(mFloatingActionButton)
		.setMinScrollY(20)
		.setScrollYDistance(100)
		.setDuration(1000)
		.setInterpolator(new LinearOutSlowInInterpolator());
```

## Tips

1、Because the root layout is CoordinatorLayout, the toolbar may cover the item at the top of the recyclerView when used, and the bottom bar may also cover the bottom item.
You can add a placeholder such as itemDecoration to the recyclerView, or a placeholder view at the top. If the situation is relatively simple, you can simply set padding, margin and so on.
I have dealt with this kind of situation in the demo simply.


2、If the elevation of the floatingActionButton is greater than that of the bottomBar, the animation of the floatingActionButton will cover the top of the bottomBar, and vice versa.


## Apk and More Info

For more usage, you can download or clone the demo. You can also [download the demo apk](https://github.com/Lauzy/LBehavior/raw/master/apk/demo.apk).


## License
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



