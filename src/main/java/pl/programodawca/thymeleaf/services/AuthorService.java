package pl.programodawca.thymeleaf.services;

import org.springframework.beans.factory.annotation.Autowired;
import pl.programodawca.thymeleaf.dtos.BookDto;
import pl.programodawca.thymeleaf.models.Author;
import pl.programodawca.thymeleaf.repositories.AuthorRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    List<Author> authors = authorRepository.findAll();

    public Set<Author> add(BookDto bookDto) {
        Set<Author> newAuthors = new HashSet<>(authorRepository.findAllByFirstNameAndLastName(bookDto.getAuthors()));

    }
}
