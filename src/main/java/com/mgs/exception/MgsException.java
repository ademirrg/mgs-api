package com.mgs.exception;

import com.mgs.enums.ExceptionEnum;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;

@ControllerAdvice
public class MgsException extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        var fields = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String field = ((FieldError) error).getField();
            String message = ((FieldError) error).getDefaultMessage();
            fields.add(field);
            fields.add(message);
        }
        return super.handleExceptionInternal(ex, ExceptionEnum.VALID_FIELDS.getMessage() + fields, headers, status, request);
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<Object> handlerBusinessException (BusinessException ex, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), status, request);
    }
}
