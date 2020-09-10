package pl.programodawca.thymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.programodawca.thymeleaf.models.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAll();
}
