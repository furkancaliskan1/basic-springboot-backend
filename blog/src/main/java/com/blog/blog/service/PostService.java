package com.blog.blog.service;

import com.blog.blog.model.PostModel;
import com.blog.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// CRUD CREATE READ UPDATE DELETE
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public PostModel createPost(PostModel postModel){
        return postRepository.save(postModel);
    }

    public List<PostModel> findAll() {
        return postRepository.findAll();
    }

    public PostModel findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public PostModel updatePost(Long id, PostModel updatedPost){
        Optional<PostModel> existingPostOptional = postRepository.findById(id);
        if (existingPostOptional.isPresent()) {
            PostModel existingPost = existingPostOptional.get();
            existingPost.setTitle(updatedPost.getTitle());
            existingPost.setContent(updatedPost.getContent());
            return postRepository.save(existingPost);
        }
        else {
            throw new RuntimeException("Post not found with id: " +id);
        }
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
