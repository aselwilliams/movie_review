package kg.attractor.movie_review.service;

import kg.attractor.movie_review.dto.ImageDto;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    ResponseEntity<?> findById(Long id);

    void save(ImageDto movieImageDto);

//    String saveUploadFile(MultipartFile file, String subDir);
//
//    ResponseEntity<?> downloadImage(Integer id);
}
