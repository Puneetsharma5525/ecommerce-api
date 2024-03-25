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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Profile")
public class Profile {
    @Id
    private long id;
    private String bgImage;
    private String profileImage;
    @Column(nullable = false)
    private String phoneNumber;
    private String address;
    private String name;
    private String dob;
    @Column(nullable = false)
    private String email;
}
