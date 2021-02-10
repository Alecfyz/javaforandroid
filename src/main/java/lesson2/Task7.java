package lesson2;

import java.util.Scanner;

public class Task7 {
    public static void main() {
        System.out.println("\nTask 7 - смещение 'элементов внутри массива'. Классная задача!\r\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите смещение (может быть отрицательным):");
        int myShift = scanner.nextInt();
        int[] myArr = {0,1,2,3,4,5,6,7,8,9};

        System.out.println("Исходный массив.");
        flatShowArr(myArr);

        if (myShift > 0) doRightShift(myArr, myShift); else doLeftShift(myArr, myShift);

        System.out.printf("%nМассив со смещением %d:%n", myShift);
        flatShowArr(myArr);
    }

    private static void flatShowArr(int[] myArr){
        for (int el:myArr
        ) {
            System.out.print(el + " ");
        }
        System.out.printf("%n");
    }

    private static void doRightShift(int[] myArr, int myShift){
        int arLen = myArr.length;
        for (int c = 1; c <= myShift; c++) {
            int tempVar = myArr[arLen-1];
            for (int i = arLen - 1; i > 0; i--) myArr[i] = myArr[i - 1];
            myArr[0] = tempVar;
        }
    }

    private static void doLeftShift(int[] myArr, int myShift){
        myShift = Math.abs(myShift);
        int arLen = myArr.length;
        for (int c = 1; c <= myShift; c++) {
            int tempVar = myArr[0];
            for (int i = 0; i < arLen - 1; i++) myArr[i] = myArr[i + 1];
            myArr[arLen - 1] = tempVar;
        }
    }
}
