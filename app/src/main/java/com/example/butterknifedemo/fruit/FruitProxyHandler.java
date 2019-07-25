package com.example.butterknifedemo.fruit;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class FruitProxyHandler implements InvocationHandler {

    public  Object getInstace(){
        return Proxy.newProxyInstance(Fruit.class.getClassLoader(), new Class[]{Fruit.class},this);
    }
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        String methodName=method.getName();
        if(methodName.startsWith("add")){
            Log.d("fruit","正在准备添加水果");
        }
        return null;
    }
}
