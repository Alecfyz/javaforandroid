package lesson8.homework;

public class Racetrack {
    private int lenght;

    public Racetrack(int lenght) {
        this.lenght = lenght;
    }

    public int getLenght() {
        return lenght;
    }

    public boolean doRunTheTrack(Sporting obj) {
        int curRun = obj.run(this.lenght);
//        System.out.printf("Участник из семейства `%s` под именем %s прыгает через стену высотой %dм.%nРезультат: прыг на %dм.", sportyType, name, lenght, curJump);
        if (lenght <= curRun) {
            System.out.printf("%nДобежал! Молодец!");
            return true;
        } else {
            System.out.printf("%nНе добежал...");
            return false;
        }
    }

}
