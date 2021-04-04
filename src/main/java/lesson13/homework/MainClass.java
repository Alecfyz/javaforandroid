package lesson13.homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
    static final int CARS_COUNT = 4;
    static final CyclicBarrier cbStart = new CyclicBarrier(CARS_COUNT);
    static final CountDownLatch cdlForStart = new CountDownLatch(CARS_COUNT);
    static final CountDownLatch cdlForFinish = new CountDownLatch(CARS_COUNT);
    static ArrayList<String> winners = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(80), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            final int randomSpeed = 20 + (int) (Math.random() * 10);
            cars[i] = new Car(race, randomSpeed);
        }

        for (Car car : cars) {
            new Thread(car).start();
        }
        cdlForStart.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        cdlForFinish.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        System.out.printf("%nТаблица победителей:%n");

        for (int i = 0; i < winners.size(); i++) {
            System.out.printf("%d место занял %s%n", i + 1, winners.get(i));
        }
    }
}
