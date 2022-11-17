package br.univille.projetofinalnovostalentos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetofinalnovostalentos.entity.Cliente;
import br.univille.projetofinalnovostalentos.entity.Produto;
import br.univille.projetofinalnovostalentos.repository.ClienteRepository;
import br.univille.projetofinalnovostalentos.repository.ProdutoRepository;
import br.univille.projetofinalnovostalentos.service.ClienteService;
import br.univille.projetofinalnovostalentos.service.ProdutoService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repositorio;
    @Override
    public List<Cliente> getAll() {
        
        return repositorio.findAll();
    }
    @Override
    public void save(Cliente cliente) {
        repositorio.save(cliente);
        
    }
    @Override
    public Cliente findById(long id) {
        var result = repositorio.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return new Cliente();
    }
    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
    
    
    
}