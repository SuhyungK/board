package com.example.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostEditDto {
    private Long id;
    private String title;
    private String content;
}
