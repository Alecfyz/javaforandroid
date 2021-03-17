package lesson7.oop;

import java.util.Random;

public class Cat {
    private String name;
    private Random random = new Random();
    private int appetite;
    private boolean fullness = false; // признак насыщенности
    private int Allfullness; // максимальная насыщенность
    private int curfullness = 0; // текущая насыщенность


    public Cat(String name, int appetite, int Allfullness) {
        this.name = name;
        this.appetite = appetite;
        this.Allfullness = Allfullness;
    }

    public Cat(String name) {
        this(name, 10, 20);
    }

    public boolean eat(Plate plate) {
        if (this.fullness) {
            System.out.printf("%s сыт и не будет больше кушать!%n", this.name);
            return true;
        }
        int nowEat = random.nextInt(appetite)+1;
        boolean b = plate.decreaseFood(nowEat);
        if(b) {
            System.out.printf("%s покушал на %d, хотя аппетит у него %d.%nУровень сытости %d из %d%n", name, nowEat, appetite, curfullness, Allfullness );
            curfullness += nowEat;
            if (curfullness >= Allfullness)
            {
                fullness = true;
                System.out.printf("%s наелся досыта!%n", this.name);
            }
        }
        return b;
    }

    public String getName() {
        return this.name;
    }

    public int getAppetite() {
        return this.appetite;
    }
}
