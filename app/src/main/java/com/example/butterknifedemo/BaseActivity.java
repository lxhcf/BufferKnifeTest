package com.example.butterknifedemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.butterknifedemo.bindview.BindViewGroup;

class BaseActivity  extends AppCompatActivity {
//    BindViewGroup bindViewGroup;
//    int layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BindViewGroup bindViewGroup = (BindViewGroup) this.getClass().getAnnotation(BindViewGroup.class);
        int layout = bindViewGroup.id();
        setContentView(layout);
    }

    /**
     * 继承该类的子类如果有两个,注解的id各不相同,如何区分
     * 1.
     */

}
