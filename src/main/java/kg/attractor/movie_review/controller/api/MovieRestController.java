package kg.attractor.movie_review.controller.api;

import kg.attractor.movie_review.dto.MovieDto;
import kg.attractor.movie_review.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //http:localhost:8080
@RequestMapping("/api/movies") //http://localhost:8080/movies
@RequiredArgsConstructor
public class MovieRestController {
    private final MovieService movieService;

    @GetMapping //movies/
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        return new ResponseEntity<List<MovieDto>>(movieService.getAllMovies(), HttpStatus.OK);
//        return ResponseEntity.ok(movieService.getMovies());
    }

    @GetMapping("/{movieId}") // movies/{movieId}
    public ResponseEntity<MovieDto> getMovie(@PathVariable Integer movieId) {
        return new ResponseEntity<>(movieService.getMovieById(movieId), HttpStatus.OK);
    }

//    @PostMapping
//    public HttpStatus createMovie(movieDto) {
//        return HttpStatus.CREATED;
//    }

    @PostMapping("/add")
    public ResponseEntity<Void> addMovie(@RequestBody MovieDto movieDto) {
        movieService.createMovie(movieDto);
        return ResponseEntity.ok().build();
    }
//    @PutMapping

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
        if (movieService.deleteMovie(id)) return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }
}
