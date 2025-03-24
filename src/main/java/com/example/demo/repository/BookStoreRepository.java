package com.example.demo.repository;

import com.example.demo.entity.BookStoreEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BookStoreRepository extends CrudRepository<BookStoreEntity, Long> {
    List<BookStoreEntity> findAll();
}
