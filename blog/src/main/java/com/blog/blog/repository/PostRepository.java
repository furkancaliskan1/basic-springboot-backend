package com.blog.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blog.blog.model.PostModel;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostModel,Long> {

}
