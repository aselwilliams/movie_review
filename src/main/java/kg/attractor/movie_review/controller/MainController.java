package kg.attractor.movie_review.controller;

import kg.attractor.movie_review.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    private final MovieService movieService;

    public MainController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("world", "Java");
        return "index";
    }
}
