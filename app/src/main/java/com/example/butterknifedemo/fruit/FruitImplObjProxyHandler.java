package com.example.butterknifedemo.fruit;

import android.util.Log;

import androidx.core.app.NavUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class FruitImplObjProxyHandler implements InvocationHandler {
    Object tarObj;
    public Object getInstace(Object o){
        tarObj=o;
        return Proxy.newProxyInstance(o.getClass().getClassLoader(),o.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        String methodName=method.getName();
        if(methodName.startsWith("add")){
            Log.d("fruit","对象的添加水果前操作");
            method.invoke(tarObj,objects);
        }
        return null;
    }
}
