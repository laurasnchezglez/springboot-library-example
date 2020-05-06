package example.repository;

import example.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/*
* Els repositoris es fan servir per crear beans d'una classe de domini en particular
* En aquest cas, fem sirvir la libreria de 'micronaut-data', similar a 'spring-data'.
* Podem extendre de repositoris estandar i fer servir els seus métodes (en casos simples)
* */
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    /*En cas de afegir una nova consulta una mica mes complexa, es pot fer servir la annotació '@Query'*/
    @Query("FROM Book p WHERE p.genre.name = :name")
    Optional<Book> findByGenreName(String name);
}