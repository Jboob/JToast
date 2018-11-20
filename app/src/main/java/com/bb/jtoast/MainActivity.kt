package com.bb.jtoast

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.ran.creator.CustomToastCreator
import com.ran.creator.SystemToastCreator
import com.ran.toast.JToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        default_toast.setOnClickListener(View.OnClickListener {
            Toast.makeText(this,"show 一个！",Toast.LENGTH_SHORT).show()
            Toast.makeText(this,"show 两个！",Toast.LENGTH_SHORT).show()
        })

        system_toast.setOnClickListener(View.OnClickListener {
            JToast.getInstance(this).show("show 一个！")
            JToast.getInstance(this).show("show 两个！")
            JToast.getInstance(this).show("show 三个！")

        })

        custom_system_toast.setOnClickListener(View.OnClickListener {
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
        })

        custom_toast.setOnClickListener(View.OnClickListener {

            var customCreator = CustomToastCreator.build()
                    .setCustomView(R.layout.layout_toast)
//                    .setBackgroundColor(Color.BLUE)
                    .setTextColor(Color.WHITE)
                    .setBackgroundRound(true)
                    .creator()

            JToast.build()
                    .customToastBuilder()
                    .setToastCreator(customCreator)
                    .setShowTime(2000)
                    .setText("show customCreator!",R.id.message)
                    .show(this)
        })

    }
}
