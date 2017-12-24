package com.minsk.service.impl;

import com.minsk.DTO.CategoryDTO;
import com.minsk.DTO.ImageDTO;
import com.minsk.entity.entity.Category;
import com.minsk.entity.entity.Image;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapperServiceImpl {

    private static final ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
    }

    public static CategoryDTO convertDTO(Category category) {
        if (category == null)
            return null;
        return modelMapper.map(category, CategoryDTO.class);
    }
}
