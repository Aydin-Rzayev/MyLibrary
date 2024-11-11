package com.MyLibrary.MyLibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MyLibrary.MyLibrary.models.AuthorModel;

public interface IAuthorRepository extends JpaRepository<AuthorModel, Integer> {

}
