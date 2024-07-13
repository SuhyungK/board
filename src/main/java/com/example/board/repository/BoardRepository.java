package com.example.board.repository;

import com.example.board.domain.Post;
import com.example.board.dto.PostSaveDTO;
import lombok.RequiredArgsConstructor;
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

    public List<Post> findAll() {
        return boardMapper.findAll();
    }
}
