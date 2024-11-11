package com.MyLibrary.MyLibrary.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorModelDTO {
    private Integer id;
    
    private String name;
}
