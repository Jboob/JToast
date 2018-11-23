[![](https://jitpack.io/v/Jboob/JToast.svg)](https://jitpack.io/#Jboob/JToast)
---
# This is a custom Toast library, welcome to use or mention issues.

---

# Why do I need a custom Toast?
- Default Android Toast,multiple clicks, repeat display.
- Custom Toast, multiple clicks, show once.
- Custom Toast, support custom background color, font color, Toast icon.

# Using JToast in your application
 **Step 1.** Add the JitPack repository to your build file
 Add it in your root build.gradle at the end of repositories:
 ```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
 **Step 2.** Add the dependency
 ```
 dependencies {
 	        implementation 'com.github.Jboob:JToast:1.0.3'
 	}
 ```
 **Step 3.**

 a. Simple to use
  ```
    JToast.getInstance(this).show("show one")
  ```
 b. Using constructor
 ```
 var creator = SystemToastCreator.build()
                    .shadowColor(Color.parseColor("#2F4F4F"))
                    .shadowRadius(15f)
                    .setTextColor(Color.parseColor("#ffffff"))
                    .creator()

            JToast.build()
                    .systemToastBuilder()
                    .setToastCreator(creator)
                    .setShowTime(2000)
                    .setText("show creator!")
                    .show(this)
 ```
 ```
 var customCreator = CustomToastCreator.build()
                    .setCustomView(R.layout.layout_toast)
                    .setTextColor(Color.WHITE)
                    .setBackgroundRound(true)
                    .creator()

            JToast.build()
                    .customToastBuilder()
                    .setToastCreator(customCreator)
                    .setShowTime(2000)
                    .setText("show customCreator!",R.id.message)
                    .show(this)
 ```
# Show results.
 <div align="center">

!["JToast"](https://github.com/Jboob/JToast/blob/master/images/default_toast.gif  "default_toast")

# default_toast

---

 </div>

 <div align="center">

![JToast](https://github.com/Jboob/JToast/blob/master/images/system_toast.gif "system_toast")

# system_toast

---

 </div>

 <div align="center">

![JToast](https://github.com/Jboob/JToast/blob/master/images/custom_system_toast.gif "custom_system_toast")

# custom_system_toast

---

 </div>

 <div align="center">

![JToast](https://github.com/Jboob/JToast/blob/master/images/custom_toast.gif "custom_toast")

# custom_toast

---

 </div>

# [吹垮垮中文文档](https://www.jianshu.com/p/9fbc9804bdc1)

My lame English notes from Google Translate, please understand. [ *Please your issues* ](https://github.com/Jboob/JToast/issues)

---

# License

 ```
MIT License

Copyright (c) 2018 Jboob

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 ```
