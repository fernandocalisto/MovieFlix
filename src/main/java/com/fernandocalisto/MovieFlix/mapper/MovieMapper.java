package com.fernandocalisto.MovieFlix.mapper;

import com.fernandocalisto.MovieFlix.controller.request.MovieRequest;
import com.fernandocalisto.MovieFlix.controller.response.CategoryResponse;
import com.fernandocalisto.MovieFlix.controller.response.MovieResponse;
import com.fernandocalisto.MovieFlix.controller.response.StreamingResponse;
import com.fernandocalisto.MovieFlix.entity.Category;
import com.fernandocalisto.MovieFlix.entity.Movie;
import com.fernandocalisto.MovieFlix.entity.Streaming;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {

    public static Movie toMovie(MovieRequest request) {
        List<Category> categories = request.categories()
                .stream()
                .map(categoryId -> Category.builder().id(categoryId).build())
                .toList();

        List<Streaming> services = request.streamings()
                .stream()
                .map(streamingId -> Streaming.builder().id(streamingId).build())
                .toList();

        return Movie.builder()
                .title(request.title())
                .description(request.description())
                .rating(request.rating())
                .releaseDate(request.releaseDate())
                .categories(categories)
                .streamings(services)
                .build();
    }

    public static MovieResponse toMovieResponse (Movie movie) {

        List<CategoryResponse> categories = movie.getCategories()
                .stream()
                .map(category -> CategoryResponse.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build())
                .toList();

        List<StreamingResponse> streamings = movie.getStreamings()
                .stream()
                .map(streaming -> StreamingResponse.builder()
                        .id(streaming.getId())
                        .name(streaming.getName())
                        .build())
                .toList();

        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .rating(movie.getRating())
                .releaseDate(movie.getReleaseDate())
                .categories(categories)
                .streamings(streamings)
                .build();

    }

}
