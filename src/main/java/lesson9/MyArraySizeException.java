package lesson9;

public class MyArraySizeException extends IndexOutOfBoundsException {
    public MyArraySizeException() {
//        System.out.println("in ScrayException: " );
    }

    public String toString() {
        return "                              Exception! Each side of array is not eq. 4!";
    }
}
