package lesson2;

public class Task6 {
    public static void main(int[] args) {
        System.out.println("\nTask 6 - метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.\r\n");
        int cols = args[0];
        int maxVal = 3;

        int[] myArr = new int[cols];
        Task5.doFillArray(myArr, maxVal);
        Task2.showMyArr(myArr);
        System.out.printf("%n");
        System.out.println("Check result is: there" + (checkArrayTask6(myArr) ? " IS " : " is NOT ") + "equal parts.");
    }

    private static boolean checkArrayTask6(int[] myArr){
        int arLen = myArr.length;
        int curPosition = 1;

        boolean isEqual = false;

        do {
            int leftSum = 0;
            int rightSum = 0;
            for (int i = 0; i < curPosition; i++) leftSum += myArr[i];
            for (int j = curPosition; j < arLen; j++) rightSum += myArr[j];
            isEqual = (leftSum == rightSum);
//            System.out.printf("CurPosition = %d; leftSum = %d; rightSum = %d; sumIsEqual: %s%n", curPosition, leftSum, rightSum, isEqual);
            if (isEqual) break;
            curPosition++;
        } while (curPosition < arLen-1);
        return isEqual;
    }
}
