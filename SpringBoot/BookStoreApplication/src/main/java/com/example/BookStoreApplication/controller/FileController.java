package com.example.BookStoreApplication.controller;

import com.example.BookStoreApplication.dto.FileDto;
import com.example.BookStoreApplication.entity.FileEntity;
import com.example.BookStoreApplication.service.FileService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource; // Changed from jakarta.annotation.Resource
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired; // Added for injection
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired // Or use constructor injection
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<FileDto> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        // Change 'String message' to 'FileDto fileDto'
        FileDto fileDto = fileService.uploadFile(file);

        // Return the DTO instead of a message string
        return ResponseEntity.ok(fileDto);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id) {
        // 1. Fetch file from DB
        FileEntity fileEntity = fileService.downloadFile(id);

        // 2. Wrap byte data into a Resource
        ByteArrayResource resource = new ByteArrayResource(fileEntity.getFileData());

        // 3. Build the response
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileEntity.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + fileEntity.getFileName() + "\"")
                .contentLength(fileEntity.getFileData().length)
                .body(resource);
    }
}