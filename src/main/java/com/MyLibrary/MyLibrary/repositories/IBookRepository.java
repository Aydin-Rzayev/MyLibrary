package com.MyLibrary.MyLibrary.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MyLibrary.MyLibrary.models.BookModel;

@Repository
public interface IBookRepository extends JpaRepository<BookModel, Integer>{
    Optional<BookModel> findByNameAndId(String name, Integer id);
}
