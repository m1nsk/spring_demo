package com.minsk.service;

import com.minsk.entity.entity.Product;
import com.minsk.entity.entity.Shop;

public interface InStockService {

    /**
     *
     * @param product - product to check amount of
     * @param shop - shop to check amount in
     * @return amount of products in provided shop
     */
    int getInStock(Product product, Shop shop);
}
