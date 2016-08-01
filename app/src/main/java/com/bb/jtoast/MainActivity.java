package com.bb.jtoast;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bb.jtoast.constant.Constants;
import com.bb.jtoast.view.JToast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.show)
    Button show;

    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.ctx = this;
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JToast.getInstance().show(ctx,"show 一个！", Constants.TOAST_TIMEOUT);
            }
        });
    }
}
