package com.maranata.xenia.infra;

import com.maranata.xenia.exception.ResourceAlreadyExistsException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    private ResponseEntity<RestErrorMessage> resourceAlreadyExistsHandler(ResourceAlreadyExistsException exception, HttpServletRequest request) {

        HttpStatus status = HttpStatus.CONFLICT;

        RestErrorMessage threatResponse = new RestErrorMessage(
                Instant.now(),
                status.value(),
                "Data conflict",
                exception.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(409).body(threatResponse);
    }

}
