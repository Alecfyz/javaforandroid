package Lesson3;

import java.util.Scanner;

public class HomeWork3 {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String word = words[GetRandomEl(words)];
        System.out.println("word = '" + word + "'");
        System.out.println("О, повелитель, отгадай фрукт, загаданный Шахразадой!");
        String userword;
        boolean matched = false;
        while(!matched) {
            userword = getUserWord();

            if (userword.equals(word)) {  // FALSE!!!
                System.out.printf("Да! Ты отгадал, о свет моих очей! Это слово '%s'!%n Сказка и вопросы на сегодня закончены, повелитель!", word);
                matched = true;
                break;
            } else {
                System.out.println("Нет, продолжаем");
                showCompareWords(word, userword);
            }
        }

    }

    private static int GetRandomEl(String[] words) {
        return (int) (Math.random() * words.length);
    }

    private static String getUserWord() {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
//        scanner.close();
        return s1;
    }

    private static void showCompareWords(String word, String userword) {
        String masked = "";
        int maxLen = Math.min(word.length(), userword.length());
        int guessed = 0;
        for (int i = 0; i < maxLen; i++) {
            if (word.charAt(i) == userword.charAt(i)) {
                masked += word.charAt(i);
                guessed++;
            } else masked +="#";
        }
        for (int j = maxLen; j < 15; j++) { masked += "#"; }
        System.out.printf("Всего вы угадали %d букв из этого слова %n и вот эти буквы: %s%nПопробуй еще раз, светлейший!%n", guessed, masked);
    }

}
