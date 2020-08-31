package pl.programodawca.thymeleaf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.programodawca.thymeleaf.dtos.BookDto;
import pl.programodawca.thymeleaf.models.Author;
import pl.programodawca.thymeleaf.models.Book;
import pl.programodawca.thymeleaf.repositories.BookRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDto> getAll() {
        List<Book> all = bookRepository.findAll();
        return all.stream().map(this::mapBooks).collect(Collectors.toList());
    }

    public Book newBook(BookDto bookDto) {
        Set<Author> authors = AuthorService.add(bookDto);

        Book book = new Book();
    }

    private BookDto mapBooks(Book book) {
        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthors(book.getAuthors());
        dto.setPublisher(book.getPublisher());
        return dto;
    }
}
