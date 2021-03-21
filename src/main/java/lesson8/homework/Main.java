package lesson8.homework;

public class Main {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Tigra", 15, 3);
        Cat cat2 = new Cat("Kasmo");

        Human hum1 = new Human("Ivan", 20, 2);
        Human hum2 = new Human("Petro", 10, 3);
        Human hum3 = new Human("John");

        Robot robot1 = new Robot("Robozilla");
        Robot robot2 = new Robot("Robokong");

        Racetrack racetrack = new Racetrack(20);
        Wall wall = new Wall(3);


        Sporting[] sportings = {cat1, cat2, hum1, hum2, hum3, robot1, robot2};


        for (Sporting sporting : sportings) {
            if (!sporting.isdisqalified()) {
                if (!wall.doPassTheWall(sporting)) {
                    sporting.disq();
                    System.out.printf("Дисквалифицирован!%n======%n%n");
                } else {
                    System.out.printf("%n======%n%n");
                }
            }
            if (!sporting.isdisqalified()) {
                if (!racetrack.doRunTheTrack(sporting)) {
                    sporting.disq();
                    System.out.printf("Дисквалифицирован!%n======%n%n");
                } else {
                    System.out.printf("%n======%n%n");
                }
            }
        }

        System.out.println("Итого до финиша добрались:");
        for (Sporting sporting : sportings) {
            if (!sporting.isdisqalified()) {
                System.out.println(sporting.getnam());
            }
        }
    }
}


