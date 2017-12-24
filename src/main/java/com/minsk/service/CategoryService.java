package com.minsk.service;

import com.minsk.entity.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategoryList();
    Category getCategoryById(int id);
}
