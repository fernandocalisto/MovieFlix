package com.fernandocalisto.MovieFlix.service;

import com.fernandocalisto.MovieFlix.entity.Category;
import com.fernandocalisto.MovieFlix.entity.Movie;
import com.fernandocalisto.MovieFlix.entity.Streaming;
import com.fernandocalisto.MovieFlix.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public List<Movie> findAll() {
        return repository.findAll();
    }

    public Movie saveMovie(Movie movie) {
        movie.setCategories(this.findCategories(movie.getCategories()));
        movie.setStreamings(this.findStreamings(movie.getStreamings()));
        return repository.save(movie);
    }

    public Optional<Movie> findMovieById(Long id) {
        return repository.findById(id);
    }

    public void deleteMovieById(Long id) {
        repository.deleteById(id);
    }

    public List<Category> findCategories(List<Category> categories) {
        List<Category> categoriesFound = new ArrayList<>();
        categories.forEach(category -> {
            categoryService.findCategoryById(category.getId()).ifPresent(categoriesFound::add);
        });
        return categoriesFound;
    }

    public List<Streaming> findStreamings(List<Streaming> streamings) {
        List<Streaming> streamingList = new ArrayList<>();
        streamings.forEach(streaming -> {
            streamingService.findStreamingById(streaming.getId()).ifPresent(streamingList::add);
        });
        return streamingList;
    }

    public Optional<Movie> updateMovie(Long id, Movie updateMovie) {
        Optional<Movie> optMovie = repository.findById(id);
        if (optMovie.isPresent()) {
            Movie movie = optMovie.get();
            movie.setTitle(updateMovie.getTitle());
            movie.setDescription(updateMovie.getDescription());
            movie.setReleaseDate(updateMovie.getReleaseDate());
            movie.setRating(updateMovie.getRating());

            movie.getCategories().clear();
            movie.getStreamings().clear();

            movie.getCategories().addAll(findCategories(updateMovie.getCategories()));
            movie.getStreamings().addAll(findStreamings(updateMovie.getStreamings()));

            return Optional.of(movie);
        }
        return Optional.empty();
    }

    public List<Movie> findByCategory(Long categoryId) {
        return repository.findMovieByCategories(List.of(Category.builder().id(categoryId).build()));
    }

    public void deleteMovie(Long id) {
        repository.deleteById(id);
    }

}
