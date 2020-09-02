package pl.programodawca.thymeleaf.dtos;

import pl.programodawca.thymeleaf.models.Book;

import java.util.List;

public class AuthorDto {

    private Long id;
    private String firstName;
    private String lastName;
    private List<Book> books;

    public AuthorDto() {

    }

    public AuthorDto(Long id, String firstName, String lastName, List<Book> books) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
