package com.decode9.inventory.controllers;

import java.util.List;
import java.util.Optional;

import com.decode9.inventory.models.CategoryModel;
import com.decode9.inventory.repository.CategoryRepository;
import com.decode9.inventory.utils.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.validation.annotation.Validated;

@RestController
public class CategoryController{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/category/all")
    ApiResponse all(){
        try {
            List<CategoryModel> categories = categoryRepository.findAll();
            ApiResponse response = new ApiResponse("success", categories);
            return response;
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("failure", e.getMessage());
            return response;
        }
    }

    @GetMapping("/category/{id}")
    ApiResponse getCategory(@PathVariable Long id){
        try {
            Optional<CategoryModel> category = categoryRepository.findById(id);
            ApiResponse response = new ApiResponse("success", category);
            return response;
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("failure", e.getMessage());
            return response;
        }
    }

    @PostMapping("/category")
    ApiResponse saveCategory(@Validated(CategoryModel.PostValidation.class) @RequestBody CategoryModel category){
        try {
            CategoryModel categorySave = categoryRepository.save(category);
            ApiResponse response = new ApiResponse("success", categorySave);
            return response;
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("failure", e.getMessage());
            return response;
        }
    }

    @PutMapping("/category")
    ApiResponse updateCategory(@Validated(CategoryModel.PutValidation.class) @RequestBody CategoryModel category){
        try {
            Optional<CategoryModel> consultCategory = categoryRepository.findById(category.getId());
            CategoryModel oldCategory = consultCategory.get();
            oldCategory.setName(category.getName());
            CategoryModel categoryUpdate = categoryRepository.save(oldCategory);
            ApiResponse response = new ApiResponse("success", categoryUpdate);
            return response;
        } catch (Exception e) {
            ApiResponse response = new ApiResponse("failure", e.getMessage());
            return response;
        }
    }

}