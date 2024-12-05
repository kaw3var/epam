package vol11.solutionA;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PoemSorter {

    public static List<String> sortPoemLinesByLength(List<String> poemLines) {
        if (poemLines == null) {
            return new ArrayList<>();
        }
        return poemLines.stream()
                .sorted((line1, line2) -> Integer.compare(line1.length(), line2.length()))
                .collect(Collectors.toList());
    }
}
