package lesson6;

import java.awt.*;

public class Main extends Object {
    public static void main(String[] args) {


    Cat catMurza = new Cat("Мурзик");
    Cat catSkrebok = new Cat("Skrebok");
    Cat catShushpan = new Cat("Шушпан");
    Dog dogShar = new Dog("Шарик", "fiftypercentofgray", 5, true);
    Dog dogKub = new Dog("Кубик", "вывыв", 2, true);

    catMurza.doRun(20);
    catMurza.doRun(120);
    catMurza.doRun(220);

    catSkrebok.doSweem(22);
        System.out.printf("%n");

        dogKub.doRun(550);
        dogKub.doRun(350);
        dogShar.doRun(79);
        System.out.printf("%n");

        dogShar.doSweem(2);
        dogShar.doSweem(20);
        dogKub.doSweem(9);

        Animal.showAllAnimals();

//    catMurza.printInfo();
//    dogShar.printInfo();

//    Cat[] cats = {cat};
//    Dog[]  dogs = {dog}
//    Animal[] animals =

    }
}
