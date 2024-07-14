package com.example.board.controller;

import com.example.board.domain.Post;
import com.example.board.dto.PostEditDto;
import com.example.board.dto.PostSaveDto;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    /**
     * 메인 페이지
     * @param model
     * @return
     */
    @GetMapping
    public String home(Model model) {
        List<Post> posts = boardService.findAll();
        model.addAttribute("posts", posts);

        return "main";
    }

    /**
     * 상세 게시글 페이지
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/posts/{id}")
    public String postView(@PathVariable Long id, Model model) {
        Post findPost = boardService.findById(id);
        model.addAttribute("post", findPost);
        return "post-detail";
    }

    /**
     * 새 게시글 작성 페이지
     * @param model
     * @return
     */
    @GetMapping("/posts")
    public String newPostView(Model model) {
        model.addAttribute("post", new PostSaveDto());
        return "new-post";
    }

    /**
     * 새 게시글 작성 API
     * @param postSaveDTO
     * @return
     */
    @PostMapping("/posts")
    public String addPost(@ModelAttribute PostSaveDto postSaveDTO) {
        Post savedPost = boardService.save(postSaveDTO);
        return "redirect:posts/" + savedPost.getId();
    }

    /**
     * 게시글 수정 페이지
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/posts/edit/{id}")
    public String editPostView(@PathVariable Long id, Model model) {
        model.addAttribute("post", boardService.findById(id));
        return "edit-post";
    }

    /**
     * 게시글 수정 API
     * @param id
     * @param post
     * @return
     */
    @PutMapping("/posts/{id}")
    public String updatePost(@PathVariable Long id, @ModelAttribute PostEditDto post) {
        boardService.edit(post);
        return "redirect:/posts/" + post.getId();
    }

    @DeleteMapping("/posts/{id}")
    public String deletePost(@PathVariable Long id) {
        boardService.delete(id);
        return "redirect:/";
    }
}
