package pl.programodawca.thymeleaf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.programodawca.thymeleaf.dtos.AuthorDto;
import pl.programodawca.thymeleaf.dtos.BookDto;
import pl.programodawca.thymeleaf.models.Author;
import pl.programodawca.thymeleaf.repositories.AuthorRepository;
import pl.programodawca.thymeleaf.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public List<AuthorDto> getAll() {
        List<Author> all = authorRepository.findAll();
        return all.stream().map(this::mapAuthors).collect(Collectors.toList());
    }

    public List<Author> add(BookDto bookDto) {
        List<Author> authors = new ArrayList<>();
        for (Author author : bookDto.getAuthors()
        ) {
            authors.add(author);
        }
        authorRepository.saveAll(authors);
        return authors;
        }



    private AuthorDto mapAuthors(Author author) {
        AuthorDto dto = new AuthorDto();
        dto.setId(author.getId());
        dto.setFirstName(author.getFirstName());
        dto.setLastName(author.getLastName());
        dto.setBooks(author.getBooks());
        return dto;
    }

}

