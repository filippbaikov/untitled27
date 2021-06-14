package com.company;

public class Main {


    public static void main(String[] args) {
            secondMethod();
    }


    public static void secondMethod() {
        int size = 10_000_000;
        float[] arr = new float[size];
        float[] leftHalf = new float [size/2];
        float[] rightHalf = new float[size/2];
        System.arraycopy(arr, 0, leftHalf, 0, leftHalf.length);
        System.arraycopy(arr, 5_000_000, rightHalf, 0,rightHalf.length);
        float[] mergedArray = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();

        Thread thread1 =new Thread((Runnable) () -> {

            for (int i = 0; i < leftHalf.length; i++) {
                leftHalf[i] = (int) (leftHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(leftHalf, 0, mergedArray, 0, leftHalf.length);
            System.out.println("1 thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
           // System.out.println(Thread.currentThread().getName());



        });
        Thread thread2 =new Thread((Runnable) () -> {

            for (int i = 0; i < rightHalf.length; i++) {
                rightHalf[i] = (int) (rightHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(rightHalf, 0, mergedArray, 5_000_000, rightHalf.length);
            System.out.println("2 thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
            //System.out.println(Thread.currentThread().getName());

        });

            for (int i = 0; i < mergedArray.length; i++) {
                mergedArray[i] = (int) (mergedArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("3 thread time: " + (System.currentTimeMillis() - startTime) + " ms.");

            System.out.println(Thread.currentThread().getName());
        thread1.start();
        thread2.start();



    }



    }











