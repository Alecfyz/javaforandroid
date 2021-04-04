package lesson13.homework;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private static CyclicBarrier cbStart;
    private static CountDownLatch cdlForStart;
    private static CountDownLatch cdlForFinish;
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String ANSI_RESET = "\u001B[0m";

    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    static {
        cbStart = MainClass.cbStart;
        cdlForStart = MainClass.cdlForStart;
        cdlForFinish = MainClass.cdlForFinish;
    }

    String getName() {
        return name;
    }

    int getSpeed() {
        return speed;
    }

    Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            cdlForStart.countDown();
            System.out.println(this.name + " готов");
            cbStart.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        final ArrayList<Stage> stages = race.getStages();
        for (Stage stage : stages) {
            stage.go(this);
        }
        cdlForFinish.countDown();

        try {
            lock.writeLock().lock();
            if (MainClass.winners.size() == 0) System.out.println("\n" + RED_BOLD + this.getName() + " is WINNER!" + ANSI_RESET + "\n");
            MainClass.winners.add(this.getName());
        } finally {
            lock.writeLock().unlock();
        }
    }
}
