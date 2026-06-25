package com.fernandocalisto.MovieFlix.service;

import com.fernandocalisto.MovieFlix.entity.Category;
import com.fernandocalisto.MovieFlix.entity.Movie;
import com.fernandocalisto.MovieFlix.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;

    public List<Movie> findAll() {
        return repository.findAll();
    }

    public Movie saveMovie(Movie movie) {
        return repository.save(movie);
    }

    public Optional<Movie> findMovieById(Long id) {
        return repository.findById(id);
    }

    public void deleteMovieById(Long id) {
        repository.deleteById(id);
    }

}
