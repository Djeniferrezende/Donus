package com.desafioContaBancaria.ContaBancaria.resource.exceptions;

import com.desafioContaBancaria.ContaBancaria.service.exceptions.DatabaseException;
import com.desafioContaBancaria.ContaBancaria.service.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

public class ResourceExceptionHandle {



    @ControllerAdvice
    public class ResourceExceptionHandler {

        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<com.djeniModas.Modas.Resource.exceptions.StandardError> notfoundException(ResourceNotFoundException e, HttpServletRequest request) {
            String error = "Resource not found";
            HttpStatus status = HttpStatus.NOT_FOUND;
            com.djeniModas.Modas.Resource.exceptions.StandardError err = new com.djeniModas.Modas.Resource.exceptions.StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
            return ResponseEntity.status(status).body(err);

        }

        @ExceptionHandler(DatabaseException.class)
        public ResponseEntity<com.djeniModas.Modas.Resource.exceptions.StandardError> dataBaseException(DatabaseException e, HttpServletRequest request) {
            String error = "DataBase not found";
            HttpStatus status = HttpStatus.BAD_REQUEST;
            com.djeniModas.Modas.Resource.exceptions.StandardError err = new com.djeniModas.Modas.Resource.exceptions.StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
            return ResponseEntity.status(status).body(err);

        }

        @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<com.djeniModas.Modas.Resource.exceptions.StandardError> illegaArgumentException(IllegalArgumentException e, HttpServletRequest request) {
            String error = "informações invalidas";
            HttpStatus status = HttpStatus.BAD_REQUEST;
            com.djeniModas.Modas.Resource.exceptions.StandardError err = new com.djeniModas.Modas.Resource.exceptions.StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
            return ResponseEntity.status(status).body(err);

        }
    }
}
