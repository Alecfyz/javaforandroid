package lesson7.oop;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int countFoods) {
        if (food >= countFoods) {
           food -= countFoods;
            return true;
        } else return false;
    }

    public void printInfo() {
        System.out.println("Кол-во еды в миске: " + food);
    }

    public int getFood() {
        return food;
    }

    public void increaseFood(int howMany)
    {
        this.food += howMany;
        System.out.printf("%n-=-=-=-%nПришла добрая мамочка и подсыпала %d еды в тарелку!%nТеперь еды аж %d!%n-=-=-=-%n", howMany, this.food);
    }
}
