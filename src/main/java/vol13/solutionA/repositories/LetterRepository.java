package vol13.solutionA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vol13.solutionA.Letter;

public interface LetterRepository extends JpaRepository<Letter, Integer> {
}
