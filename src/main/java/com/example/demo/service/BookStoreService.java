package com.example.demo.service;

import com.example.demo.dto.BookStoreResponseDto;
import com.example.demo.entity.BookStoreEntity;
import com.example.demo.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class BookStoreService {

    @Autowired
    private BookStoreRepository bookStoreRepository;

    public List<BookStoreResponseDto> getAllBookStores() {
        List<BookStoreEntity> bookStores = bookStoreRepository.findAll();
        return bookStores.stream().map(t -> {
            return BookStoreResponseDto.builder()
                    .id(t.getId())
                    .name(t.getName())
                    .bookNames(t.getBookEntities() != null ? t.getBookEntities().stream().map(s -> s.getTitle()).toList() : null)
                    .build();
        }).toList();
    }

    BookStoreResponseDto mapToBookStoreResponseDto(Optional<BookStoreEntity> teacher) {
        if(teacher.isPresent())
            return teacher.map(t -> {
                return BookStoreResponseDto.builder()
                        .id(t.getId())
                        .name(t.getName())
                        .bookNames(t.getBookEntities() != null ? t.getBookEntities().stream().map(s -> s.getTitle()).toList() : null)
                        .build();
            }).get();
        return null;
    }

    public BookStoreResponseDto getBookStoreById(Long id) {
        Optional<BookStoreEntity> teacher = bookStoreRepository.findById(id);
        return mapToBookStoreResponseDto(teacher);
    }

}
