package lesson9;

public class MyArrayDataException extends Exception {
    String msg;

    public MyArrayDataException(String position) {
        msg = "in MyArrayDataException Exception (NumberFormatException): Illegal " + position;
    }

    public String toString() {
        return msg;
    }
}
