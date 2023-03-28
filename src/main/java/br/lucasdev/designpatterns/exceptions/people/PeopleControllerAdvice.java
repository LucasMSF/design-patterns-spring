package br.lucasdev.designpatterns.exceptions.people;

import br.lucasdev.designpatterns.exceptions.ControllerExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PeopleControllerAdvice {
    @ExceptionHandler(PeopleNotFoundException.class)
    public ResponseEntity<ControllerExceptionHandler> peopleNotFoundHandler(PeopleNotFoundException e) {
        ControllerExceptionHandler response = new ControllerExceptionHandler(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
