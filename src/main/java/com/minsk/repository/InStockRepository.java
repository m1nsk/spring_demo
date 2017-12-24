package com.minsk.repository;

import com.minsk.entity.entity.ProductShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InStockRepository extends JpaRepository<ProductShop, Integer>{
    @Query("select ps from ProductShop ps where ps.product = ?1 and ps.shop= ?2")
    ProductShop findByProductAndShop(int productId, int shopId);
}
