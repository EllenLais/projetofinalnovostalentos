package br.univille.projetofinalnovostalentos.service;

import java.util.List;
import br.univille.projetofinalnovostalentos.entity.Cliente;

public interface ClienteService {
    List<Cliente> getAll();
    void save(Cliente cliente);
    Cliente findById(long id);
    void delete(long id);
    
    
}