package vol8.solutionB;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Paragraph {
    private final List<Sentence> sentences;

    public Paragraph(String paragraph) {
        this.sentences = Arrays.stream(paragraph.split("(?<=[.!?])\\s+"))
                .map(Sentence::new)
                .collect(Collectors.toList());
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        return sentences.stream().map(Sentence::toString).collect(Collectors.joining(" "));
    }
}
