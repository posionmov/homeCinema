package com.sagalanov.repositories;

import com.sagalanov.models.films.Film;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmRepository extends MongoRepository<Film, String> {
}
