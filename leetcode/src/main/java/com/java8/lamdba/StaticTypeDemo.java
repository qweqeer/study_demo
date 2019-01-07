package com.java8.lamdba;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: zhoux
 * @Email: zhouxiang@souche.com
 * @CreateDate: 2018/9/26
 * @Description:
 * @Modify :
 */
public class StaticTypeDemo {

    private int num = 0;

    public int incrementAndGet() {
        num++;
        return num;
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        CompletionService <Integer> server = new ExecutorCompletionService <Integer>(pool);
        for (int i = 0; i < 10; i++) {
            server.submit(new Callable <Integer>() {
                @Override
                public Integer call() throws Exception {
                    StaticTypeDemo demo = new StaticTypeDemo();
                    return demo.incrementAndGet();
                }
            });
        }
        for (int i = 0; i < 10; i++) {
            try{
                System.out.println(server.take().get());
            }catch (Exception e){
            }
        }
    }


}
