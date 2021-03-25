package lesson10.homework2;

import java.text.MessageFormat;
import java.util.*;

public class Phonebook {
    protected String phnumber;
    protected String name;
    HashMap<String, String> book;
    HashMap<String, Set<String>> phbook;

    public Phonebook() {
        book = new HashMap<>();
        phbook = new HashMap<>();
    }

    public boolean add(String name, String phnumber) {
        if (name.trim().length() > 2 && phnumber.trim().length() > 3) { // 3 - миннимальное количество знаков в номере телефона. От фонаря; 2 - минимальная длина имени
            book.put(name, phnumber);
        } else {
            return false;
        }
        return true;
    }

    public boolean add2(String name, String num) {
        Set<String> nums;
        if (phbook.containsKey(name)) { // entry present
            nums = phbook.get(name);
        } else {
            nums = new TreeSet<>();
        }
        nums.add(num);

        if (name.trim().length() > 2 && num.trim().length() > 3) { // 3 - миннимальное количество знаков в номере телефона. От фонаря; 2 - минимальная длина имени
            phbook.put(name, nums);
        } else {
            return false;
        }
        return true;
    }

    public String get(String name) {
        Set<String> nums;
        String ret = "Not found!";
        if (phbook.containsKey(name)) { // entry present
            nums = phbook.get(name);
            ret = MessageFormat.format("Для имени: \"{0}\"; найдены номера: {1}", name, nums.toString());
        }
        return ret;
    }

    public void list() {
        System.out.println("=== Содержание ===");
        for (Map.Entry<String, Set<String>> entry : phbook.entrySet()) {
            System.out.println(MessageFormat.format("Имя: \"{0}\"; номера: {1}", entry.getKey(), entry.getValue().toString()));
        }
    }
}
