package kg.attractor.movie_review.controller;

import kg.attractor.movie_review.dto.ImageDto;
import kg.attractor.movie_review.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping("{id}")
    public ResponseEntity<?> findImageById(@PathVariable("id") Long id) {
        return imageService.findById(id);
    }

    @PostMapping
    public HttpStatus saveImage(ImageDto movieImageDto) {
        imageService.save(movieImageDto);
        return HttpStatus.CREATED;
    }

//    @GetMapping("/download/{imageId}")
//    public ResponseEntity<?> downloadImage(@PathVariable("imageId") Integer id) {
//        return imageService.downloadImage(id);
//    }
//
//    @PostMapping("/upload")
//    public ResponseEntity<Void> uploadImage(ImageDto imageDto){
////        ImageService.addImage(imageDto);
//        return ResponseEntity.ok().body(null);
//    }
}
