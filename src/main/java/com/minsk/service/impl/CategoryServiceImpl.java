package com.minsk.service.impl;

import com.minsk.entity.entity.Category;
import com.minsk.repository.CategoryRepository;
import com.minsk.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategoryById(int id) {
        Category category = categoryRepository.getOne(id);
        return categoryRepository.getOne(id);
    }

    @Override
    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }
}
