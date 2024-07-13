package com.example.board.service;

import com.example.board.domain.Post;
import com.example.board.dto.PostSaveDTO;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Post save(PostSaveDTO postDTO) {
        Post newPost = new Post();
        newPost.setTitle(postDTO.title);
        newPost.setContent(postDTO.content);
        newPost.setAuthor(postDTO.author);
        newPost.setCreatedAt(LocalDateTime.now());
        return boardRepository.save(newPost);
    }

    public Post findById(Long id) {
        return boardRepository.findById(id);
    }

    public List<Post> findAll() {
        return boardRepository.findAll();
    }
}
