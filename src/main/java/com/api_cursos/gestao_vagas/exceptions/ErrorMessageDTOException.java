package com.api_cursos.gestao_vagas.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTOException extends RuntimeException {
    private String message;
    private String field;
}


//tratar excecoes na camada service