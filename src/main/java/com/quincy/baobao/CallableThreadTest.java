package com.quincy.baobao;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author quinc
 * @date 2019/1/26 星期六
 */
public class CallableThreadTest {

    private static Object object1 = new Object();
    private static Object object2 = new Object();

    public static void main(String args[]) {
        Callable<Integer> oneCallable = new CallableThread();
        try {
            //Integer a = oneCallable.call();
            System.out.println(Integer.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //由Callable<Integer>创建一个FutureTask<Integer>对象：
        FutureTask<Integer> oneTask = new FutureTask<Integer>(oneCallable);
        //注释：FutureTask<Integer>是一个包装器，它通过接受Callable<Integer>来创建，它同时实现了Future和Runnable接口。
        //由FutureTask<Integer>创建一个Thread对象：
        Thread oneThread = new Thread(oneTask);
        AtomicInteger integer = new AtomicInteger(1);
        integer.getAndAdd(1);
       // oneThread.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
               synchronized (object1){
                   try {
                       Thread.sleep(3000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println("线程1未完成，等待线程2");
                   synchronized (object2){
                       System.out.println("线程1完成");
                   }
               }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object2){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程2未完成，等待线程1");
                    synchronized (object1){
                        System.out.println("线程2完成");
                    }
                }
            }
        }).start();

    }
}
