package com.minsk.service.impl;

import com.minsk.DTO.ShopDTO;
import com.minsk.entity.entity.Shop;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ShopMapperServiceImpl {

    private static final ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
    }

    public static ShopDTO convertDTO(Shop shop) {
        if (shop == null)
            return null;
        return modelMapper.map(shop, ShopDTO.class);
    }
}
