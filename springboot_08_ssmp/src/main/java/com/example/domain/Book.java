package com.example.domain;

import lombok.Data;

//lombok
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
