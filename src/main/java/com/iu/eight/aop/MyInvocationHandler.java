package com.iu.eight.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Author hex1n
 * @Time 2020/5/10 22:14
 */
public class MyInvocationHandler implements InvocationHandler {
    //委托对象
    private Object obj = null;

    public Object bind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + "的参数是:" + Arrays.toString(args));
        Object result = method.invoke(this.obj, args);
        System.out.println(method.getName() + "的结果是:" + result);
        return result;
    }
}
