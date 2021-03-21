package lesson8.homework;

public interface Jumping {

    default int jump(int wallH) {
        return 0;
    }
}
