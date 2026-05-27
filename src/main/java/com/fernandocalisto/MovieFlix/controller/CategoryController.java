package com.fernandocalisto.MovieFlix.controller;

import com.fernandocalisto.MovieFlix.entity.Category;
import com.fernandocalisto.MovieFlix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/movieflix/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

}
