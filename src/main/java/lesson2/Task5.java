package lesson2;

import java.util.Scanner;

public class Task5 {
    public static void main(int[] args) {
        System.out.println("\nTask 5 - найти в нем минимальный и максимальный элементы.'\r\n");

        int cols = args[0];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Максимальное значение элемента массива? ");
        int maxVal = scanner.nextInt();
        maxVal = maxVal < 2 ? 2 : maxVal;

        int[] myArr = new int[cols];
        doFillArray(myArr, maxVal);
        Task2.showMyArr(myArr);

        int[] arrRes = new int[2];

        Task5.getMinMax(myArr, arrRes);
        System.out.println("\r\nmin = " + arrRes[0]);
        System.out.println("max = " + arrRes[1]);

    }


    public static void doFillArray(int[] myArr, int max) {
        for(int i = 0; i < myArr.length; i++){
            myArr[i] = (int)(Math.random() * max);
        }
    }

    private static void getMinMax(int[] myArr, int[] arrRes) {
        int min = myArr[0];
        int max = 0;
        for (int j : myArr) {
            if (j < min) min = j;
            if (j > max) max = j;
        }
        arrRes[0] = min;
        arrRes[1] = max;
    }

}
