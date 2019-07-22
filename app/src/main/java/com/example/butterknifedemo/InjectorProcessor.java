package com.example.butterknifedemo;

import android.app.Activity;

import java.lang.reflect.Field;

public class InjectorProcessor {
    public void process(final Object object) {

        Class class1 = object.getClass();
        //找到类里所有变量Field
        Field[] fields = class1.getDeclaredFields();
        //遍历Field数组
        for(Field field:fields){
            //找到相应的拥有Add注解的Field
            Add addMethod = field.getAnnotation(Add.class);
            if (addMethod != null){
                if(object instanceof Activity){
                    //获取注解中ele1和ele2两个数字，然后把他们相加
                    double d = addMethod.ele1() + addMethod.ele2();
                    try {
                        //把相加结果的值赋给该Field
                        field.setDouble(object,d);
                    }catch (Exception e){

                    }

                }
            }
        }

    }
}
