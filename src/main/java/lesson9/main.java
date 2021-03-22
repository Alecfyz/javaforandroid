package lesson9;

import java.lang.reflect.Array;
import java.util.Random;

public class main {
    private static String[][] myArr;
    private static String[] srcArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "$", "&", "@", "*", "dsa", " "}; // source array
    static final Random random = new Random();
    static final int SIZE = 6; // array side

    public static void main(String[] args) {
        myArr = generateSquadArray();

        int summ = workWithArray(myArr);

        System.out.printf("Результат: сумма всех численных элементов массива = %d", summ);
    }

    private static int workWithArray(String[][] ar) {
        int holeSumm = 0;
        try {
            if (ar.length > 4)
                throw new MyArraySizeException();
        } catch (MyArraySizeException e) {
            System.out.printf("%n=-=-=%n%s%n=-=-=%n", e);
        }
        finally {
            System.out.printf("%nРазмерность массива: %dх%d.%n==============%n", ar.length, ar[0].length);
        }

        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                try {
                    if (!isNumeric(ar[i][j]))
                        throw new MyArrayDataException("string " + ar[i][j] + " at position " + i + "," + j);

                    holeSumm += Integer.parseInt(ar[i][j]);

                } catch (MyArrayDataException e1) {
                    System.out.println(e1.toString());

                }

            }
        }
        return holeSumm;
    }

    private static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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
