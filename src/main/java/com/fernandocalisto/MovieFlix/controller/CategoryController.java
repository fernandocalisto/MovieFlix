package com.fernandocalisto.MovieFlix.controller;

import com.fernandocalisto.MovieFlix.entity.Category;
import com.fernandocalisto.MovieFlix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/movieflix/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @PostMapping()
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping("/{id}")
    public Category getCategoryId(@PathVariable Long id) {
        Optional<Category> optCategory = categoryService.findCategoryById(id);
        if (optCategory.isPresent()){
            return optCategory.get();
        }
        return null;
    }

}
