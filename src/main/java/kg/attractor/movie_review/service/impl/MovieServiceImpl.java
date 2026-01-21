package kg.attractor.movie_review.service.impl;

import jakarta.el.MethodNotFoundException;
import kg.attractor.movie_review.dao.MovieDao;
import kg.attractor.movie_review.dto.MovieDto;
import kg.attractor.movie_review.exceptions.MovieNotFoundException;
import kg.attractor.movie_review.model.Movie;
import kg.attractor.movie_review.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final List<Movie> movies;
    private final MovieDao movieDao;

    @Override
    public List<MovieDto> getMovies() {
        List<Movie> movies = movieDao.getAll();
        List<MovieDto> moviesDto = new ArrayList<>();
        movies.forEach(movie -> {
            MovieDto movieDto = new MovieDto();
            movieDto.setId(movie.getId());
            movieDto.setName(movie.getName());
            movieDto.setYear(movie.getReleaseYear());
            movieDto.setDescription(movie.getDescription());
            moviesDto.add(movieDto);
        });

        return moviesDto;
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return List.of();
    }

    @Override
    public MovieDto getMovieById(int id) {
        return null;
    }

    @Override
    public void createMovie(MovieDto movieDto) {

    }


//    @Autowired
////    this.movies = new FileUtil().getMovies();
//
//    //    MovieDto getMovies();
//    @Override
//    public List<MovieDto> getAllMovies() {
//        return movies.stream().map(this::convertToMovieDto).toList();
//    }
//
//    @Override
//    public MovieDto getMovieById(int id) {
//        return movies.stream().filter(m -> m.getId() == id).map(this::convertToMovieDto).findAny().orElseThrow();
//    }
//
//    @Override
//    public void createMovie(MovieDto movieDto) {
//        movies.add(
//                Movie.builder()
//                        .id(movies.size() + 1)
//                        .name(movieDto.getName())
//                        .year(LocalDate.now().getYear())
//                        .description(movieDto.getDescription())
//                        .cast(new ArrayList<>())
//                        .director(new Director())
//                        .build()
//        );
//    }
//
    @Override
    public boolean deleteMovie(Integer id) {
        return movies.removeIf(m -> m.getId() == id);
    }

    @Override
    public MovieDto findById(Long id) {
        Movie movie = movieDao.findById(id)
                .orElseThrow(MovieNotFoundException::new);
        return MovieDto.builder()
                .id(movie.getId())
                .name(movie.getName())
                .year(movie.getReleaseYear())
                .description(movie.getDescription())
                .build();
    }

//    private MovieDto convertToMovieDto(Movie movie) {
//        return MovieDto.builder()
//                .id(movie.getId())
//                .name(movie.getName())
//                .description(movie.getDescription())
//                .year(movie.getYear())
//                .director(movie.getDirector())
//                .build();
//    }
//
//    @Override
//    public MovieDto getMovies() {
//        MovieDto movieDto = new MovieDto();
//        movieDto.setName("Good omens");
//        movieDto.setYear(2019);
//        movieDto.setDescription("TV Series");
//        movieDto.setDirector(new Director("Douglas Mackinnon"));
//        movieDto.setCastList(List.of(new Cast("Michael Sheen", "Aziraphale"), new Cast("David Tennant", "Crowley")));
//        return movieDto;
//    }
}
