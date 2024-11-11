package com.MyLibrary.MyLibrary.services;

import java.util.List;

import com.MyLibrary.MyLibrary.DTOs.AuthorModelDTO;
import com.MyLibrary.MyLibrary.DTOs.IU.AuthorModelIU;

public interface IAuthorService {
    AuthorModelDTO getAuthorById(Integer id);
    AuthorModelDTO getAuthorByName(String name);
    List<AuthorModelDTO> getAllAuthors();
    AuthorModelDTO deleteAuthor(AuthorModelIU author);
    AuthorModelDTO existsAuthor(AuthorModelIU author);
    AuthorModelDTO updateAuthor(AuthorModelIU author);
    AuthorModelDTO saveAuthor(AuthorModelIU author);
}
