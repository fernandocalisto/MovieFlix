package com.fernandocalisto.MovieFlix.controller;

import com.fernandocalisto.MovieFlix.controller.request.CategoryRequest;
import com.fernandocalisto.MovieFlix.controller.response.CategoryResponse;
import com.fernandocalisto.MovieFlix.entity.Category;
import com.fernandocalisto.MovieFlix.mapper.CategoryMapper;
import com.fernandocalisto.MovieFlix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/movieflix/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<Category> category = categoryService.findAll();
        List<CategoryResponse> list = category.stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping()
    public ResponseEntity<CategoryResponse> saveCategory(@RequestBody CategoryRequest category) {
        Category newCategory = CategoryMapper.toCategory(category);
        Category savedCategory = categoryService.saveCategory(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(savedCategory));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryId(@PathVariable Long id) {
        return categoryService.findCategoryById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategotyById(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
