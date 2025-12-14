package kg.attractor.movie_review.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private String name;
    private Integer year;
    private String description;
    private Integer id;
    private Director director;
    private List<Cast> cast;

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", director=" + director +
                ", cast=" + cast +
                '}';
    }
}
