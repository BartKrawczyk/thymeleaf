package pl.programodawca.thymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.programodawca.thymeleaf.models.Author;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAll();

    Optional<Author> findById(Long id);

    Set<Author> findAllById(Set<Author> authors);

    Set<Author> findAllByFirstNameAndLastName(Set<Author> authors);

}
