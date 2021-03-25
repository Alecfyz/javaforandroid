package lesson10.homework1;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> AllWords = new ArrayList<>();
        try {
            AllWords = getWords();
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashSet<String> uniq = new HashSet(AllWords); // unique words in "uniq"
        System.out.printf("\n === Всего уникальных слов: %d ===\n\n", uniq.size());
        Map<String, Integer> map = new LinkedHashMap<>();

        // Скопируем уникальные слова в MAP - сделаем их клчюами
        for (String word : AllWords) {
            int c;
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        Map<Integer, String> treemap = new TreeMap<>(Collections.reverseOrder());

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            treemap.put(entry.getValue(), entry.getKey());
        }

        System.out.println("--===== Топ-20 повторяющихся ====--");
        int i = 0;
        for (Map.Entry<Integer, String> entry : treemap.entrySet()) {
            if (i > 20) break;
            System.out.println(MessageFormat.format("слово \"{0}\", повторяется {1} раз", entry.getValue(), entry.getKey()));
            i++;

        }


    }


    public static ArrayList<String> getWords() throws IOException {
        Scanner scanner = new Scanner(new File("src/main/java/lesson10/homework1/dogsheart.txt"));
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.trim().equals("")) {
                lines.add(line);
            }
        }

        String[] arr = lines.toArray(new String[0]);
        ArrayList<String> ALLwords = new ArrayList<>();
        for (String string : arr) {
            String[] words = string.split("\\s+");
            for (String w : words) {
                w = w.replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", "").trim();
                if (!w.equals("")) {
                    ALLwords.add(w.toLowerCase());
                }
            }
        }
        System.out.println("Все слова (не уникальные), приведенные в LC, без знаков перпинания, пробелов и пр.");
        System.out.println(ALLwords.toString());
        System.out.printf("--==== Всего не уникальных слов %d ====--%n", ALLwords.size());
        ALLwords.trimToSize();
        return ALLwords;
    }

}