package com.example.butterknifedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//        @BindViewUtil(R.id.title) TextView title;

//    @Add(ele1 = 10f,ele2 = 1010f)
//    @BindView(R.id.user) EditText username;
//
//
//    @BindView(R.id.user)
//    public void aaaa(){
//
//    }
    @BindViewUtil(id = R.id.txt) TextView txtView;
    @BindClick(id = R.id.txt,value = "onClick") void onClick(){
        Log.d("Main","单机方法被调用");
        txtView.setText("asdas");
    }




    public double ele;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        初期做法
        InjectUtils.inject(this);

//        Log.i("ele=========",ele+"");
//第二版提交



    }



}
