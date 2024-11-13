package com.MyLibrary.MyLibrary.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MyLibrary.MyLibrary.models.AuthorModel;

@Repository
public interface IAuthorRepository extends JpaRepository<AuthorModel, Integer> {
    //Added this method as it will be necessary for service 
    Optional<AuthorModel> findByNameAndId(String name, Integer id);
}
