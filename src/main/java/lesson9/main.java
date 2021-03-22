package lesson9;

import java.lang.reflect.Array;
import java.util.Random;

public class main {
    private static String[][] myArr;
    private static String[] srcArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "$", "&", "@", "*", "dsa", " "}; // source array
    static final Random random = new Random();
    static final int SIZE = 5; // array side

    public static void main(String[] args) {
        int summ = 0;
        myArr = generateSquadArray();

        summ = workWithArray(myArr);
        System.out.printf("Результат: сумма всех численных элементов массива = %d%n", summ);
    }


    private static int workWithArray(String[][] ar) {
        int holeSumm = 0;
        int curInt;
        String errPoints = "";

        try {
            checkArr(ar);
        } catch (MyArraySizeException e) {
            System.err.printf("%n=-=-=%n%s%n=-=-=%n", e.toString());
        }

        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                curInt = 0;
                try {
                    curInt = getInt(ar[i][j], i, j);
                } catch (MyArrayDataException e1) {
                    System.err.println(e1);
                }
                holeSumm += curInt;
            }
        }
        return holeSumm;
    }

    private static void checkArr(String[][] ar) throws MyArraySizeException {
        if (ar.length > 4)
            throw new MyArraySizeException(ar.length);
    }

    private static int getInt(String subj, int i, int j) throws MyArrayDataException {
        int curint = 0;
        try {
            curint = Integer.parseInt(String.valueOf(subj));
        } catch (NumberFormatException e1) {
            throw new MyArrayDataException("строка '" + subj + "' в  позиции " + i + "," + j);
        }
        return curint;
    }

    private static String[][] generateSquadArray() {
        myArr = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                myArr[i][j] = srcArr[random.nextInt(srcArr.length)];
                System.out.printf("%s", myArr[i][j]);
            }
            System.out.printf("%n");
        }
        return myArr;
    }

}

