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
}
