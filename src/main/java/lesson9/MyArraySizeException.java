package lesson9;

public class MyArraySizeException extends Exception  {
    static int size;
    public MyArraySizeException(int s) {
        size = s;
    }

    public String toString() {
        return "                              Exception! Each side of array is _" + size + "_ and it not eq. 4!";
    }
}
