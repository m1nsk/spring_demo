package com.minsk.service.impl;

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

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void createAndSaveNewProduct() throws Exception {
        //given

        //when
        Product result = productService.createAndSaveNewProduct();
        //then
        verify(productRepository).save(result);
        assertEquals("New Product", result.getName());
        verifyNoMoreInteractions(productRepository);
    }

}