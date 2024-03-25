package com.ecommerce.shopping.ecommerceuserpannelapi.entities;

import jakarta.persistence.Column;
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
@Table(name = "TermsAndConditions")
public class TermsAndConditions {
    @Id
    private long id;
    private String title;
    @Column(name = "description", length = 10000)
    private String desc;
}
