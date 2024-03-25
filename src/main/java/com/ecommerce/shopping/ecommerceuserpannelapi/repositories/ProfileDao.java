package com.ecommerce.shopping.ecommerceuserpannelapi.repositories;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProfileDao extends JpaRepository<Profile,Long> {

}
