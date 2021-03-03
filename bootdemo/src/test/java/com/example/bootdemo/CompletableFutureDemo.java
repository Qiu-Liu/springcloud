package com.example.bootdemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,5,5,
                        TimeUnit.SECONDS,new LinkedBlockingDeque<>());

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            CompletableFuture.runAsync(() -> {
                System.out.println(finalI +"开始执行++++++++++");

            },threadPoolExecutor);
        }

        threadPoolExecutor.shutdown();
        System.out.println("*****************");
    }
}
