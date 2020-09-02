package pl.programodawca.thymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.programodawca.thymeleaf.models.Book;
import java.util.List;

@Transactional
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAll();

}
