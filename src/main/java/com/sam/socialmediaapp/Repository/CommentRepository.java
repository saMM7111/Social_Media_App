package com.sam.socialmediaapp.Repository;

import com.sam.socialmediaapp.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
