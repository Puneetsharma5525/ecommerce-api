package com.ecommerce.shopping.ecommerceuserpannelapi.repositories;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.AboutUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AboutUsDao extends JpaRepository<AboutUs,String> {
    @Query("SELECT a FROM AboutUs a ORDER BY a.title ASC")
    Optional<AboutUs> findFirstAboutUs();
    @Modifying
    @Query("INSERT INTO AboutUs ( desc, title) VALUES ( :desc, :title)")
    void insertAboutUs( @Param("desc") String desc, @Param("title") String title);

}
