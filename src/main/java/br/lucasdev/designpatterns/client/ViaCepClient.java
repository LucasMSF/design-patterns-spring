package br.lucasdev.designpatterns.client;

import br.lucasdev.designpatterns.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "viaCep")
public interface ViaCepClient {
    @GetMapping("{cep}/json")
    Address getAddressByCode(@PathVariable("cep") String cep);
}
