package br.lucasdev.designpatterns.controller;

import br.lucasdev.designpatterns.model.People;
import br.lucasdev.designpatterns.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PeopleController {
    @Autowired
    private PeopleService service;

    @GetMapping("/peoples")
    public List<People> getPeoples() {
        return service.getPeoples();
    }

    @GetMapping("/peoples/{id}")
    public Optional<People> getPeoples(@PathVariable("id") Long id) {
        return service.getPeople(id);
    }

    @PostMapping("/peoples")
    public People createPeople(@RequestBody People people) {
        return service.createPeople(people);
    }

    @DeleteMapping("/peoples/{id}")
    public Long deletePeople(@PathVariable("id") Long id) {
        return service.deletePeople(id);
    }

    @PutMapping("/peoples")
    public People deletePeople(@RequestBody People people) {
        return service.updatePeople(people);
    }
}
