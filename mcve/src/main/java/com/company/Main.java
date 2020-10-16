package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Request request = new Request("requestName");
        AspectUsageClass usageClass = new AspectUsageClass();

        usageClass.addEvent(request)
                .subscribe(
                        System.out::println,
                        System.out::println
                );

        Thread.sleep(2500);
    }
}