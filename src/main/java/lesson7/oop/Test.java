package lesson7.oop;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat("Martin");
        Cat cat2 = new Cat("Katrin", 3, 15);
        Cat cat3 = new Cat("Durtin", 9, 30);

        Plate plate = new Plate(50);
        Cat[] cats = {cat, cat2, cat3};

        while (plate.getFood() > 0) {
            for (Cat kitty: cats)
                  {
                      plate.printInfo();
                        if (!kitty.eat(plate)) {

                            System.out.printf("Кот %s говорит: не могу покушать! Хочу съесть %d, а в тарелке еды всего %d.%n", kitty.getName(), kitty.getAppetite(), plate.getFood());
                                        Thread.sleep(1000);
//                            break;
                        }
                        if (plate.getFood() < 1) break;
                  }
            mannaSnebes(plate);


            System.out.println();
        }
    }

    private static void mannaSnebes( Plate plate) {
        int rand = (int) (Math.random() * 5);
        if (rand >= 3) {
        plate.increaseFood(rand); //для простоты
        }
    }
}