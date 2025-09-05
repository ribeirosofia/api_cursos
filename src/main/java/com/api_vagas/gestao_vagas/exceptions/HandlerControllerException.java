package com.api_vagas.gestao_vagas.exceptions;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class HandlerControllerException extends RuntimeException {

    private MessageSource messageSource;

    public HandlerControllerException(MessageSource message){
        this.messageSource = message;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessageDTOException>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ErrorMessageDTOException> dto = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach(err -> {
            String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());
            ErrorMessageDTOException error =  new ErrorMessageDTOException(message, err.getField());
            dto.add(error);
        });
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}

//tratar excecoes na camada service
