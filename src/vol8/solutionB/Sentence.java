package vol8.solutionB;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Sentence {
    private final List<Word> words;
    private final String punctuation;

    public Sentence(String sentence) {
        String trimmed = sentence.trim().replaceAll("\\s+", " ");
        this.words = Arrays.stream(trimmed.split("[\\s,.!?]+"))
                .filter(w -> !w.isEmpty())
                .map(Word::new)
                .collect(Collectors.toList());
        this.punctuation = sentence.replaceAll(".*[\\w]+", "").trim();
    }

    public List<Word> getWords() {
        return words;
    }

    public boolean isQuestion() {
        return punctuation.contains("?");
    }

    @Override
    public String toString() {
        return words.stream().map(Word::toString).collect(Collectors.joining(" ")) + punctuation;
    }
}
