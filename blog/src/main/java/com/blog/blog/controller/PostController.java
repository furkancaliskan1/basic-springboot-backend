package com.blog.blog.controller;

import com.blog.blog.model.PostModel;
import com.blog.blog.repository.PostRepository;
import com.blog.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostModel> showPosts() {
        return postService.findAll();
    }
    @GetMapping("/{id}")
    public PostModel showPostById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @PostMapping
    public PostModel createPost(@RequestBody PostModel newPost) {
        return postService.createPost(newPost);
    }
    @PutMapping("/{id}")
    public PostModel updatePost(@PathVariable Long id, @RequestBody PostModel updatedPost) {
        return postService.updatePost(id,updatedPost);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
