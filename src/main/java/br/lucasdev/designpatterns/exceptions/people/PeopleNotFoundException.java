package br.lucasdev.designpatterns.exceptions.people;

public class PeopleNotFoundException extends RuntimeException{
    public PeopleNotFoundException(Long id) {
        super("People with Id " + id + " not found");
    }

}
