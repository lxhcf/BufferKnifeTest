package com.example.butterknifedemo.fruit;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class FruitImplProxyHandler implements InvocationHandler {
    FruitImpl fruit=new FruitImpl();

    public Object getInstance(){
        return Proxy.newProxyInstance(FruitImpl.class.getClassLoader(), FruitImpl.class.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Log.d("fruit","正在准备");
        method.invoke(fruit,objects);
        return null;
    }
}
