package br.univille.projetofinalnovostalentos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetofinalnovostalentos.entity.Compra;
import br.univille.projetofinalnovostalentos.repository.CompraRepository;
import br.univille.projetofinalnovostalentos.service.CompraService;


@Service
public class CompraServiceImpl implements CompraService {
    @Autowired
    private CompraRepository repository;
    @Override
    public List<Compra> getAll() {
        return repository.findAll();
    }
    @Override
    public void save(Compra compras) {
        repository.save(compras);
    }
    @Override
    public Compra findById(long id) {
        var result = repository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return new Compra();
    }
    
}