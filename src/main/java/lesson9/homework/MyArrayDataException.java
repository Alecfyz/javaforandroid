package lesson9.homework;

public class MyArrayDataException extends NumberFormatException {
    static String msg;

    public MyArrayDataException(String details) {
        msg = "Исключение (NumberFormatException): недопустимая " + details;
    }

    public String toString() {
        return msg;
    }
}
