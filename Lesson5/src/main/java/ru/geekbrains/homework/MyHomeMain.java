package ru.geekbrains.homework;

import java.util.Arrays;

public class MyHomeMain {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        walkArrayOneThread();
        walkArrayTwoThread();
    }

    public static void walkArrayOneThread(){
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One Thread " + (System.currentTimeMillis() - a) + " ms");
        System.out.println(arr[7000001]);
        System.out.println(arr[4900001]);
    }

    public static void walkArrayTwoThread(){
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float) (arr[i] * Math.sin(0.2f + (i+h) / 5) * Math.cos(0.2f + (i+h) / 5) * Math.cos(0.4f + (i+h) / 2));
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Two Thread " + (System.currentTimeMillis() - a) + " ms");
        System.out.println(arr[7000001]);
        System.out.println(arr[4900001]);
    }

}
