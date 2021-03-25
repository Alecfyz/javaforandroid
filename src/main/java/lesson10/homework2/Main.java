package lesson10.homework2;


public class Main {
    public static void main(String[] args) {
        String errAddMess = "Error till adding.";
        Phonebook phonebook = new Phonebook();
        if (!phonebook.add("Vasya", "123123123"))
            System.out.println(errAddMess);
        if (!phonebook.add("Зшеук", "333333"))
            System.out.println(errAddMess);
        if (!phonebook.add("Piter", "45445455"))
            System.out.println(errAddMess);
        if (!phonebook.add("MrShort", "22")) // короткий номер
            System.out.println(errAddMess);
        if (!phonebook.add("Mr", "223333333333")) // короткое имя
            System.out.println(errAddMess);
        if (!phonebook.add("Эльза", "123123123"))
            System.out.println(errAddMess);
        if (!phonebook.add("Vasya", "999999")) // дубль Вася
            System.out.println(errAddMess);

        phonebook.list();

        System.out.println();
        System.out.println(phonebook.get("Piter"));
        System.out.println(phonebook.get("Vasya"));

    }


}
