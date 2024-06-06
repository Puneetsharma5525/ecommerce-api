package com.ecommerce.shopping.ecommerceuserpannelapi.Authentication;

import com.ecommerce.shopping.ecommerceuserpannelapi.repositories.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailsServicesImpl implements UserDetailsService {
    private final UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       var user =  userDao.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("Username Not Found"));
        return new User(user.getEmail(),user.getPassWord(),user.getAuthorities());
    }
}
