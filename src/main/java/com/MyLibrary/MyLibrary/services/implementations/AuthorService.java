package com.MyLibrary.MyLibrary.services.implementations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
        while(authorRepository.findAll().iterator().hasNext()){
            AuthorModel auth = authorRepository.findAll().iterator().next();
            if(auth.equals(authorModel)){
                return null;
            }
        }
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

    public AuthorModelDTO getAuthorByName(String name){
        Iterator<AuthorModel> authors = authorRepository.findAll().iterator();
        AuthorModelDTO author = new AuthorModelDTO();
        while(authors.hasNext()){
            AuthorModel next = authors.next();
            if(next.getName().equals(name)){
                BeanUtils.copyProperties(next, author);
            }
        }
        return author;
    }

    public AuthorModelDTO getAuthorById(Integer id){
        Optional<AuthorModel> authorOptional = authorRepository.findById(id);
        AuthorModelDTO author = new AuthorModelDTO();
        BeanUtils.copyProperties(authorOptional.get(), author);
        return author;
    }

    public List<AuthorModelDTO> getAllAuthors(){
        List<AuthorModelDTO> authors = new ArrayList<>();
        BeanUtils.copyProperties(authorRepository.findAll(), authors);
        return authors;
    }

    public AuthorModelDTO updateAuthor(Integer id, String param, String val){
        Optional<AuthorModel> author = authorRepository.findById(id);
        if(author.isPresent()){
            AuthorModel authorModel = author.get();
            switch(param){
                case "name":
                    authorModel.setName(val);
                    authorRepository.save(authorModel);
                default:
                    break;
            }

        }
        AuthorModelDTO authorDTO = new AuthorModelDTO();
        BeanUtils.copyProperties(authorRepository.findById(id).get(), authorDTO);
        return authorDTO;
    }

    public Boolean deleteAuthor(AuthorModelIU author){
        AuthorModel authorModel = new AuthorModel();
        BeanUtils.copyProperties(author, authorModel);
        if(authorRepository.existsById(author.getId())){
            authorRepository.delete(authorModel);
            return true;
        }
        return false;
    }



}


