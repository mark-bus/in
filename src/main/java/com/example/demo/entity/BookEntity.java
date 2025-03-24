package com.example.demo.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    Integer price;

    @ManyToMany(mappedBy = "bookEntities")
    List<BookStoreEntity> bookStores;

}
