package vol13.solutionA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vol13.solutionA.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
