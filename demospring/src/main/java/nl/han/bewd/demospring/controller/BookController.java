package nl.han.bewd.demospring.controller;

import nl.han.bewd.demospring.domein.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {
    private List<Book> books;

    // Constructor om de boekenlijst te vullen
    public BookController() {
        books = new ArrayList<>();
        books.add(new Book("001", "Barry Boter", "Kees"));
        books.add(new Book("002", "Een titel", "een auteur"));
        books.add(new Book("003", "Wiskunde versie 12", "Noordhoff"));
    }

    @GetMapping("/book")
    public Book getBook() {
        return this.books.get(0);
    }

    @PostMapping("/book")
    public Book postBook() {
        return this.books.get(0);
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.books;
    }

    @PostMapping("/books")
    public List<Book> postBooks() {
        return this.books;
    }

    @GetMapping("/books/{isbn}")
    public List<Book> getBookByIsbn(@PathVariable String isbn) {
        return books.stream().filter(book -> book.getIsbn().equalsIgnoreCase(isbn)).collect(Collectors.toList());
    }

    @PostMapping("/books/{isbn}")
    public List<Book> postBookByIsbn(@PathVariable String isbn) {
        return books.stream().filter(book -> book.getIsbn().equalsIgnoreCase(isbn)).collect(Collectors.toList());
    }
}

