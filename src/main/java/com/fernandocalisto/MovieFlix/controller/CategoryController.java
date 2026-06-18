package com.fernandocalisto.MovieFlix.controller;

import com.fernandocalisto.MovieFlix.controller.request.CategoryRequest;
import com.fernandocalisto.MovieFlix.controller.response.CategoryResponse;
import com.fernandocalisto.MovieFlix.entity.Category;
import com.fernandocalisto.MovieFlix.mapper.CategoryMapper;
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
    public List<CategoryResponse> getAllCategories() {
        List<Category> category = categoryService.findAll();
        return category.stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();
    }

    @PostMapping()
    public CategoryResponse saveCategory(@RequestBody CategoryRequest category) {
        Category newCategory = CategoryMapper.toCategory(category);
        Category savedCategory = categoryService.saveCategory(newCategory);
        return CategoryMapper.toCategoryResponse(savedCategory);
    }

    @GetMapping("/{id}")
    public CategoryResponse getCategoryId(@PathVariable Long id) {
        Optional<Category> optCategory = categoryService.findCategoryById(id);
        if (optCategory.isPresent()){
            return CategoryMapper.toCategoryResponse(optCategory.get());
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCategotyById(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
    }

}
