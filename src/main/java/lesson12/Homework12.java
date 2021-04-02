package lesson12;

import java.util.Arrays;

public class Homework12 {
    static final int SIZE = 10000000;
//    static final int SIZE = 10;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        float[] arr1 = Arrays.copyOfRange(arr, 0, HALF);
        float[] arr2 = Arrays.copyOfRange(arr, HALF, SIZE);

        inOneThread(arr1, arr2);
        inTwoThreads(arr1, arr2);
    }

    public static void inOneThread(float[] arr1, float[] arr2) {
        System.out.println("Запуск в одном потоке Main");
        long startTime = System.currentTimeMillis();
        calculate(arr1, 0);
        calculate(arr2, HALF);
        System.out.println("Время выполнения " + (System.currentTimeMillis() - startTime) + "мс");
    }

    public static void inTwoThreads(float[] arr1, float[] arr2) {
        System.out.println("Запуск в двух потоках");
        long startTime = System.currentTimeMillis();
        var t1 = new Thread(() -> calculate(arr1, 0), "FirstThread");
        var t2 = new Thread(() -> calculate(arr2, HALF), "SecondThread");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Время выполнения " + (System.currentTimeMillis() - startTime) + "мс");
    }

    public static void calculate(float[] halfarr, int startindex) {
        for (int i = 0; i < HALF; i++) {
            float index = i + startindex;
            int l = halfarr.length;
            halfarr[i] = (float) (halfarr[i] * Math.sin(0.2f + index / 5) * Math.cos(0.2f + index / 5) * Math.cos(0.4f + index / 2));
        }
    }
}


