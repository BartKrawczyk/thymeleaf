package pl.programodawca.thymeleaf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.programodawca.thymeleaf.dtos.BookDto;
import pl.programodawca.thymeleaf.models.Author;
import pl.programodawca.thymeleaf.models.Book;
import pl.programodawca.thymeleaf.repositories.AuthorRepository;
import pl.programodawca.thymeleaf.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public Book saveBook(BookDto bookDto) {
        List<Author> authors = authorService.add(bookDto);
        Book book = new Book();
        book.setAuthors(authors);
        book.setTitle(bookDto.getTitle());
        book.setPublisher(bookDto.getPublisher());
        bookRepository.save(book);
        return book;
    }

    //With Dto:

    public List<BookDto> getAll() {
        List<Book> all = bookRepository.findAll();
        return all.stream().map(this::mapBooks).collect(Collectors.toList());
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
