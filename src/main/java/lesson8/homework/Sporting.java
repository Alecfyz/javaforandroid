package lesson8.homework;

public interface Sporting extends Jumping, Running {
    default void disq() {
    }

    default boolean isdisqalified() {
        return false;
    }

    default String getnam() {
        return "";
    }
}


