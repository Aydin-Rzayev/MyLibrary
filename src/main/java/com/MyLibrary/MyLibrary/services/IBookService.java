package com.MyLibrary.MyLibrary.services;

import java.util.List;

import com.MyLibrary.MyLibrary.DTOs.BookModelDTO;
import com.MyLibrary.MyLibrary.DTOs.IU.BookModelIU;

public interface IBookService {
    BookModelDTO getBookById(Integer id);
    BookModelDTO getBookByName(String name);
    List<BookModelDTO> getAllBooks();
    BookModelDTO deleteBook(BookModelIU book);
    BookModelDTO existsBook(BookModelIU book);
    BookModelDTO updateBook(BookModelIU book);
    BookModelDTO saveBook(BookModelIU book);
}
