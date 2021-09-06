package com.example.payslip.exception;

import com.example.payslip.enums.ResponseStatusCode;
import com.example.payslip.dto.response.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;
import java.util.TreeMap;

@ControllerAdvice
public class PaySlipExceptionHandler {

  ResponseStatusCode responseStatus;

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = BaseHandling.class)
  public ResponseObject<Object> handleBaseException(ResponseStatusCode exception) {

    responseStatus = ResponseStatusCode.valueOf(exception.getReasonPhrase());
    return new ResponseObject<>(ResponseStatusCode.valueOf(exception.getReasonPhrase()));
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseObject<String> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException exception) {

    Map<String, String> errors = new TreeMap<>();
    exception
        .getBindingResult()
        .getAllErrors()
        .forEach(
            error -> {
              String field = ((FieldError) error).getField();
              String message = error.getDefaultMessage();
              errors.put(field, message);
            });

    return new ResponseObject<>(ResponseStatusCode.INVALID_REQUEST_PARAMETER, errors);
  }
}
