package com.github.raphaelfontoura.registerclients.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFoundException(EntityNotFoundException e, HttpServletRequest request) {
        var status = HttpStatus.NOT_FOUND;
        var err = new StandardError(
                Instant.now(),
                status.value(),
                e.getMessage(),
                request.getRequestURI(),
                e.getMessage()
        );
        return ResponseEntity.status(status).body(err);
    }


}
