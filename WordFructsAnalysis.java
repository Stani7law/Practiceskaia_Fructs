import java.io.*;
import java.util.*;

public class WordFructsAnalysis {
    public static void main(String[] args) {
        try {
            // Чтение файла
            BufferedReader reader = new BufferedReader(new FileReader("Input.txt"));
            List<String> words = new ArrayList<>();
            String line;

            // Чтение файла построчно и добавление слов в список
            while ((line = reader.readLine()) != null) {
                words.addAll(Arrays.asList(line.split(" ")));
            }

            // 1. Подсчет количества слов
            int wordCount = words.size();
            System.out.println("Общее количество слов: " + wordCount);

            // 2. Поиск самого длинного слова
            String longestWord = "";
            for (String word : words) {
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
            System.out.println("Самое длинное слово: " + longestWord);

            // 3. Вычисление частоты слов
            Map<String, Integer> wordFrequency = new HashMap<>();
            for (String word : words) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }

            System.out.println("Частота слов:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}