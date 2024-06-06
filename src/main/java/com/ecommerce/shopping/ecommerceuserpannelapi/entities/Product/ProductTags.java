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
@Table(name = "ProductTags")
public class ProductTags {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productTagsId;

    private String tagName;

    private String tagDescription;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductEntity product;

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
