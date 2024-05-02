package com.ecommerce.shopping.ecommerceuserpannelapi.imples;

import com.ecommerce.shopping.ecommerceuserpannelapi.entities.AboutUs;
import com.ecommerce.shopping.ecommerceuserpannelapi.payloads.ApiResponse;
import com.ecommerce.shopping.ecommerceuserpannelapi.repositories.AboutUsDao;
import com.ecommerce.shopping.ecommerceuserpannelapi.services.AboutUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AboutUsImpl implements AboutUsService {
    @Autowired
    AboutUsDao aboutUsDao;
    @Override
    public Optional<AboutUs> getAboutUs() {
        return aboutUsDao.findFirstAboutUs();
    }
    @Override
    public ResponseEntity<ApiResponse> updateAboutUs(AboutUs aboutUs,  boolean create) {
        ApiResponse response;
        try {
            if (aboutUs == null) {
                response = new ApiResponse(HttpStatus.BAD_REQUEST, "Failed", "Request body is missing");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            aboutUs.setTitle("AboutUs");
            aboutUsDao.save(aboutUs);

            response = new ApiResponse(HttpStatus.FOUND, "Success", "About Us successfully "+ (create?"Create":"Updated"));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            response = new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Error", ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity<ApiResponse> deleteAboutUs() {
        ApiResponse response;
        try {
            Optional<AboutUs> aboutUs = aboutUsDao.findFirstAboutUs();
            if (!(aboutUs.isPresent() && !aboutUs.get().getTitle().isEmpty())) {
                response = new ApiResponse(HttpStatus.BAD_REQUEST, "Failed", "No About Us information found. Please add information before deleting.");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } else {
                aboutUsDao.deleteAll();
                response = new ApiResponse(HttpStatus.FOUND, "Success", "About Us successfully deleted.");
                return new ResponseEntity<>(response, HttpStatus.FOUND);
            }
        } catch (Exception ex) {
            response = new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Error", ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
