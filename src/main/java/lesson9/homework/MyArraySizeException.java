package lesson9.homework;

public class MyArraySizeException extends Exception  {
    static int size;
    public MyArraySizeException(int s) {
        size = s;
    }

    public String toString() {
        return "                              Exception! Side of square array is _" + size + "_ and it is not eq. 4!";
    }
}
