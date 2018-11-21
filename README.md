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
 	        implementation 'com.github.Jboob:JToast:1.0.2'
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
