package com.quincy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk 动态代理演示
 *
 * @author quinc
 * @date 2018/11/13 星期二
 */
public class JdkDynamicProxy implements InvocationHandler {

    private Object object;

    public JdkDynamicProxy(Object o) {
        this.object = o;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用方法" + method.getName() + "前-----");
        Object o = method.invoke(object, args);
        System.out.println("调用方法" + method.getName() + "后-----");
        return o;
    }

    

    public static void main(String[] args) {
        IHelloWord helloWord = new HelloWorld();

        IHelloWord proxy = (IHelloWord) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                helloWord.getClass().getInterfaces(),
                new JdkDynamicProxy(helloWord));
        proxy.sayHello();
    }
}
