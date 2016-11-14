package lessons.lesson5;

import java.util.Arrays;

public class ThreadArrays {

    public static void main(String[] args) {
        System.out.println(Arrays.equals(fillFullArray(), concurrentFillArray()));
    }

    public static float[] fillFullArray() {

        long start = System.currentTimeMillis();

        final int size = 10000000;
        float[] arr = new float[size];
        for (float val : arr) {
            val = 1f;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println(System.currentTimeMillis() - start + " ms");

        return arr;

    }

    public static float[] concurrentFillArray() {

        long start = System.currentTimeMillis();

        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        float[] arrHalf1 = new float[h];
        float[] arrHalf2 = new float[h];

        for (float val : arr) {
            val = 1;
        }

        Thread thread1 = new Thread(() -> {
            System.arraycopy(arr, 0, arrHalf1, 0, h);
            for (int i = 0; i < arrHalf1.length; i++) {
                arrHalf1[i] = (float)(arrHalf1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            System.arraycopy(arr, h, arrHalf2, 0, h);
            for (int i = 0, j = h; i < arrHalf2.length; i++, j++) {
                arrHalf2[i] = (float)(arrHalf2[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
            }
        });
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arrHalf1, 0, arr, 0, h - 1);
        System.arraycopy(arrHalf2, 0, arr, h, h);
        System.out.println(System.currentTimeMillis() - start + " ms");

        return arr;

    }


}
