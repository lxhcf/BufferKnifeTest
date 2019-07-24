package com.example.butterknifedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.butterknifedemo.lx.MyInterfaceProxyUtil;
import com.example.butterknifedemo.lx.MyInterfaceUtil;
import com.example.butterknifedemo.shifu.PersonSpUtilProxy;

public class MainActivity extends AppCompatActivity {
    @BindViewUtil(id = R.id.txt)
    TextView txtView;

    /**
     * 7.22
     */
    @BindClick(id = R.id.txt, value = "onClick")
    void onClick() {
//        Log.d("Main", "单机方法被调用");
//        txtView.setText("asdas");

        /**
         * 7.23
         * 没有通过在activity里加注解,直接把一个字符串绑定到文本框中
         * 0.两个注解都只是定义了一个字符串传入参数
         * 1.定义了一个工具接口 PersonSpUtil,这个接口被注解SP修饰,方法saveName,getName,saveAdd,getAdd被注解SPDATA修饰
         * 2.PersonSpUtilProxy类只有一个静态方法,就是创建一个动态代理对象
         */
//        PersonSpUtil instance = PersonSpUtilProxy.getInstance(MainActivity.this);
//        //调用动态代理的保存功能
//        instance.saveName("22222222");
////        获取动态代理的一个字符串
//        String name = instance.getName();
//        //将该字符串显示
//        txtView.setText(name);
//        //调用该代理的saveadd方法
//        instance.saveAdd("奥克斯打算  dasha");
//        //把instance.getAdd()获取的值显示出来
//        txtView.setText(instance.getAdd());

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        初期做法
        InjectUtils.inject(this);

//        Log.i("ele=========",ele+"");
//第二版提交
        /**
         * 1.PersonSpUtilProxy没有实现PersonSpUtil接口,怎么能相等?
         * 答:有的newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
         * 第二个参数就把要实现的接口传进去了
         * 2.生成的动态代理是PersonSpUtil类型
         */
//        PersonSpUtil instance = PersonSpUtilProxy.getInstance(MainActivity.this);
//        //调用动态代理的保存功能
//        instance.saveName("22222222");
////        获取动态代理的一个字符串
//        String name = instance.getName();
//        //将该字符串显示
//        txtView.setText(name);
//        //调用该代理的saveadd方法
//        instance.saveAdd("奥克斯打算  dasha");
//        //把instance.getAdd()获取的值显示出来
//        txtView.setText(instance.getAdd());
        /**
         * 第三版:
         * 问题:怎么动态改变注解中的参数
         * 答:不用改变,注解中的参数是故意写死的
         */
        MyInterfaceUtil instance = MyInterfaceProxyUtil.getInstance(MainActivity.this);
        //调用动态代理的保存功能
        instance.save("奥克斯");
//        获取动态代理的一个字符串
        String name = instance.get("奥克斯");
        //将该字符串显示
        txtView.setText(name);


    }


}
