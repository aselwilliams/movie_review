package kg.attractor.movie_review.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private int id;
    private String name;
    private int releaseYear;
    private String description;
    private int directorId;

    @Override
    public String toString() {
        return String.format("Фильм: <<%s>>,%nГод выпуска: %s,%nОписание: %s,%n%s", name, releaseYear, description, directorId);
    }
}

//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class Movie {
//    private String name;
//    private Integer year;
//    private String description;
//    private Integer id;
//    private Director director;
//    private List<Cast> cast;
//
//    @Override
//    public String toString() {
//        return "Movie{" +
//                "name='" + name + '\'' +
//                ", year=" + year +
//                ", description='" + description + '\'' +
//                ", id=" + id +
//                ", director=" + director +
//                ", cast=" + cast +
//                '}';
//    }
//}
