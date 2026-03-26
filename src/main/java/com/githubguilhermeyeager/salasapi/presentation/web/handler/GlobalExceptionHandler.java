package com.githubguilhermeyeager.salasapi.presentation.web.handler;

import com.githubguilhermeyeager.salasapi.application.dtos.DefaultGenericResponseDto;
import com.githubguilhermeyeager.salasapi.application.dtos.FieldErrorResponseDto;
import com.githubguilhermeyeager.salasapi.domain.exceptions.ConflictException;
import com.githubguilhermeyeager.salasapi.domain.exceptions.NotFoundException;
import com.githubguilhermeyeager.salasapi.infrastructure.exceptions.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<DefaultGenericResponseDto<String>> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest()
                .body(DefaultGenericResponseDto.error(ex.getMessage()));
    }

    @ExceptionHandler(JwtException.class)
    ResponseEntity<DefaultGenericResponseDto<Object>> handleJwt(JwtException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(DefaultGenericResponseDto.error(ex.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<DefaultGenericResponseDto<Object>> handleNotFound(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(DefaultGenericResponseDto.error(ex.getMessage()));
    }

    @ExceptionHandler(ConflictException.class)
    ResponseEntity<DefaultGenericResponseDto<Object>> handleConflict(ConflictException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(DefaultGenericResponseDto.error(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<DefaultGenericResponseDto<List<FieldErrorResponseDto>>> handleValidation(MethodArgumentNotValidException  ex) {
        List<FieldErrorResponseDto> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new FieldErrorResponseDto(error.getField(), error.getDefaultMessage()))
                .toList();

        DefaultGenericResponseDto<List<FieldErrorResponseDto>> response = new DefaultGenericResponseDto<>(
                false,
                "Um ou mais campos estão com problemas.",
                LocalDateTime.now(),
                errors
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
