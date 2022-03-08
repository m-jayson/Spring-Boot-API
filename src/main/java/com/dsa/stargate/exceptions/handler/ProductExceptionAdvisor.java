package com.dsa.stargate.exceptions.handler;

import com.dsa.stargate.exceptions.ProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProductExceptionAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorMessage> handleProductNotFound(ProductException e){
        var notFound = HttpStatus.NOT_FOUND;
        var errorMessage = ErrorMessage.builder()
                .status(notFound)
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(errorMessage, notFound);
    }
}
