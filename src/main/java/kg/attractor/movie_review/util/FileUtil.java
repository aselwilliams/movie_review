package kg.attractor.movie_review.util;

import kg.attractor.movie_review.model.Movie;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileUtil {

    private final Gson gson;

    @Autowired
    public FileUtil() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public List<Movie> getMovies() {
        Type listType = new TypeToken<Map<String, List<Movie>>>() {

        }.getType();
        try (Reader reader = new FileReader("data/movies.json")) {
            Map<String, List<Movie>> movies = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }


    public ResponseEntity<?> getOutPutFile(String fileName, String subDir, MediaType imageJpeg) {
        try {
            byte[] imageBytes = Files.readAllBytes(Paths.get(subDir + "/" + fileName));
            Resource resource = new ByteArrayResource(imageBytes);
            return ResponseEntity.ok().contentType(imageJpeg)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                    .contentLength(resource.contentLength())
                    .contentType(imageJpeg)
                    .body(resource);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Image not found");
        }
    }

    @SneakyThrows
    public String saveUploadFile(MultipartFile file, String subDir) {
        String uuidFile = UUID.randomUUID().toString();
        String resultFileName = uuidFile + "_" + file.getOriginalFilename();

        Path path = Paths.get(subDir + resultFileName);
        Files.createDirectories(path);

        Path filePath = Paths.get(path + "/" + resultFileName);
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
        try (OutputStream os = Files.newOutputStream(filePath)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultFileName;
    }
}
