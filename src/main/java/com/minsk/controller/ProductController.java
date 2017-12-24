package com.minsk.controller;

import com.minsk.DTO.ProductDTO;
import com.minsk.entity.entity.Product;
import com.minsk.service.ProductService;
import com.minsk.service.impl.ProductMapperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public @ResponseBody Product greeting() {
        return productService.createAndSaveNewProduct();
    }

    @RequestMapping(path = "/category/{id:[\\d]+}", method = RequestMethod.GET)
    public @ResponseBody List<ProductDTO> getProductsByCategory(@PathVariable("id") int id) {
        List<Product> productList = productService.getProductsByCategory(id);
        return convertProductDTO(productList);
    }


    private List<ProductDTO> convertProductDTO(List<Product> productList){
        if (productList == null)
            return null;
        List<ProductDTO> productDTOList = new ArrayList<>();
        productList.forEach(product -> productDTOList.add(ProductMapperServiceImpl.convertDTO(product)));
        return productDTOList;
    }
}
