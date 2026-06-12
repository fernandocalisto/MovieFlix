package com.fernandocalisto.MovieFlix.service;

import com.fernandocalisto.MovieFlix.entity.Category;
import com.fernandocalisto.MovieFlix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category saveCategory (Category category) {
        return repository.save(category);
    }

    public Optional<Category> findCategoryById (Long id) {
        return repository.findById(id);
    }

}
