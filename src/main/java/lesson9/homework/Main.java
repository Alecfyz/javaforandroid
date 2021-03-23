package lesson9.homework;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {
    private static String[][] myArr;
    private static String[] srcArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "$", "&", "@", "*", "dsa", " "}; // source array
    static final Random random = new Random();
    static final int SIZE = 6; // array side

    public static void main(String[] args) {
        int summ;
        myArr = generateSquareArray(false);

        summ = workWithArray(myArr);
        System.out.printf("Результат: сумма всех численных элементов массива = %d%n", summ);
    }

    private static int workWithArray(String[][] ar) {
        int holeSumm = 0;
        int curInt;

        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                curInt = 0;
                try {
                    curInt = getNextInt(ar[i][j], i, j);
                } catch (MyArraySizeException e2) {
                    System.err.println(e2);
                    break; // элементы сверх лимита (4) не считаем
                } catch (MyArrayDataException e1) {
                    System.err.println(e1);
                }
                holeSumm += curInt;
            }
        }
        return holeSumm;
    }

    private static int getNextInt(String str, int row, int col) throws MyArraySizeException, MyArrayDataException {
        if (col > 4)
            throw new MyArraySizeException(row);

        int curint;
        try {
            curint = Integer.parseInt(String.valueOf(str));
        } catch (NumberFormatException e1) {
            curint = 0;
            throw new MyArrayDataException("строка '" + str + "' в позиции " + row + "," + col);
        }
        return curint;
    }

    private static String[][] generateSquareArray(boolean test) {
        if (test) {
            String[][] myArr = {
                    {"3", "3", "3", "@", "4", "0"},
                    {"3", "$", "&", "4", "dsa", "2"},
                    {"$", "0", "3", "5", " ", "0"},
                    {"8", "0", "4", "2", "&", " "},
                    {"1", "$", "2", "5", "8", "9"},
                    {"@", "9", "5", "9", "1", "3"}
            };
            Arrays.stream(myArr).map(Arrays::toString).forEach(System.out::println);
            return myArr;
        }

        myArr = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                myArr[i][j] = srcArr[random.nextInt(srcArr.length)];
//                System.out.printf("\"%s\",", myArr[i][j]);
            }
//            System.out.printf("%n");
        }
        Arrays.stream(myArr).map(Arrays::toString).forEach(System.out::println);

        return myArr;
    }

}

