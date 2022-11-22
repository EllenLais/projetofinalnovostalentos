package br.univille.projetofinalnovostalentos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetofinalnovostalentos.entity.Fornecedor;
import br.univille.projetofinalnovostalentos.repository.FornecedorRepository;
import br.univille.projetofinalnovostalentos.service.FornecedorService;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository repositorio;
    @Override
    public List<Fornecedor> getAll() {
        return repositorio.findAll();
    }
    @Override
    public void save(Fornecedor fornecedor) {
        repositorio.save(fornecedor);
        
    }
    @Override
    public Fornecedor findById(long id) {
        var result = repositorio.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return new Fornecedor();
    }
    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
    
    
}