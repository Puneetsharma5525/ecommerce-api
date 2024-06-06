package com.ecommerce.shopping.ecommerceuserpannelapi.repositories;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.UserEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<UserEntities, Long> {
    Optional<UserEntities> findByEmail(String email);

}
