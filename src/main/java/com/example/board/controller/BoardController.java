package com.example.board.controller;

import com.example.board.domain.Post;
import com.example.board.dto.PostSaveDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class BoardController {

    @GetMapping
    public String home(Model model) {

        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1, "1번 게시글", "1번 게시글의 내용", "작성자1", LocalDateTime.now()));
        posts.add(new Post(2, "2번 게시글", "2번 게시글의 내용", "작성자1", LocalDateTime.now()));
        posts.add(new Post(3, "3번 게시글", "3번 게시글의 내용", "작성자1", LocalDateTime.now()));
        posts.add(new Post(4, "4번 게시글", "4번 게시글의 내용", "작성자1", LocalDateTime.now()));
        posts.add(new Post(5, "5번 게시글", "5번 게시글의 내용", "작성자1", LocalDateTime.now()));

        model.addAttribute("posts", posts);
        return "main";
    }

    @GetMapping("/posts/{id}")
    public String postView(@PathVariable Integer id, Model model) {
        Post post = new Post(1, "1번 게시글", "1번 게시글의 내용", "작성자1", LocalDateTime.now());

        model.addAttribute("post", post);
        return "post-detail";
    }

    @GetMapping("/posts")
    public String newPostView(Model model) {
        model.addAttribute("post", new PostSaveDTO());
        return "new-post";
    }

    @PostMapping("/posts")
    public String addPost(@ModelAttribute PostSaveDTO postSaveDTO) {
        log.info("title = {}", postSaveDTO.title);
        log.info("author = {}", postSaveDTO.author);
        log.info("content = {}", postSaveDTO.content);
        return "redirect:posts/" + 1;
    }
}
