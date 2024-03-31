// package com.mpatientfile.microservicepatient.controllers;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.MethodArgumentNotValidException;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RestControllerAdvice;
// import org.springframework.web.context.request.WebRequest;

// import java.time.LocalDateTime;
// import java.util.LinkedHashMap;
// import java.util.Map;

// @RestControllerAdvice
// public class ControllerAdvice {
// @ExceptionHandler(Exception.class)
// @ResponseBody
// public ResponseEntity<Object> handlePatientNotFoundExecption(Exception ex,
// WebRequest request) {

// Map<String, Object> body = new LinkedHashMap<>();
// body.put("timestamp", LocalDateTime.now());
// body.put("message", "Patient Not Found!!!" + ex);

// return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
// }

// // @ExceptionHandler(MethodArgumentNotValidException.class)
// // public ResponseEntity<?>
// // handleValidationExceptions(MethodArgumentNotValidException ex) {
// // Map<String, Object> body = new LinkedHashMap<>();
// // body.put("timestamp", LocalDateTime.now());
// // body.put("message", "Patient Not Found!!!" + ex);

// // // handle the exception and return a response
// // return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
// // }
// }
