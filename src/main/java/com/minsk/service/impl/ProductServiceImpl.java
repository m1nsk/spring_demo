package com.minsk.service.impl;

import com.minsk.entity.entity.Category;
import com.minsk.entity.entity.Image;
import com.minsk.entity.entity.Product;
import com.minsk.repository.ProductRepository;
import com.minsk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createAndSaveNewProduct() {
        Product product = new Product(
                "New Product",
                "Description",
                new BigDecimal(100),
                new BigDecimal(100),
                true,
                null,
                new Image("image")
                );
        productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> getProductsByCategory(int id) {
        List<Product> productList = productRepository.findByCategory_IdEquals(id);
        return productList;
    }
}
