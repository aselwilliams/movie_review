package kg.attractor.movie_review.service;

import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    String saveUploadFile(MultipartFile file, String subDir);

    ResponseEntity<?> downloadImage(Integer id);
}
