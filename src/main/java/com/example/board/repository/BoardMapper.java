package com.example.board.repository;

import com.example.board.domain.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void save(Post post);
    List<Post> findAll();
}
