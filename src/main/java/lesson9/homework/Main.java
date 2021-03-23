package lesson9.homework;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {
    private static String[][] myArr;
    private static String[] RightSrcArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}; // source array
    private static String[] WrongSrcArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "#"}; // source array
    static final Random random = new Random();
    static final int SIZE = 4; // array side
    static final boolean TEST = false;

    public static void main(String[] args) {
        int summ = 0;
        myArr = generateSquareArray(TEST ? WrongSrcArr : RightSrcArr);
        try {
            summ = workWithArray(myArr);
            System.out.printf("Результат: сумма всех численных элементов массива = %d%n", summ);

        } catch (MyArraySizeException e) {
            System.out.println(e.toString());
        } catch (MyArrayDataException e) {
            System.out.println(e.toString());
        }
    }

    private static int workWithArray(String[][] ar) throws MyArraySizeException, MyArrayDataException {
        if (ar.length > 4)
            throw new MyArraySizeException(ar.length);

        int holeSumm = 0;
        int curInt = 0;

        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                if (j > 3)
                    throw new MyArraySizeException(i);

                try {
                    curInt = Integer.parseInt(String.valueOf(ar[i][j]));
                } catch (NumberFormatException e1) {
                    curInt = 0;
                    throw new MyArrayDataException("строка '" + ar[i][j] + "' в позиции " + i + "," + j);
                }
                holeSumm += curInt;
            }
        }
        return holeSumm;
    }

    private static String[][] generateSquareArray(String[] srcArr) {
        myArr = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                myArr[i][j] = srcArr[random.nextInt(srcArr.length)];
            }
        }
        Arrays.stream(myArr).map(Arrays::toString).forEach(System.out::println);
        return myArr;
    }

}

