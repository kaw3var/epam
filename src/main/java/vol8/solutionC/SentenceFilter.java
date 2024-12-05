package vol8.solutionC;

import java.util.*;

public class SentenceFilter {
    public static List<String> minimizeSentences(String text) {
        if (text.isEmpty()) {
            return new ArrayList<>();
        }
        // Разделение текста на предложения
        String[] sentences = text.split("\\.\\s*");
        List<Set<String>> wordsInSentences = new ArrayList<>();

        // Преобразуем каждое предложение в набор слов
        for (String sentence : sentences) {
            Set<String> words = new HashSet<>();
            String[] wordsArray = sentence.toLowerCase().split("[^a-zа-яё]+");  // Учитываем только буквы
            for (String word : wordsArray) {
                if (!word.isEmpty()) {
                    words.add(word);  // Добавляем слово в набор
                }
            }
            wordsInSentences.add(words);
        }

        // Множество для хранения индексов предложений которые нужно оставить
        Set<Integer> keepIndices = new HashSet<>();
        keepIndices.add(0);  // Первое предложение всегда оставляем

        // Перебираем остальные предложения и пытаемся найти общее слово
        for (int i = 1; i < sentences.length; i++) {
            Set<String> sentenceWords = wordsInSentences.get(i);
            boolean hasCommonWord = false;
            // Проверяем пересечение текущего предложения с уже оставленными
            for (int index : keepIndices) {
                if (!Collections.disjoint(sentenceWords, wordsInSentences.get(index))) {
                    hasCommonWord = true;
                    break;  // Если нашли хотя бы одно общее слово, оставляем это предложение
                }
            }
            if (hasCommonWord) {
                keepIndices.add(i);  // Пересечение - оставляем это предложение
            }
        }

        // Готовый список предложений
        List<String> result = new ArrayList<>();
        for (int i = 0; i < sentences.length; i++) {
            if (keepIndices.contains(i)) {
                result.add(sentences[i] + ".");
            }
        }

        return result;
    }
}
