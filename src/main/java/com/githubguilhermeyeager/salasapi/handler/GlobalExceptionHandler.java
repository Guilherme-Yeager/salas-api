package com.githubguilhermeyeager.salasapi.handler;

import com.githubguilhermeyeager.salasapi.application.dtos.DefaultGenericResponse;
import com.githubguilhermeyeager.salasapi.application.dtos.FieldErrorResponse;
import com.githubguilhermeyeager.salasapi.domain.exceptions.ConflictException;
import com.githubguilhermeyeager.salasapi.domain.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<DefaultGenericResponse<Object>> handleNotFound(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(DefaultGenericResponse.error(ex.getMessage()));
    }

    @ExceptionHandler(ConflictException.class)
    ResponseEntity<DefaultGenericResponse<Object>> handleConflict(ConflictException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(DefaultGenericResponse.error(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<DefaultGenericResponse<List<FieldErrorResponse>>> handleValidation(MethodArgumentNotValidException  ex) {
        List<FieldErrorResponse> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new FieldErrorResponse(error.getField(), error.getDefaultMessage()))
                .toList();

        DefaultGenericResponse<List<FieldErrorResponse>> response = new DefaultGenericResponse<>(
                false,
                "Um ou mais campos estão com problemas.",
                LocalDateTime.now(),
                errors
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
