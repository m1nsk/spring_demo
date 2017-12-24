package com.minsk.controller;

import com.minsk.DTO.CategoryDTO;
import com.minsk.entity.entity.Category;
import com.minsk.service.CategoryService;
import com.minsk.service.impl.CategoryMapperServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final ModelMapper modelMapper;

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        modelMapper = new ModelMapper();
        this.categoryService = categoryService;
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public @ResponseBody List<CategoryDTO> categories(){
        List<Category> categoryList = categoryService.getCategoryList();
        return categoryList.stream().map(category -> CategoryMapperServiceImpl.convertDTO(category)).collect(Collectors.toList());
    }

    @RequestMapping(path = "/{id:[\\d]+}", method = RequestMethod.GET)
    @ResponseBody
    public CategoryDTO categoryById(@PathVariable("id") int id){
        Category category = categoryService.getCategoryById(id);
        return CategoryMapperServiceImpl.convertDTO(category);
    }
}
