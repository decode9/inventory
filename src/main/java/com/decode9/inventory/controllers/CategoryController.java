package com.decode9.inventory.controllers;

import com.decode9.inventory.models.CategoryModel;
import com.decode9.inventory.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CategoryController{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/category/all")
    Iterable<CategoryModel> all(){
        return categoryRepository.findAll();
    }

    @GetMapping("/category/{id}")
    CategoryModel getCategory(@PathVariable Long id){
        return categoryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/category/save")
    CategoryModel saveCategory(@RequestBody CategoryModel category){
        return categoryRepository.save(category);
    }

}