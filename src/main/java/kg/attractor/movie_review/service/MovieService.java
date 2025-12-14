package kg.attractor.movie_review.service;

import kg.attractor.movie_review.dto.MovieDto;
import kg.attractor.movie_review.model.Director;
import kg.attractor.movie_review.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface MovieService {


    MovieDto getMovies();

    List<MovieDto> getAllMovies();

    MovieDto getMovieById(int id);

    void createMovie(MovieDto movieDto);

    boolean deleteMovie(Integer id);
}
