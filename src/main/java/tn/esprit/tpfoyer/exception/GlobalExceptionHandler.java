package tn.esprit.tpfoyer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<Map<String, Object>> handleResourceNotFound(ResourceNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
        "timestamp", Instant.now().toString(),
        "status", HttpStatus.NOT_FOUND.value(),
        "error", "Not Found",
        "message", ex.getMessage()
    ));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
    Map<String, String> fieldErrors = new LinkedHashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(error ->
        fieldErrors.put(error.getField(), error.getDefaultMessage()));

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
        "timestamp", Instant.now().toString(),
        "status", HttpStatus.BAD_REQUEST.value(),
        "error", "Bad Request",
        "message", "Validation failed",
        "details", fieldErrors
    ));
  }
}
