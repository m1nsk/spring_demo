package com.minsk.service;

import com.minsk.entity.entity.Product;

import java.util.List;

public interface ProductService {
    Product createAndSaveNewProduct();
    List<Product> getProductsByCategory(int id);
}
