package com.quincy.baobao;

import java.util.concurrent.Callable;

/**
 * @author quinc
 * @date 2019/1/26 星期六
 */
public class CallableThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("创建线程成功");


        return 1;
    }
}
