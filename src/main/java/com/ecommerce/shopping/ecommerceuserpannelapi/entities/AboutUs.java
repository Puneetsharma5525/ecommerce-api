package com.ecommerce.shopping.ecommerceuserpannelapi.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "about_us")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AboutUs {
    @Id
    @Column(name = "title")
    private String title;
    @Column(name = "description", columnDefinition = "TEXT")
    private String desc;


}

