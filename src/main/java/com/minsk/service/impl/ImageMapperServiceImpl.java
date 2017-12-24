package com.minsk.service.impl;

import com.minsk.DTO.ImageDTO;
import com.minsk.entity.entity.Image;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ImageMapperServiceImpl {

    private static final ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
    }

    public static ImageDTO convertDTO(Image image) {
        if (image == null)
            return null;
        return modelMapper.map(image, ImageDTO.class);
    }
}
