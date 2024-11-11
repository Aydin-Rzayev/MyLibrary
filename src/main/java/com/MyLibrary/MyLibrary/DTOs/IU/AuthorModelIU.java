package com.MyLibrary.MyLibrary.DTOs.IU;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorModelIU {
    private Integer id;
    
    private String name;
    
    private Set<BookModelIU> books;
}
