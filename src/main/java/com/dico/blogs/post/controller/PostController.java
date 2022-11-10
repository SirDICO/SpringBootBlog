package com.dico.blogs.post.controller;


import com.dico.blogs.category.service.CategoryService;
import com.dico.blogs.post.model.Post;
import com.dico.blogs.post.service.PostService;
import com.dico.blogs.user.model.User;
import com.dico.blogs.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/post")
    public String findAll(){
        return "/post/index";
    }
    @GetMapping("/post/posts")
    public String findAllPost(Model model){
        model.addAttribute("posts", postService.findAll());
        return "/post/posts";
    }
    @GetMapping("/post/editPost/{id}")
    public String editPost(Model model, @PathVariable Integer id){
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("post", postService.findById(id));
        return "/post/editPost";
    }

    @GetMapping("/post/addPost")
    public  String addPost (Model model){
//        model.addAttribute("userId", information.getUser());
        model.addAttribute("categories", categoryService.findAll());
        return  "/post/addPost";
    }

    //New
    @PostMapping("/post/addPost")
    public String save (Post post, Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        post.setUser_id(Math.toIntExact(user.getId()));
        post.setUpdateDate(LocalDateTime.now());
        postService.save(post);
        return "redirect:/post/posts";
    }

    //update Post
    @RequestMapping(value = "/post/updatePost/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String updatePost(Post post) {
        postService.save(post);
        return "redirect:/post/posts";
    }

    //Delete Post
    @RequestMapping(value = "/post/deletePost/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deletePost(@PathVariable Integer id) {
        postService.DeleteById(id);
        return "redirect:/post/posts";
    }
}
