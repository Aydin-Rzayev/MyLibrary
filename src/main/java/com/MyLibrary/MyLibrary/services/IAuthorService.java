package com.MyLibrary.MyLibrary.services;

import java.util.List;
import java.util.Optional;

import com.MyLibrary.MyLibrary.DTOs.AuthorModelDTO;
import com.MyLibrary.MyLibrary.DTOs.IU.AuthorModelIU;

public interface IAuthorService {
    AuthorModelDTO getAuthorById(Integer id);
    AuthorModelDTO getAuthorByName(String name);
    Optional<List<AuthorModelDTO>> getAllAuthors();
    Boolean deleteAuthor(AuthorModelIU author);
    AuthorModelDTO existsAuthor(AuthorModelIU author);
    AuthorModelDTO updateAuthor(Integer id, String param, String val);
    AuthorModelDTO saveAuthor(AuthorModelIU author);
}
