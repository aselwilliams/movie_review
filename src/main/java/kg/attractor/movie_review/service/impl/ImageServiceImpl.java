package kg.attractor.movie_review.service.impl;

import kg.attractor.movie_review.service.ImageService;
import kg.attractor.movie_review.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final FileUtil fileService;

//    @SneakyThrows
//    public String saveUploadFile(MultipartFile file, String subDir) {
//        String uuidFile = UUID.randomUUID().toString();
//        String resultFileName = uuidFile + "_" + file.getOriginalFilename();
//
//        Path path = Paths.get(subDir + resultFileName);
//        Files.createDirectories(path);
//
//        Path filePath = Paths.get(path + "/" + resultFileName);
//        if (!Files.exists(filePath)) {
//            Files.createFile(filePath);
//        }
//        try (OutputStream os = Files.newOutputStream(filePath)) {
//            os.write(file.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return resultFileName;
//    }

    @Override
    public ResponseEntity<?> downloadImage(Integer id) {
        String fileName = "puicture.jpg";
        return fileService.getOutPutFile(fileName, "/images", MediaType.IMAGE_JPEG);
    }
}
