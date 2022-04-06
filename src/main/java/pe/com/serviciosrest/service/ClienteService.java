package pe.com.serviciosrest.service;

import java.util.List;
import java.util.Optional;

import pe.com.serviciosrest.entity.Cliente;

public interface ClienteService {

 List<Cliente> findAll();

 Optional<Cliente> findById(Long id);

 List<Cliente> finByName(String name);

 Cliente add(Cliente cl);

 Cliente update(Cliente cl);

 Cliente delete(Cliente cl);
}