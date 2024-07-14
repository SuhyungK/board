package com.example.board.repository;

import com.example.board.domain.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final BoardMapper boardMapper;

    public Post save(Post post) {
        log.info("작성된 게시글 PK {}", post.getId());
        int result = boardMapper.save(post);
        log.info("insert 쿼리 결과 {}", result);
        log.info("새로 생성된 게시글 PK {}", post.getId());
        log.info("새로 생성된 게시글 제목 {}", post.getTitle());
        log.info("새로 생성된 게시글 내용 {}", post.getContent());
        return post;
    }

    public Post findById(@Param("id") Long id) {
        return boardMapper.findById(id);
    }

    public List<Post> findAll() {
        return boardMapper.findAll();
    }

    public Post update(Post post) {
        boardMapper.update(post);
        return post;
    }

    public void delete(Long id) {
        boardMapper.delete(id);
    }
}
