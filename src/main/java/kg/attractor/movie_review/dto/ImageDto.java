package kg.attractor.movie_review.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImageDto {

    private Long movieId;
    private MultipartFile image;
}
