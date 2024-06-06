package com.ecommerce.shopping.ecommerceuserpannelapi.entities.Product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ProductImage")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productImageId;
    private String image;
    private String title;
    private String description;
    private String createdAt;
    private String updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @PrePersist
    public void prePersist() {
        String current = LocalDateTime.now().toString();
        this.createdAt = current;
        this.updatedAt = current;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now().toString();
    }
}
