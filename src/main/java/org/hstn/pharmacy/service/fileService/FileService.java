package org.hstn.pharmacy.service.fileService;

import lombok.extern.slf4j.Slf4j;
import org.hstn.pharmacy.exceptions.RestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@Slf4j
public class FileService {

    private final Path fileStorageLocation = Paths.get("src/main/resources/static/upload").toAbsolutePath().normalize();

    public boolean uploadFile(MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();

            String extension = "";
            if (originalFilename != null) {

                extension = originalFilename.substring(originalFilename.lastIndexOf(". ") + 1);

            } else {
                throw new IllegalArgumentException("Null original file name");
            }

            String newFilename = UUID.randomUUID().toString();
            newFilename = newFilename + "." + extension;

            Path targetLocation = fileStorageLocation.resolve(newFilename);

            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            throw new RestException(HttpStatus.SERVICE_UNAVAILABLE, "Mistake" + file);
        }
        return true;
    }
}
