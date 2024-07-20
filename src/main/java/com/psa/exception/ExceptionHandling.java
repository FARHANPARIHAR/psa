package com.psa.exception;

import com.psa.PsaDto.ErrorDetails;
import org.springframework.aop.config.AdvisorComponentDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandling {
   @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFound(ResourceNotFound ex, WebRequest webRequest) {
       ErrorDetails error=new ErrorDetails(ex.getMessage(),new Date(),webRequest.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Exception> handleResourceNotFound(Exception ex,WebRequest webRequest) {
        ErrorDetails error=new ErrorDetails(ex.getMessage(),new Date(),webRequest.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
