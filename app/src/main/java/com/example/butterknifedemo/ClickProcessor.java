package com.example.butterknifedemo;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * field是字段
 * method是方法
 */
public class ClickProcessor {
    public static void process(final Object object) {
        final Class class1 = object.getClass();
        Method[] methods=class1.getMethods();

        for (final Method method:methods){
            BindClick bindClick=method.getAnnotation(BindClick.class);
            if (bindClick != null ) {
                final String methodName=bindClick.value();

                int id = bindClick.id();
                View view = (View) ((Activity) object).findViewById(id);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            Method click=object.getClass().getMethod(methodName,null);
                            click.invoke(object,null);
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                });
                /**
                 * 给该方法设定一个单机事件,单机事件要绑定到view
                 */

            }
        }
    }
}
