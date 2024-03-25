package com.ecommerce.shopping.ecommerceuserpannelapi.services;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.ProductCategory;

import java.util.List;

public interface ProductCategoryServices {
    List<ProductCategory> productCategory();

    ProductCategory postProductCategory(ProductCategory productCategory);
}
