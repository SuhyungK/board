package com.example.board.repository;

import com.example.board.domain.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    @DisplayName("유효한 게시글 저장시 성공")
    void post_save_success_returns_1() {
        // given
        Post newPost = Post.builder()
                .title("테스트 제목")
                .content("테스트 내용")
                .author("작성자 구교환")
                .createdAt(LocalDateTime.now())
                .build()
                ;

        // when
        int saveResult = boardMapper.save(newPost);
        List<Post> postList = boardMapper.findAll();

        // then
        assertThat(saveResult).isEqualTo(1);
        assertThat(postList.size()).isEqualTo(1);
    }
    
    @Test
    @DisplayName("게시글 저장 후 개별 게시글 조회시 성공")
    void one_post_find_success() {
        // given
        Post newPost = Post.builder()
                .title("테스트 제목")
                .content("테스트 내용")
                .author("작성자 구교환")
                .createdAt(LocalDateTime.now())
                .build()
                ;
        boardMapper.save(newPost);

        // when
        Post findPost = boardMapper.findById(1L);

        // then
        assertThat(findPost.getId()).isEqualTo(1L);
        assertThat(findPost.getTitle()).isEqualTo("테스트 제목");
        assertThat(findPost.getContent()).isEqualTo("테스트 내용");
    }
    
    @Test
    @DisplayName("전체 게시글 조회시 성공")
    void all_posts_find_success() {
        // given
        Post newPost = Post.builder()
                .title("테스트 제목")
                .content("테스트 내용")
                .author("작성자 구교환")
                .createdAt(LocalDateTime.now())
                .build()
                ;
        Post newPost2 = Post.builder()
                .title("테스트 제목")
                .content("테스트 내용")
                .author("작성자 구교환")
                .createdAt(LocalDateTime.now())
                .build()
                ;
        boardMapper.save(newPost);
        boardMapper.save(newPost2);

        // when
        List<Post> postList = boardMapper.findAll();

        // then
        assertThat(postList.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("유효한 게시글 삭제시 성공")
    void post_delete_success_returns_1() {
        // given
        Post newPost = Post.builder()
                .title("테스트 제목")
                .content("테스트 내용")
                .author("작성자 구교환")
                .createdAt(LocalDateTime.now())
                .build()
                ;
        boardMapper.save(newPost);

        // when
        int deleteResult = boardMapper.delete(newPost.getId());

        // then
        assertThat(deleteResult).isEqualTo(1);
    }
    
    @Test
    @DisplayName("저장되지 않은 게시글 삭제시 실패")
    void not_existed_post_delete_returns_0() {
        // given
        Long randomId = 1L;
                
        // when
        int deleteResult = boardMapper.delete(randomId);

        // then
        assertThat(deleteResult).isEqualTo(0);
    }
}