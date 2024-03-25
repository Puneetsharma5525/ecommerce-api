package com.ecommerce.shopping.ecommerceuserpannelapi.imples;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.ProductCategory;
import com.ecommerce.shopping.ecommerceuserpannelapi.repositories.ProductCategoryDao;
import com.ecommerce.shopping.ecommerceuserpannelapi.services.ProductCategoryServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryImpl implements ProductCategoryServices {
    @Autowired
    ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategory> productCategory() {
        return productCategoryDao.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public ProductCategory postProductCategory(ProductCategory productCategory) {
        productCategoryDao.save(productCategory);
        return productCategory;
    }
}
