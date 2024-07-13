package com.example.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;
}
