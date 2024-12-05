package vol8;

import vol8.solutionB.*;
import static vol8.solutionA.StringInsert.insertSubstring;
import static vol8.solutionC.SentenceFilter.minimizeSentences;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текст: ");
        String text = scanner.nextLine();

        System.out.print("Введите подстроку для вставки: ");
        String substring = scanner.nextLine();

        System.out.print("Введите позицию k: ");
        int k = scanner.nextInt();

        try {
            String result = insertSubstring(text, k, substring);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        // vol8.solutionB

        String text2 = "Что было написано на лице Пола в его последние мгновения? Он не улыбался. Он не выглядел удовлетворённым. " +
                "Однако на его лице читалось явное облегчение. О чём он хотел сказать перед смертью? Какие лица были у моих прошлых родителей, " +
                "когда они умерли? Почему? Почему я не пошёл увидеть их? ";

        TextMake make = new TextMake(text2);
        System.out.print("Введите длину слова: ");
        int wordLength = scanner.nextInt();

        System.out.println("Исходный текст:");
        make.printProcessedText();

        Set<Word> result = make.findWordsInQuestionsByLength(wordLength);
        System.out.println("\nСлова длиной " + wordLength + " символов в вопросительных предложениях:");
        result.forEach(System.out::println);

        System.out.println("\n\n");
        // vol8.solutionC

        String text3 = "Вчера я видел интересный фильм. Фильм был очень увлекательным. " +
                "Мы с друзьями поехали в парк. Погода была замечательная. Вечером мы пошли в кино на новый фильм.";

        List<String> minimizedText = minimizeSentences(text3);

        System.out.println("Оставшиеся предложения:");
        for (String sentence : minimizedText) {
            System.out.println(sentence);
        }
    }
}
