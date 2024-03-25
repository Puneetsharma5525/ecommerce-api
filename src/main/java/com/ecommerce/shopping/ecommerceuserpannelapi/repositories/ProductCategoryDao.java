package com.ecommerce.shopping.ecommerceuserpannelapi.repositories;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Long> {
}
