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

    public List<Streaming> findStreamings (List<Streaming> streamings) {
        List<Streaming> streamingList = new ArrayList<>();
        streamings.forEach(streaming -> {
            streamingService.findStreamingById(streaming.getId()).ifPresent(streamingList::add);
        });
        return streamingList;
    }

}
