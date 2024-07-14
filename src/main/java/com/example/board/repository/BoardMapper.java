package com.example.board.repository;

import com.example.board.domain.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface BoardMapper {
    int save(Post post);
    Post findById(Long id);
    List<Post> findAll();
    int update(Post post);
    int delete(Long id);
}
