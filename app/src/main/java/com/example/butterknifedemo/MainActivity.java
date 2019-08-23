package com.example.butterknifedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.butterknifedemo.bindview.BindViewGroup;
import com.example.butterknifedemo.fruit.Fruit;
import com.example.butterknifedemo.fruit.FruitImpl;
import com.example.butterknifedemo.fruit.FruitImplObjProxyHandler;
import com.example.butterknifedemo.fruit.FruitImplProxyHandler;
import com.example.butterknifedemo.fruit.FruitProxyHandler;



@BindViewGroup(id = R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @BindViewUtil(id = R.id.txt)
    TextView txtView;

//    @BindClick(id = R.id.txt, value = "onClick")


    /**
     * 7.22
     */
    @BindClick(id = R.id.txt, value = "onClick")
    void onClick() {
//        Log.d("Main", "单机方法被调用");
        txtView.setText("asdas");

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

        /**
         * 8.8绑定页面布局id
         */
//        BindViewGroup bindViewGroup = (BindViewGroup) this.getClass().getAnnotation(BindViewGroup.class);
//        int layout = bindViewGroup.id();
//        setContentView(R.layout.activity_main);

//        LinearLayout mainLayout = (LinearLayout) findViewById(layout);
//        LayoutInflater layoutInflater = LayoutInflater.from(this);
//        View buttonLayout = layoutInflater.inflate(R.layout.button_layout, null);
//        mainLayout.addView(buttonLayout);


////        初期做法
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
//        MyInterfaceUtil instance = MyInterfaceProxyUtil.getInstance(MainActivity.this);
//        //调用动态代理的保存功能
//        instance.save("奥克斯");
////        获取动态代理的一个字符串
//        String name = instance.get("奥克斯");
//        //将该字符串显示
//        txtView.setText(name);
        /**
         * 第四版:动态代理小demo
         * 要求：运用Proxy动态代理来增强方法
         * 题目：
         *     1.定义接口Fruit，其中有addFruit方法
         *     2.定义实现类FruitImpl，实现Fruit接口
         *     3.定义测试类，利用动态代理类的方式，增强addFruit方法
         */


        //代理类的对象
//        FruitImplObjProxyHandler fruitImplObjProxyHandler =new FruitImplObjProxyHandler();
//        FruitImpl fruitIml=new FruitImpl();
//        Fruit fruit=(Fruit) fruitImplObjProxyHandler.getInstace(fruitIml);
//        fruit.addFruit();

        //代理类
//        FruitImplProxyHandler fruitImplProxyHandler=new FruitImplProxyHandler();
//        Fruit fruit=(Fruit)fruitImplProxyHandler.getInstance();
//        fruit.addFruit();

        //代理接口
//        FruitProxyHandler fruitProxyHandler = new FruitProxyHandler();
//        Fruit fruit = (Fruit) fruitProxyHandler.getInstace();
//        fruit.addFruit();


    }


}
