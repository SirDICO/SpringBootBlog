package com.dico.blogs.category.service;

import com.dico.blogs.category.model.Category;
import com.dico.blogs.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //find all Category
    public List<Category> findAll(){
      return categoryRepository.findAll();
    }

    //find Category By Id
    public Category findById(Integer id){
        return categoryRepository.findById(id).orElse(null);
    }

    //Save
    public Category save(Category category){
        categoryRepository.save(category);
        return category;
    }

    //Delete by Id
    public void DeleteById(Integer id){
         categoryRepository.deleteById(id);
}
}
