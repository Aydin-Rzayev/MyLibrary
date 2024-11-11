package com.MyLibrary.MyLibrary.DTOs.IU;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookModelIU {    
    private Integer id;
   
    private String name;

    private AuthorModelIU author;
}
