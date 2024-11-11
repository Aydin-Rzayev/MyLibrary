package com.MyLibrary.MyLibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MyLibrary.MyLibrary.models.BookModel;

public interface IBookRepository extends JpaRepository<BookModel, Integer>{

}
