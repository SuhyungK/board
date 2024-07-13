package com.example.board.repository;

import com.example.board.domain.Post;
import com.example.board.dto.PostSaveDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final BoardMapper boardMapper;

    public Post save(Post post) {
        boardMapper.save(post);
        return post;
    }

    public Post findById(@Param("id") Long id) {
        return boardMapper.findById(id);
    }

    public List<Post> findAll() {
        return boardMapper.findAll();
    }

    public void delete(Long id) {
        boardMapper.delete(id);
    }
}
