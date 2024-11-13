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
        if(authorRepository.findByNameAndId(authorModel.getName(), authorModel.getId()).isPresent()){
            BeanUtils.copyProperties(authorRepository.save(authorModel), authorDto);
            return authorDto;
        }
        return null;
    }

    public AuthorModelDTO existsAuthor(AuthorModelIU author){
        AuthorModel authorModel = new AuthorModel();
        BeanUtils.copyProperties(author, authorModel);
        AuthorModelDTO response = new AuthorModelDTO();
        BeanUtils.copyProperties(authorRepository.findByNameAndId(authorModel.getName(), authorModel.getId()).orElse(null), response);
        return response;
    }

    public AuthorModelDTO getAuthorByName(String name){
        Iterator<AuthorModel> authors = authorRepository.findAll().iterator();
        Optional<AuthorModelDTO> author = Optional.of(new AuthorModelDTO());
        while(authors.hasNext()){
            AuthorModel next = authors.next();
            if(next.getName().equals(name)){
                BeanUtils.copyProperties(next, author.get());
            }
        }
        return author.orElse(null);
    }

    public AuthorModelDTO getAuthorById(Integer id){
        Optional<AuthorModel> authorOptional = authorRepository.findById(id);
        AuthorModelDTO author = new AuthorModelDTO();
        BeanUtils.copyProperties(authorOptional.orElse(null), author);
        return author;
    }

    public List<AuthorModelDTO> getAllAuthors(){
        List<AuthorModelDTO> authors = new ArrayList<>();
        Iterator<AuthorModel> authorModel = authorRepository.findAll().iterator();
        while(authorModel.hasNext()){
            AuthorModel auth = authorModel.next();
            AuthorModelDTO authDTO = new AuthorModelDTO();
            BeanUtils.copyProperties(auth, authDTO);
            authors.add(authDTO);
        }
        return authors;
    }

    public AuthorModelDTO updateAuthor(Integer id, String param, String val){
        Optional<AuthorModel> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()) {
            AuthorModel authorModel = authorOptional.get();
            switch(param) {
                case "name":
                    authorModel.setName(val);
                    authorRepository.save(authorModel);
                    break;
                default:
                    break;
        }
            AuthorModelDTO authorDTO = new AuthorModelDTO();
            BeanUtils.copyProperties(authorModel, authorDTO);
            return authorDTO;
        }
    return null;
    }

    public Boolean deleteAuthor(AuthorModelIU author){
        if(authorRepository.existsById(author.getId())){
            authorRepository.deleteById(author.getId());
            return true;
        }
        return false;
    }

}


