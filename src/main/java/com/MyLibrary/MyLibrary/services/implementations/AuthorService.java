package com.MyLibrary.MyLibrary.services.implementations;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyLibrary.MyLibrary.DTOs.AuthorModelDTO;
import com.MyLibrary.MyLibrary.DTOs.IU.AuthorModelIU;
import com.MyLibrary.MyLibrary.models.AuthorModel;
import com.MyLibrary.MyLibrary.repositories.IAuthorRepository;
import com.MyLibrary.MyLibrary.services.IAuthorService;

@Service
public class AuthorService implements IAuthorService{
    @Autowired
    private IAuthorRepository authorRepository;

    public AuthorModelDTO saveAuthor(AuthorModelIU author){
        AuthorModel authorModel = new AuthorModel();
        BeanUtils.copyProperties(author, authorModel);
        AuthorModelDTO authorDto = new AuthorModelDTO();
        BeanUtils.copyProperties(authorRepository.save(authorModel), authorDto);
        return authorDto;
    }

    public AuthorModelDTO existsAuthor(AuthorModelIU author){
        AuthorModel authorModel = new AuthorModel();
        BeanUtils.copyProperties(author, authorModel);
        AuthorModelDTO response = new AuthorModelDTO();
        for (AuthorModel auth : authorRepository.findAll()) {
            if(auth.equals(authorModel)){
                BeanUtils.copyProperties(auth, response);
            }
        }
        return response;
    }


}
