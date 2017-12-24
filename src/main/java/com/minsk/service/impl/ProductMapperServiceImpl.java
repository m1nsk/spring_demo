package com.minsk.service.impl;

import com.minsk.DTO.CategoryDTO;
import com.minsk.DTO.ImageDTO;
import com.minsk.DTO.ProductDTO;
import com.minsk.entity.entity.Image;
import com.minsk.entity.entity.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by korolm on 24.12.2017.
 */
@Service
public class ProductMapperServiceImpl{

    private static final ModelMapper modelMapper;

    private static final TypeMap<Product, ProductDTO> typeMap;

    static {
        modelMapper = new ModelMapper();
        typeMap = modelMapper.createTypeMap(Product.class, ProductDTO.class);
        typeMap.addMappings(mapper -> mapper.skip(ProductDTO::setCategory));
        typeMap.addMappings(mapper -> mapper.skip(ProductDTO::setImage));
        typeMap.addMappings(mapper -> mapper.skip(ProductDTO::setImages));
    }

    public static ProductDTO convertDTO(Product product) {
        if (product == null)
            return null;
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        productDTO.setCategory(CategoryMapperServiceImpl.convertDTO(product.getCategory()));
        productDTO.setImage(ImageMapperServiceImpl.convertDTO(product.getImage()));
        Set<Image> imageSet = product.getImages();
        Set<ImageDTO> imageDTOSet = new HashSet<>();
        imageSet.forEach(image -> imageDTOSet.add(ImageMapperServiceImpl.convertDTO(image)));
        productDTO.setImages(imageDTOSet);
        return productDTO;
    }
}
