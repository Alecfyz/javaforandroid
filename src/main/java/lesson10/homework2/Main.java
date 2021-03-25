package lesson10.homework2;


public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        if (!phonebook.add2("Vasya", "123123123"))
            System.out.println("Error till addition.");
        if (!phonebook.add2("Зшеук", "333333"))
            System.out.println("Error till addition.");
        if (!phonebook.add2("Piter", "45445455"))
            System.out.println("Error till addition.");
        if (!phonebook.add2("MrShort", "22")) // короткий номер
            System.out.println("Error till addition.");
        if (!phonebook.add2("Mr", "223333333333")) // короткое имя
            System.out.println("Error till addition.");
        if (!phonebook.add2("Эльза", "123123123"))
            System.out.println("Error till addition.");
        if (!phonebook.add2("Vasya", "999999")) // дубль Вася
            System.out.println("Error till addition.");

        phonebook.list();

        System.out.println();
        System.out.println(phonebook.get("Piter"));
        System.out.println(phonebook.get("Vasya"));

    }


}
