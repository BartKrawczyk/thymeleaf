package pl.programodawca.thymeleaf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.programodawca.thymeleaf.models.Book;
import pl.programodawca.thymeleaf.services.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

     @Autowired
     private BookService bookService;


    @GetMapping("/list")
    public String allBooks(ModelMap modelMap) {
        modelMap.addAttribute("books", bookService.getAll());
        return "book/list";
    }

    @GetMapping("/addBook")
    public String initForm(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

}

