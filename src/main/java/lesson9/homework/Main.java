package lesson9.homework;

import java.util.Random;

public class Main {
    private static String[][] myArr;
    private static String[] srcArr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "$", "&", "@", "*", "dsa", " "}; // source array
    static final Random random = new Random();
    static final int SIZE = 6; // array side

    public static void main(String[] args) {
        int summ;
        myArr = generateSquareArray();

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
        if (row > SIZE-1)
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

    private static String[][] generateSquareArray() {
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

