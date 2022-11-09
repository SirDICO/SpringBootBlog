package com.dico.blogs.post.controller;


import com.dico.blogs.post.model.Post;
import com.dico.blogs.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/post")
    public String findAll(){
        return "/post/index";
    }

    @GetMapping("/post/addPost")
    public  String addPost (){
        return  "/post/addPost";
    }
    //New
    @PostMapping("/post/addPost")
    public String save (Post post){
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
    @RequestMapping(value = "/deletePost/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deletePost(@PathVariable Long id) {
        postService.DeleteById(id);
        return "redirect:/post/posts";
    }
}
