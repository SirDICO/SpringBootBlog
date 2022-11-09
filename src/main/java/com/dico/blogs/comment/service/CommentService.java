package com.dico.blogs.comment.service;

import com.dico.blogs.category.model.Category;
import com.dico.blogs.category.repository.CategoryRepository;
import com.dico.blogs.comment.model.Comment;
import com.dico.blogs.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    //find all Category
    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    //find Category By Id
    public Comment findById(Integer id){
        return commentRepository.findById(id).orElse(null);
    }

    //Save
    public Comment save(Comment comment){
       Comment comment1 =  commentRepository.save(comment);
        return comment1;
    }
    
    //Delete by Id
    public void DeleteById(Integer id){
        commentRepository.deleteById(id);
    }
}
