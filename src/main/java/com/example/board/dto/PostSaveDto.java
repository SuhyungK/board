package com.example.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostSaveDto {
    public String title;
    public String content;
    public String author; // 작성자
}
