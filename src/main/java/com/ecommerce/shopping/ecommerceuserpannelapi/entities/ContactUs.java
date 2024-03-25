package com.ecommerce.shopping.ecommerceuserpannelapi.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContactUs {
    @Id
    private String id;
    private String title;
    private String des;
}
