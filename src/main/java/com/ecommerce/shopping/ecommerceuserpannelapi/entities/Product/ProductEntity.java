package com.ecommerce.shopping.ecommerceuserpannelapi.entities.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name =  "product_id")
    private Long productId;
    private String productName;
    private String productCreatedAt;
    private String description;
    private Double price;
    private String category;
    private Long quantityAvailable;
    private String brand;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private Set<ProductImage> images;
    private Boolean isAvailable;
    private Boolean isFeatured;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private Set<ProductTags> tags;
    private String quantity;
    private String isPaid;
    private String isActive;
    private String discountAmount;
    private String modelNumber;
    private String more;
    private String productType;
    private String manufacturerPartNumber;
    private String reviews;
    private String totalReviews;
    private String createdAt;
    private String updatedAt;
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
