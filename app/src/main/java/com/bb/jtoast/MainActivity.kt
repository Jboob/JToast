package com.bb.jtoast

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ran.creator.CustomToastCreator
import com.ran.creator.SystemToastCreator
import com.ran.toast.JToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        roundLayout.setBackgroundColor(Color.GRAY)
        show.setOnClickListener(View.OnClickListener {
            //            com.ran.creator.base.JToast.getInstance(this).show("show 一个！")
//            com.ran.creator.base.JToast.getInstance(this).show("show 两个！")

//            JToast.getInstance(this).show("show 一个！")
//            JToast.getInstance(this).show("show 两个！")
//            JToast.getInstance(this).show("show 三个！")

            var creator = SystemToastCreator.build()
                    .setBackgroundColor(Color.TRANSPARENT)
                    .shadowColor(Color.parseColor("#2F4F4F"))
                    .shadowRadius(15f)
                    .setTextColor(Color.parseColor("#2F4F4F"))
                    .creator()

            var customCreator = CustomToastCreator.build()
                    .setCustomView(R.layout.layout_toast)
//                    .setBackgroundColor(Color.BLUE)
                    .setTextColor(Color.GREEN)
                    .creator()

            JToast.build()
                    .customToastBuilder()
                    .setToastCreator(customCreator)
                    .setShowTime(2000)
                    .setText("show customCreator!",R.id.message)
                    .show(this)

//            JToast.build()
//                    .systemToastBuilder()
//                    .setToastCreator(creator)
//                    .setShowTime(2000)
//                    .setText("show creator!")
//                    .show(this)
//
//            JToast.build()
//                    .systemToastBuilder()
//                    .setToastCreator(creator)
//                    .setShowTime(2000)
//                    .setText("show creator 1!")
//                    .show(this)
//            Toast.makeText(this,"show 一个！",Toast.LENGTH_SHORT).show()
//            Toast.makeText(this,"show 两个！",Toast.LENGTH_SHORT).show()
        })
    }
}
