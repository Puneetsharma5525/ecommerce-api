package com.ecommerce.shopping.ecommerceuserpannelapi.Authentication;
import com.ecommerce.shopping.ecommerceuserpannelapi.entities.UserEntities;
import com.ecommerce.shopping.ecommerceuserpannelapi.payloads.ApiResponseObject;
import com.ecommerce.shopping.ecommerceuserpannelapi.repositories.UserDao;
import com.ecommerce.shopping.ecommerceuserpannelapi.services.AuthenticationService;
import com.ecommerce.shopping.ecommerceuserpannelapi.utils.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthenticationService {
    @Autowired
    private  final AuthenticationManager authenticationManager;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final UserDao userDao;
    @Override
    public ApiResponseObject login(String email, String password) {
        try {
            var authToken = new UsernamePasswordAuthenticationToken(email, password);
            System.out.println("Sout 1");
            var authentication = authenticationManager.authenticate(authToken);
            System.out.println("Sout 2");
            // Generate Token
            var userName = ((UserDetails) (authentication.getPrincipal())).getUsername();
            System.out.println("Sout 3");
            String token = JWTUtils.generatedToken(userName);
            System.out.println("Sout 4");
            System.out.println("Sout 5");

            System.out.println("Sout 6");

            var authResponseDto = new AuthResponseDto(token, email,null);

            System.out.println("Sout 7");
            return new ApiResponseObject<>(HttpStatus.OK, "Register SuccessFully", "valid", authResponseDto);
        }catch (Exception e){
        System.out.println("Error PUneet ji");
        return new ApiResponseObject<>(HttpStatus.BAD_REQUEST, e.toString(), "Invalid", null);
    }
    }

    @Override
    public ApiResponseObject<AuthResponseDto> signUp(String userName, String email, String password, String mobile) {
      try{
          // Check whether user already exists or not
          Optional<UserEntities> optionalUserEntities = userDao.findByEmail(email);
          if(optionalUserEntities.isPresent()){
              throw new RuntimeException("User already exists");
          }
          // authorities
          var authorities = new ArrayList<GrantedAuthority>();
         authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

          // Encode password
          var encodedPassword = passwordEncoder.encode(password);

          // Generate Token
          String token = JWTUtils.generatedToken(email);
          var userEntities =  UserEntities.builder().
                  username(userName)
                  .passWord(encodedPassword)
                  .email(email)
                  .mobile(mobile).accessToken(token)
                .authorities(authorities)
                  .build();
          // Save user
          userDao.save(userEntities);

          var authResponseDto = new AuthResponseDto(token, email,mobile);
          return new ApiResponseObject<>(HttpStatus.OK, "Register SuccessFully", "valid", authResponseDto);

      }catch (Exception e){
          System.out.println("Error PUneet ji");
          return new ApiResponseObject<>(HttpStatus.BAD_REQUEST, e.toString(), "Invalid", null);
      }
    }
}
