package com.dico.blogs.category.controller;

import com.dico.blogs.category.model.Category;
import com.dico.blogs.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public String findAll(){
        return "/category/index";
    }

    @GetMapping("/category/categories")
    public  String categories (Model model){
      model.addAttribute("categories", categoryService.findAll());
     return  "/category/categories";
    }

    @GetMapping("/category/addCategory")
    public  String addCategory (){
        return  "/category/addCategory";
    }
    //New
    @PostMapping("/category/addCategory")
    public String save (Category category, Model model){
        categoryService.save(category);
        return "redirect:/category/categories";
    }
    @GetMapping("/category/editCategory/{id}")
    public String editCategoryRoute(Model model , @PathVariable Integer id ){
        model.addAttribute("category", categoryService.findById(id));
        return "/category/editCategory";
    }
    //update Category
    @RequestMapping(value = "/category/updateCategory/{id}",
            method = {RequestMethod.GET, RequestMethod.PUT})
    public String updateCategory(Category category) {
        categoryService.save(category);
        return "redirect:/category/categories";
    }

    //Delete Category
    @RequestMapping(value = "/category/deleteCategory/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteCategory(@PathVariable Integer id) {
        categoryService.DeleteById(id);
        return "redirect:/category/categories";
    }
}
