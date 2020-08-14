package com.miaopu.myspringboot.controller;

public class WaitTest {
    private static int[] arr1 = {1,2,3,4,5};
    private static int[] arr2 = {10,9,8,7,6};
    private static Object object = new Object();
    static Thread t1 = null;
    static Thread t2 = null;
    public static void main(String[] args) {
        t1 = new Thread("sdfds"){
            @Override
            public void run() {
                synchronized (object){
                    for (int i = 0; i < arr1.length; i++) {
                        System.out.println(arr1[i]);
                        try {
                            object.notify();
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    object.notify();
                }
            }
        };
        t2 = new Thread("ffdff"){
            @Override
            public void run() {
                synchronized (object){
                    for (int i = 0; i < arr2.length; i++) {
                        System.out.println(arr2[i]);
                        try {
                            object.notify();
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    object.notify();
                }

            }
        };
        t1.start();
        t2.start();
    }
}
