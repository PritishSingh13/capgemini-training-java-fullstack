package com.example.BookStoreApplication.service;

import com.example.BookStoreApplication.dto.FileDto;
import com.example.BookStoreApplication.entity.FileEntity;
import com.example.BookStoreApplication.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;
    private final ModelMapper modelMapper;

    public FileDto uploadFile(MultipartFile file) throws IOException{
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(file.getOriginalFilename());
        fileEntity.setFileType(file.getContentType());
        fileEntity.setFileSize(file.getSize());
        fileEntity.setFileData(file.getBytes());

        FileEntity savedFile = fileRepository.save(fileEntity);

        return modelMapper.map(savedFile,FileDto.class);
    }

    public FileEntity downloadFile(Long id){
        return fileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found with id: "+ id));
    }
}
