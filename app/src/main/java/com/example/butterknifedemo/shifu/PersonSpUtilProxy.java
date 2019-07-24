package com.example.butterknifedemo.shifu;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PersonSpUtilProxy {

    public static Boolean isDebug = true;

    public static Object getInstance() {

        Class<?>[] interfaces = {PersonSpUtil.class};
        SP sp = PersonSpUtil.class.getAnnotation(SP.class);
        String name = sp.name();
        System.out.println(name);
        Object obj = Proxy.newProxyInstance(PersonSpUtil.class.getClassLoader(), interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
                //第一个参数是target,也就是被代理类的对象；第二个参数是方法中的参数
                String name = method.getName();
                System.out.println(name);

                SPData annotation = method.getAnnotation(SPData.class);
                String key = annotation.key();

//                System.out.println(key);


                if (name.startsWith("save")) {
//                    file.save();
                    if (isDebug) {
                        System.out.println("method.getName()  =  " + method.getName());

                        System.out.println("args  =  " + args);
                        System.out.println("key  =  " + key);
                    }

                } else if (name.startsWith("get")) {
                    if (isDebug) {
                        System.out.println("method.getName()  =  " + method.getName());
                        System.out.println("key  =  " + key);
                    }

                }


                return null;
            }
        });
        return obj;
    }


}