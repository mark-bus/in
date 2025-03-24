package com.example.demo.controller;

import com.example.demo.dto.BookStoreResponseDto;
import com.example.demo.entity.BookStoreEntity;
import com.example.demo.repository.BookStoreRepository;
import com.example.demo.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/teacher")
public class BookStoreController {

    @Autowired
    private BookStoreService bookStoreService;

    @Autowired
    private BookStoreRepository bookStoreRepository;

    @GetMapping("/")
    ResponseEntity<List<BookStoreResponseDto>> getAllBookStores() {
        return ResponseEntity.ok(bookStoreService.getAllBookStores());
    }

    @GetMapping("/{id}")
    ResponseEntity<BookStoreResponseDto> getBookStoreById(@PathVariable Long id) {
        return ResponseEntity.ok(bookStoreService.getBookStoreById(id));
    }

    @PostMapping("/")
    ResponseEntity<BookStoreEntity> createTeacher(@RequestBody BookStoreEntity bookStore) {
        if (bookStore.getName() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(bookStoreRepository.save(bookStore));
    }
}
