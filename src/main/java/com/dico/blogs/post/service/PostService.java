package com.dico.blogs.post.service;

import com.dico.blogs.category.model.Category;
import com.dico.blogs.category.repository.CategoryRepository;
import com.dico.blogs.post.model.Post;
import com.dico.blogs.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    //find all Post
    public List<Post> findAll(){
        return postRepository.findAll();
    }

    //find Post By Id
    public Post findById(Integer id){
        return postRepository.findById(id).orElse(null);
    }

    //Save
    public Post save(Post post){
      Post posts =  postRepository.save(post);
        return posts;
    }

    //Delete by Id
    public void DeleteById(Integer id){
        postRepository.deleteById(id);
    }
}
