package com.ecommerce.shopping.ecommerceuserpannelapi.repositories;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.Product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity,Long> {
}
