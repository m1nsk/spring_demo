package com.minsk.service.impl;

import com.minsk.entity.entity.ProductShop;
import com.minsk.entity.entity.Shop;
import com.minsk.repository.InStockRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.minsk.entity.entity.Product;
import com.minsk.repository.ProductRepository;
import com.minsk.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class InStockServiceImplTest {

    private static final int PRODUCT_ID = 10;
    private static final int SHOP_ID = 20;
    private static final int IN_STOCK = 1200;
    public static final int WRONG_PRODUCT_ID = 121;

    @Mock
    private InStockRepository inStockRepository;

    @InjectMocks
    private InStockServiceImpl inStockService;

    @Mock
    private ProductShop productShop;
    @Mock
    private Product product;
    @Mock
    private Shop shop;

    @Before
    public void setUp() throws Exception {
        when(inStockRepository.findByProductAndShop(PRODUCT_ID, SHOP_ID)).thenReturn(productShop);
        when(productShop.getInStock()).thenReturn(IN_STOCK);
        when(product.getId()).thenReturn(PRODUCT_ID);
        when(shop.getId()).thenReturn(SHOP_ID);

    }

    @Test
    public void getInStock_success() throws Exception {
        //given
        //when
        int inStock = inStockService.getInStock(product, shop);
        //then
        assertEquals(IN_STOCK, inStock);
    }

    @Test
    public void getInStock_item_not_exist() throws Exception {
        //given
        when(product.getId()).thenReturn(WRONG_PRODUCT_ID);
        when(inStockRepository.findByProductAndShop(WRONG_PRODUCT_ID, SHOP_ID)).thenReturn(null);
        //when
        int inStock = inStockService.getInStock(product, shop);
        assertEquals(inStock, -1);
        //then
    }

}