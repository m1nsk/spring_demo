package com.minsk.service.impl;

import com.minsk.entity.entity.Product;
import com.minsk.entity.entity.ProductShop;
import com.minsk.entity.entity.Shop;
import com.minsk.repository.InStockRepository;
import com.minsk.service.InStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("inStockService")
public class InStockServiceImpl implements InStockService {

    private InStockRepository inStockRepository;

    @Autowired
    public InStockServiceImpl(InStockRepository inStockRepository) {
        this.inStockRepository = inStockRepository;
    }

    @Override
    public int getInStock(Product product, Shop shop) {
        if(product == null && shop == null)
            return -1;
        ProductShop productShop = inStockRepository.findByProductAndShop(product.getId(), shop.getId());
        if (productShop == null) {
            return -1;
        }
        return productShop.getInStock();
    }
}
