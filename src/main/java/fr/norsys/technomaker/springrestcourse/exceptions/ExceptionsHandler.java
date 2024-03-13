package fr.norsys.technomaker.springrestcourse.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ExceptionMessageResponse> handleBookNotFoundException(BookNotFoundException exception) {
        ExceptionMessageResponse messageResponse =
                ExceptionMessageResponse.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.NOT_FOUND)
                        .timestamp(new Timestamp(System.currentTimeMillis()))
                        .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(messageResponse);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionMessageResponse> handleConstraintViolationException(ConstraintViolationException exception) {
        ConstraintViolation<?> constraintViolation = exception.getConstraintViolations().stream()
                .findFirst().get();
        ExceptionMessageResponse messageResponse =
                ExceptionMessageResponse.builder()
                        .message(constraintViolation.getMessageTemplate())
                        .status(HttpStatus.NOT_ACCEPTABLE)
                        .timestamp(new Timestamp(System.currentTimeMillis()))
                        .build();
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(messageResponse);
    }

}
