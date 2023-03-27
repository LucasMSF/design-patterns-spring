package br.lucasdev.designpatterns.repository;

import br.lucasdev.designpatterns.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

}
