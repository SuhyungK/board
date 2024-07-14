package com.example.board.service;

import com.example.board.domain.Post;
import com.example.board.dto.PostEditDto;
import com.example.board.dto.PostSaveDto;
import com.example.board.repository.BoardMapper;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    public Post save(PostSaveDto postDTO) {
        Post newPost = new Post();
        newPost.setTitle(postDTO.title);
        newPost.setContent(postDTO.content);
        newPost.setAuthor(postDTO.author);
        newPost.setCreatedAt(LocalDateTime.now());
        return boardRepository.save(newPost);
    }

    public Post edit(PostEditDto dto) {
        Post post = boardMapper.findById(dto.getId());
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        boardMapper.update(post);
        return post;
    }

    public void delete(Long id) {
        boardMapper.delete(id);
    }

    public Post findById(Long id) {
        return boardRepository.findById(id);
    }

    public List<Post> findAll() {
        return boardRepository.findAll();
    }
}
