package com.ecommerce.shopping.ecommerceuserpannelapi.exception;

public class HeaderNotFoundExceptions extends RuntimeException {

    String resourceName;
    String resourceFieldName;
    long fieldValue;

    public HeaderNotFoundExceptions(String headerName) {
        super("required header '" + headerName + "' is not present");
    }
}
