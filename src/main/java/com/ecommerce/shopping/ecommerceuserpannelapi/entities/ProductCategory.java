package com.ecommerce.shopping.ecommerceuserpannelapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ProductCategory")
public class ProductCategory {
    @Id
    private String Id;
    private String Name;
    private String Description;
    private String Img;
    private String Price;
}
