package pl.programodawca.thymeleaf.dtos;

import pl.programodawca.thymeleaf.models.Author;
import pl.programodawca.thymeleaf.models.Publisher;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class BookDto {
    private Long id;
    @NotNull(message = "Title is required")
    private String title;
    @NotNull(message = "Author is required")
    private Set<Author> authors;
    @NotNull(message = "Publisher is required")
    private Publisher publisher;

    public BookDto() {

    }

    public BookDto(Long id, @NotNull(message = "Title is required") String title, @NotNull(message = "Author is required") Set<Author> authors, @NotNull(message = "Publisher is required") Publisher publisher) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}

