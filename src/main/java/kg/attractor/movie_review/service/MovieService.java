package kg.attractor.movie_review.service;

import kg.attractor.movie_review.dto.MovieDto;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface MovieService {


    List<MovieDto> getMovies();

    List<MovieDto> getAllMovies();

    MovieDto getMovieById(int id);

    void createMovie(MovieDto movieDto);

    boolean deleteMovie(Integer id);

    MovieDto findById(Long id);
}
