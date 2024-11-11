package com.MyLibrary.MyLibrary.DTOs.IU;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReaderModelIU {    
    private Integer id;
    
    private String name;
   
    private String password;
    
    private String email;

    private enum bookStatus{borrowed, returned, wishlist};

    private HashMap<BookModelIU, bookStatus> bookArchive;
}
