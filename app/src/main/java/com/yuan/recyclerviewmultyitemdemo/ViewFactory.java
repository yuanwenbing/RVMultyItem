package com.yuan.recyclerviewmultyitemdemo;

import android.content.Context;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by yuan 2019/2/13.
 */
public class ViewFactory {

    @SuppressWarnings("unchecked")
    public static <T extends IItemVew> T getViewProxy(Context context, int viewType) {

        try {
            Class clazz = getViewClass(viewType);
            final Object o = clazz.getConstructor(Context.class).newInstance(context);
            return (T) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return method.invoke(o, args);
                }
            });
        } catch (Exception e) {
            return (T) new ItemViewDefault(context);
        }
    }


    private static Class<? extends IItemVew> getViewClass(int viewType) {
        switch (viewType) {
            case IItemVew.VIEW_TYPE_0:
                return ItemView0.class;
            case IItemVew.VIEW_TYPE_1:
                return ItemView1.class;
            case IItemVew.VIEW_TYPE_2:
                return ItemView2.class;
            default:
                return ItemViewDefault.class;
        }
    }
}

