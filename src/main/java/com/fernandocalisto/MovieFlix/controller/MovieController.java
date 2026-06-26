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
    public ResponseEntity<MovieResponse> saveMovies (@RequestBody MovieRequest movie) {
        Movie savedMovie = service.saveMovie(MovieMapper.toMovie(movie));
        return ResponseEntity.status(HttpStatus.CREATED).body(MovieMapper.toMovieResponse(savedMovie));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> getMovies () {
        List<Movie> list = service.findAll();
        return  ResponseEntity.ok(list.stream().map(MovieMapper::toMovieResponse).toList());
    }
}
