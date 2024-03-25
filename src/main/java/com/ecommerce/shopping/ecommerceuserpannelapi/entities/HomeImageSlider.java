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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HomeImageSlider")
public class HomeImageSlider {
    @Id
    private long id;
    private String name;
    private String url;
}
