package com.example.butterknifedemo.lx;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Debug;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 注解写在接口里
 * 接口被代理类实现
 * 创建一个代理类实例
 * 返回一个(MyInterfaceUtil)object对象
 * 创建代理类对象
 * 代理类对象的生成需要三个参数:
 * classLoader;
 * interface
 * invocationHandler:
 * 获取注解类传入的参数:
 * 获取方法
 *
 */
public class MyInterfaceProxyUtil {

    public static MyInterfaceUtil getInstance(Context c) {
        //接口不用实例化  MyInterfaceUtil.class
        Context context =c;
        final SharedPreferences sharedPreferences = context.getSharedPreferences("DBFile", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
//        Sp sp= (Sp) MyInterfaceUtil.class.getAnnotation(Sp.class);


        /**
         * 1.classloader
         */
        ClassLoader classLoader =  MyInterfaceUtil.class.getClassLoader();
        /**
         * 2.interface
         */
        Class<?>[] interfaces = {MyInterfaceUtil.class};
        /**
         * 3.InvocationHandler
         */
        InvocationHandler h = new InvocationHandler() {
            @Override
            public String invoke(Object o, Method method, Object[] objects) throws Throwable {
                if (true) {
                    //获取该对象的方法名
                    String methodName = method.getName();
                    //获取注解传进的参数(错)
                    SPData spData=method.getAnnotation(SPData.class);
                    String inputValue=spData.value();
                    //获取方法传入的参数

                    //如果方法名以save开头
                    if (methodName.startsWith("save")) {
//                        sharedPreferences.getString(key,"missing");
                        editor.putString(inputValue,inputValue);
                        editor.apply();
                    }
                    else {
                        if(methodName.startsWith("get"))
                            return (String) sharedPreferences.getString(inputValue,inputValue);
                    }
                }
                return null;


            }
        };
        /**
         * 生成代理对象
         */
        Object object = Proxy.newProxyInstance(classLoader, interfaces, h);
        return (MyInterfaceUtil) object;
    }
}