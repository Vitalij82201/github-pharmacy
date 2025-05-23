package org.hstn.pharmacy.service.validation.handler;

import org.hstn.pharmacy.service.validation.dto.ValidationErrorDto;
import org.hstn.pharmacy.service.validation.dto.ValidationErrorsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorsDto> handleValidationException(MethodArgumentNotValidException e) {

        List<ValidationErrorDto> validationErrors = new ArrayList<>();

        List<ObjectError> errors = e.getBindingResult().getAllErrors();

        for (ObjectError error : errors) {
            FieldError fieldError = (FieldError)error;
            ValidationErrorDto errorDto = ValidationErrorDto.builder()
                    .field(fieldError.getField())
                    .message(fieldError.getDefaultMessage())
                    .build();

            if (fieldError.getRejectedValue() != null) {
                errorDto.setRejectedValue(fieldError.getRejectedValue().toString());
            }

            validationErrors.add(errorDto);
        }

        return ResponseEntity
                .badRequest()
                .body(ValidationErrorsDto.builder()
                        .errors(validationErrors)
                        .build());
    }
}
