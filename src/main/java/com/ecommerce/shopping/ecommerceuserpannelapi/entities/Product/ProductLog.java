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
@Table(name = "ProductLogs")
public class ProductLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productLogId;

    private Long productId;

    private String logMessage;

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
