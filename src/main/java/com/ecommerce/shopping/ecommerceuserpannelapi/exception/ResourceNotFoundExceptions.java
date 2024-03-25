package com.ecommerce.shopping.ecommerceuserpannelapi.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundExceptions extends RuntimeException {
    String resourceName;
    String resourceFieldName;
    long fieldValue;

    public ResourceNotFoundExceptions(String message, String resourceName, long fieldValue) {
        super(String.format("%s not found with %s : %s",resourceName,fieldValue,message));
        this.resourceName = resourceName;
        this.resourceFieldName = resourceFieldName;
        this.fieldValue = fieldValue;
    }
}
