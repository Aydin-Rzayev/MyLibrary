package com.MyLibrary.MyLibrary.services.implementations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyLibrary.MyLibrary.DTOs.BookModelDTO;
import com.MyLibrary.MyLibrary.DTOs.IU.BookModelIU;
import com.MyLibrary.MyLibrary.models.BookModel;
import com.MyLibrary.MyLibrary.repositories.IBookRepository;
import com.MyLibrary.MyLibrary.services.IBookService;



@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;
     public BookModelDTO saveBook(BookModelIU book){
        BookModel bookModel = new BookModel();
        BeanUtils.copyProperties(book, bookModel);
        BookModelDTO bookDto = new BookModelDTO();
        if(bookRepository.findByNameAndId(bookModel.getName(), bookModel.getId()).isPresent()){
            BeanUtils.copyProperties(bookRepository.save(bookModel), bookDto);
            return bookDto;
        }
        return null;
    }

    public BookModelDTO existsBook(BookModelIU book){
        BookModel bookModel = new BookModel();
        BeanUtils.copyProperties(book, bookModel);
        BookModelDTO response = new BookModelDTO();
        BeanUtils.copyProperties(bookRepository.findByNameAndId(bookModel.getName(), bookModel.getId()).orElse(null), response);
        return response;
    }

    public BookModelDTO getBookByName(String name){
        Iterator<BookModel> books = bookRepository.findAll().iterator();
        Optional<BookModelDTO> book = Optional.of(new BookModelDTO());
        while(books.hasNext()){
            BookModel next = books.next();
            if(next.getName().equals(name)){
                BeanUtils.copyProperties(next, book.get());
            }
        }
        return book.orElse(null);
    }

    public BookModelDTO getBookById(Integer id){
        Optional<BookModel> bookOptional = bookRepository.findById(id);
        BookModelDTO book = new BookModelDTO();
        BeanUtils.copyProperties(bookOptional.orElse(null), book);
        return book;
    }

    public List<BookModelDTO> getAllBooks(){
        List<BookModelDTO> books = new ArrayList<>();
        Iterator<BookModel> bookModel = bookRepository.findAll().iterator();
        while(bookModel.hasNext()){
            BookModel boo = bookModel.next();
            BookModelDTO bookDTO = new BookModelDTO();
            BeanUtils.copyProperties(boo, bookDTO);
            books.add(bookDTO);
        }
        return books;
    }

    public BookModelDTO updateBook(Integer id, String param, String val){
        Optional<BookModel> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            BookModel bookModel = bookOptional.get();
            switch(param) {
                case "name":
                    bookModel.setName(val);
                    bookRepository.save(bookModel);
                    break;
                default:
                    break;
        }
            BookModelDTO bookDTO = new BookModelDTO();
            BeanUtils.copyProperties(bookModel, bookDTO);
            return bookDTO;
        }
    return null;
    }

    public Boolean deleteBook(BookModelIU book){
        if(bookRepository.existsById(book.getId())){
            bookRepository.deleteById(book.getId());
            return true;
        }
        return false;
    }
}
