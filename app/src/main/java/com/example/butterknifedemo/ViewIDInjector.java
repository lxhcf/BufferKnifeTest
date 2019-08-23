package com.example.butterknifedemo;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ViewIDInjector {
    public static void process(final Object object) {
        Class class1 = object.getClass();
        //找到类里所有变量Field
        Field[] fields = class1.getDeclaredFields();
        //遍历Field数组
        for (Field field : fields) {
            //找到相应的拥有Add注解的Field
            BindViewUtil bindViewUtil = field.getAnnotation(BindViewUtil.class);
            if (bindViewUtil != null) {
                if (object instanceof Activity) {
                    //((Activity) object).findViewById(bindViewUtil.id()
                    try {
//                        field=(TextView)((Activity) object).findViewById(bindViewUtil.id());
                        int id = bindViewUtil.id();
                        View view = (TextView) ((Activity) object).findViewById(id);
                        field.setAccessible(true);
                        field.set(object,view);
                        // object.bb = view

                    } catch (Exception e) {

                    }
                    //@BindView(R.id.user) EditText username;
                }
            }

//            BindViewUtil click = field.getAnnotation(BindClick.class);
//            bindViewUtil = field.getAnnotation(BindClick.class);
//            if (bindViewUtil != null) {
//                if (object instanceof Activity) {
//                    //((Activity) object).findViewById(bindViewUtil.id()
//                    try {
////                        field=(TextView)((Activity) object).findViewById(bindViewUtil.id());
//                        int id = bindViewUtil.id();
//                        View view = (TextView) ((Activity) object).findViewById(id);
//                        view.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//
//                                try {
//                                    Method clickme = object.getClass().getMethod("clickme",null);
//                                    clickme.invoke(object,null);
//                                    object.click();
//                                } catch (NoSuchMethodException e) {
//                                    e.printStackTrace();
//                                } catch (IllegalAccessException e) {
//                                    e.printStackTrace();
//                                } catch (InvocationTargetException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        });
//
//                    } catch (Exception e) {
//
//                    }
//                    //@BindView(R.id.user) EditText username;
//                }
//            }


        }

    }
}
