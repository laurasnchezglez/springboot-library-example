package example.controller;


import example.domain.Genre;
import example.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;


//@Secured("isAuthenticated()")
@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;


    @GetMapping
    public Iterable<Genre> index() {
        Iterable<Genre> all = genreRepository.findAll();

        return all;
    }

    @GetMapping(value="/{id}")
    @ResponseBody
    public Genre get(@NotNull @PathVariable Long id) {
        return genreRepository.findById(id).get();
    }

}