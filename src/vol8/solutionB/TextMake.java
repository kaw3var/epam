package vol8.solutionB;

import java.util.*;
import java.util.stream.Collectors;

public class TextMake {
    private final List<Paragraph> paragraphs;

    public TextMake(String text) {
        text = text.replaceAll("\\t+", " ").replaceAll(" +", " ");
        this.paragraphs = Arrays.stream(text.split("\\n\\s*\\n"))
                .map(Paragraph::new)
                .collect(Collectors.toList());
    }

    public Set<Word> findWordsInQuestionsByLength(int length) {
        return paragraphs.stream()
                .flatMap(paragraph -> paragraph.getSentences().stream())
                .filter(Sentence::isQuestion)
                .flatMap(sentence -> sentence.getWords().stream())
                .filter(word -> word.getValue().length() == length)
                .collect(Collectors.toSet());
    }

    public void printProcessedText() {
        paragraphs.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = """
                Что было написано на лице Пола в его последние мгновения? Он не улыбался. Он не выглядел удовлетворённым.
                Однако на его лице читалось явное облегчение. О чём он хотел сказать перед смертью? Какие лица были у моих прошлых родителей,
                когда они умерли? Почему? Почему я не пошёл увидеть их?
                """;

        TextMake make = new TextMake(text);
        System.out.print("Введите длину слова: ");
        int wordLength = scanner.nextInt();;

        System.out.println("Исходный текст:");
        make.printProcessedText();

        Set<Word> result = make.findWordsInQuestionsByLength(wordLength);
        System.out.println("\nСлова длиной " + wordLength + " символов в вопросительных предложениях:");
        result.forEach(System.out::println);
    }
}
