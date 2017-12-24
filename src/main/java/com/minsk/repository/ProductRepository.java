package com.minsk.repository;

import com.minsk.entity.entity.Category;
import com.minsk.entity.entity.Product;
import com.minsk.entity.entity.ProductShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
    List<Product> findByCategory_IdEquals(int id);
}
