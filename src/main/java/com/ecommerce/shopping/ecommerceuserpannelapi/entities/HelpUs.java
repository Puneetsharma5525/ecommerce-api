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
@Table(name = "Help_us")
public class HelpUs {
    @Id
    @Column(nullable = false)
    private long id;
    @Column(name = "title")
    private String title;

    @Column(name = "Url", length = 2000)
    private String Url;
    @Column(name = "description", length = 10000)
    private String desc;
}
