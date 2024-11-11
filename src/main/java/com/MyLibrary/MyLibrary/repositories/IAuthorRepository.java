package com.MyLibrary.MyLibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MyLibrary.MyLibrary.models.AuthorModel;

@Repository
public interface IAuthorRepository extends JpaRepository<AuthorModel, Integer> {

}
