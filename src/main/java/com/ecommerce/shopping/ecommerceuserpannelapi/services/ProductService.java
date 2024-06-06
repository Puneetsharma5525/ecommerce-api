package com.ecommerce.shopping.ecommerceuserpannelapi.services;
import org.springframework.stereotype.Service;

@Service
interface  ProductService {
    default void  addProduct(){}
    default void  removeProduct(){}
    default void  showProduct(){}
}
