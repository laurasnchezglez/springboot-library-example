package example.repository;

import example.domain.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {

    Optional<Genre> findByName(@javax.validation.constraints.NotNull String name);
}