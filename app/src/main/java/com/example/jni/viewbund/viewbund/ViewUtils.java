package com.example.jni.viewbund.viewbund;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by byz on 2017/8/15.
 */

public class ViewUtils {

    private ViewUtils() {
    }
    private static ViewUtils viewUtils;
    public static ViewUtils getViewUtils(){
        if (viewUtils == null){
            synchronized (ViewUtils.class){
                if (viewUtils==null){
                    viewUtils = new ViewUtils();
                }
            }
        }
        return viewUtils;
    }

    public void IndexFindViewById(Activity curClass){
        // 通过反射获取到全部属性，反射的字段可能是一个类（静态）字段或实例字段
        Field[] fields = curClass.getClass().getDeclaredFields();
        for(Field field : fields){
            FindviewbyId findviewbyId = field.getAnnotation(FindviewbyId.class);
            if(findviewbyId!=null){
                field.setAccessible(true);
                int id = findviewbyId.value();
                boolean isClick = findviewbyId.click();
                try {
                    if(isClick){
                        curClass.getWindow().getDecorView().findViewById(id).setOnClickListener((View.OnClickListener) curClass);
                    }
                    field.set(curClass,curClass.getWindow().getDecorView().findViewById(id));

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
