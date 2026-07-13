package com.fernandocalisto.MovieFlix.controller;

import com.fernandocalisto.MovieFlix.controller.request.MovieRequest;
import com.fernandocalisto.MovieFlix.controller.response.MovieResponse;
import com.fernandocalisto.MovieFlix.entity.Movie;
import com.fernandocalisto.MovieFlix.mapper.MovieMapper;
import com.fernandocalisto.MovieFlix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService service;

    @PostMapping
    public ResponseEntity<MovieResponse> saveMovies(@RequestBody MovieRequest movie) {
        Movie savedMovie = service.saveMovie(MovieMapper.toMovie(movie));
        return ResponseEntity.status(HttpStatus.CREATED).body(MovieMapper.toMovieResponse(savedMovie));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> getMovies() {
        List<Movie> list = service.findAll();
        return ResponseEntity.ok(list.stream().map(MovieMapper::toMovieResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findMovieById(@PathVariable Long id) {
        return service.findMovieById(id).map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie))).
                orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{Id}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable Long Id, @RequestBody MovieRequest movieRequest) {
        return service.updateMovie(Id, MovieMapper.toMovie(movieRequest))
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> findByCategory(@RequestParam Long id) {
        List<MovieResponse> responses = service.findByCategory(id)
                .stream()
                .map(MovieMapper::toMovieResponse)
                .toList();
        return ResponseEntity.ok(responses);
    }
}
