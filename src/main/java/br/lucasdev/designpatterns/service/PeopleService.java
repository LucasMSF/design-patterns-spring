package br.lucasdev.designpatterns.service;

import br.lucasdev.designpatterns.client.ViaCepClient;
import br.lucasdev.designpatterns.exceptions.people.PeopleNotFoundException;
import br.lucasdev.designpatterns.model.Address;
import br.lucasdev.designpatterns.model.People;
import br.lucasdev.designpatterns.repository.AddressRepository;
import br.lucasdev.designpatterns.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ViaCepClient viaCepClient;

    public List<People> getPeoples() {
        return peopleRepository.findAll();
    }

    public People getPeople(Long id) throws PeopleNotFoundException {
        People people = peopleRepository.findById(id)
                .orElseThrow(() -> new PeopleNotFoundException(id));

        return people;
    }

    public People createPeople(People people) {
        Address address = addressRepository.findById(people.getAddress().getCep())
                .orElseGet(() -> {
                    Address newAddress = viaCepClient
                            .getAddressByCode(people.getAddress().getCep());

                    return addressRepository.save(newAddress);
                });

        people.setAddress(address);
        return peopleRepository.save(people);
    }

    public People updatePeople(People people) {
        return this.createPeople(people);
    }

    public Long deletePeople(Long id) throws PeopleNotFoundException {
        try {
            peopleRepository.deleteById(id);
            return id;
        } catch (EmptyResultDataAccessException e) {
            throw new PeopleNotFoundException(id);
        }
    }

}
