package Lesson3;

import java.util.Scanner;

public class HomeWork3 {

    static Scanner scanner = new Scanner(System.in);
    static String masked = "###############";
    static boolean matched = false;

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String word = words[GetRandomEl(words)];
        System.out.println("word = '" + word + "'");
        System.out.println("О, повелитель, отгадай фрукт, загаданный Шахразадой!");
        String userword;

        while(!matched) {
            userword = getUserWord();
            if (userword.equals(word)) {
                System.out.printf("Да! Ты отгадал, о свет моих очей! Это слово '%s'!%n Сказка и вопросы на сегодня закончены, повелитель!", word);
                matched = true;
                break;
            } else {
                showCompareWords(word, userword);
            }
        }
    }

    private static int GetRandomEl(String[] words) {
        return (int) (Math.random() * words.length);
    }

    private static String getUserWord() {
        return scanner.nextLine();
    }

    private static void showCompareWords(String word, String userword) {
        String workmask = "";
        int maxLen = Math.min(word.length(), userword.length());
        int guessed = 0;
        for (int i = 0; i < maxLen; i++) {

            if (masked.charAt(i) == word.charAt(i))
            {
                workmask += masked.charAt(i);
//                System.out.println("!!!! " + word.charAt(i)  + " !!!!!!");
                guessed++;
            } else if (word.charAt(i) == userword.charAt(i)) {

                workmask += word.charAt(i);
                guessed++;
            } else workmask +="#";
        }
        masked = workmask;
        if (masked.equals(word)){
            matched = true;
            System.out.printf("Да! Ты усерден, о дыхание моего ветра, и по буквам составил это слово: '%s'!%n Сказка и вопросы на сегодня закончены, повелитель!", word);
            return;
        }
        for (int j = maxLen; j < 15; j++) { masked += "#"; }
        System.out.printf("Всего вы угадали %d букв(ы) из этого слова %n и вот эти буквы: %s%nПопробуй еще раз, светлейший!%n", guessed, masked);
    }

}
