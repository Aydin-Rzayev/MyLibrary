package com.MyLibrary.MyLibrary.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyLibrary.MyLibrary.DTOs.AuthorModelDTO;
import com.MyLibrary.MyLibrary.DTOs.IU.AuthorModelIU;
import com.MyLibrary.MyLibrary.services.IAuthorService;

@RestController
@RequestMapping(path = "/author")
public class AuthorController {
    @Autowired
    private IAuthorService authorService;

    @GetMapping(path = "/get/all")
    public ResponseEntity<List<AuthorModelDTO>> getAllAuthors(){
       return authorService.getAllAuthors().map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<AuthorModelDTO> getAuthorById(@PathVariable Integer id){
        return ResponseEntity.ofNullable(authorService.getAuthorById(id));
    }

    @GetMapping(path = "/get/{name}")
    public ResponseEntity<AuthorModelDTO> getAuthorByName(@PathVariable String name){
        return ResponseEntity.ofNullable(authorService.getAuthorByName(name));
    }

    @PostMapping(path = "/new")
    public ResponseEntity<?> addAuthor(@RequestBody AuthorModelIU author){
       if(authorService.saveAuthor(author) == null){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Author already exists");
       }
       return ResponseEntity.status(HttpStatus.CREATED).body(author);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable Integer id, String param, String val){
        Optional<AuthorModelDTO> authorOptional = Optional.of(authorService.getAuthorById(id));
        if(authorOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(authorService.updateAuthor(id, param, val));

    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<?> deleteAuthor(@RequestBody AuthorModelIU author){
       Boolean isDeleted = authorService.deleteAuthor(author);
       if(isDeleted){
        return ResponseEntity.ok("Author deleted");
       }
       else{
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found");
       }
    }

}
