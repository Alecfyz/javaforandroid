package lesson11.homework3;

public class Main {
    public static void main(String[] args) {
        Orange or1 = new Orange();
        Orange or2 = new Orange();
        Orange or3 = new Orange();

        Apple ap1 = new Apple();
        Apple ap2 = new Apple();
        Apple ap3 = new Apple();

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        appleBox.add(ap1);
        appleBox.add(ap2);
        appleBox.add(ap3); // 3

//        appleBox.add(or1); // не пройдет

        orangeBox.add(or1);
        orangeBox.add(or2);
        orangeBox.add(or3); // 3

        System.out.print("Вес первой коробки c яблоками = " + appleBox.getBoxWeight());
        System.out.println(" Количество фруктов в коробке " + appleBox.getItemsCount());
        System.out.print("Вес второй коробки c яблоками = " + orangeBox.getBoxWeight());
        System.out.println(" Количество фруктов в коробке " + appleBox.getItemsCount());

        System.out.println(appleBox.compare(orangeBox) ? "Коробки весят одинаково" : "Вес коробок разный");
        System.out.println("=-=-=-");

        Box<Apple> appleBox1 = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();

        appleBox.emptyTo(appleBox1);
//        orangeBox.emptyTo(appleBox1);

        System.out.print("Вес первой коробки c яблоками = " + appleBox.getBoxWeight());
        System.out.println(" Количество фруктов в коробке " + appleBox.getItemsCount());
        System.out.print("Вес первой коробки c апельсинами = " + orangeBox.getBoxWeight());
        System.out.println(" Количество фруктов в коробке " + orangeBox.getItemsCount());

        System.out.print("Вес второй коробки c яблоками = " + appleBox1.getBoxWeight());
        System.out.println(" Количество фруктов в коробке " + appleBox1.getItemsCount());
        System.out.print("Вес второй коробки c апельсинами = " + orangeBox1.getBoxWeight());
        System.out.println(" Количество фруктов в коробке " + orangeBox1.getItemsCount());

        System.out.println(appleBox1.toString());
    }


}
