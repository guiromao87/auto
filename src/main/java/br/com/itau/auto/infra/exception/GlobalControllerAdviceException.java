package br.com.itau.auto.infra.exception;

import br.com.itau.auto.infra.exception.dto.ErroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalControllerAdviceException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroDTO>> handlerMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        var errorsDTO = ex.getFieldErrors()
                .stream()
                .map(error -> new ErroDTO(error.getField(), error.getDefaultMessage()))
                .toList();
        return ResponseEntity.badRequest().body(errorsDTO);
    }
}
