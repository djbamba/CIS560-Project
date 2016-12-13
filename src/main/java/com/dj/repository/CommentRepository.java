package com.dj.repository;

import com.dj.model.Comment;
import com.dj.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {

//    Comment findByGame(Game game);
}
