package com.dico.blogs.comment.controller;

import com.dico.blogs.comment.model.Comment;
import com.dico.blogs.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comment")
    public String findAll(){
        return "/comment/index";
    }

    @GetMapping("/comment/addComment")
    public  String addComment (){
        return  "/comment/addComment";
    }
    //New
    @PostMapping("/comment/addComment")
    public String save (Comment comment){
        commentService.save(comment);
        return "redirect:/comment/comments";
    }

    //update Comment
    @RequestMapping(value = "/comment/updateComment/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateComment(Comment comment) {
        commentService.save(comment);
        return "redirect:/comment/comments";
    }

    //Delete comment
    @RequestMapping(value = "/deleteComment/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteComment(@PathVariable Integer id) {
        commentService.DeleteById(id);
        return "redirect:/comment/comments";
    }
}
