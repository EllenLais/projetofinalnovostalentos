package br.univille.projetofinalnovostalentos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetofinalnovostalentos.entity.Categoria;
import br.univille.projetofinalnovostalentos.repository.CategoriaRepository;
import br.univille.projetofinalnovostalentos.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repositorio;
    @Override
    public List<Categoria> getAll() {
        return repositorio.findAll();
    }
    @Override
    public void save(Categoria categoria) {
        repositorio.save(categoria);
        
    }
    @Override
    public Categoria findById(long id) {
        var result = repositorio.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return new Categoria();
    }
    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
    
}