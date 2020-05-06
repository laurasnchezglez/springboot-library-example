package example.controller;

import example.domain.Book;
import example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/*
* Controller de books
* */

//L'authenticació que aplica és la del provider implementat. En aquest cas, basicAuth
//@Secured("isAuthenticated()")
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable<Book> index() {
        return bookRepository.findAll();
    }

    @GetMapping(value="/{id}")
    public Book get(@NotNull @PathVariable Long id) {
        return bookRepository.findById(id).get();
    }

    @GetMapping(value="/genre/{name}")
    public Book get(@NotNull @PathVariable String name) {
        return bookRepository.findByGenreName(name).get();
    }

    /*
    * En aquest cas, s'injecta el nou book com un json al requet body del PUT
    * */
    @PutMapping
    public Book put(@NotNull @RequestBody Book book) {
        return bookRepository.save(book);
    }

}