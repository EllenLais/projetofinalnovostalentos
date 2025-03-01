package br.univille.projetofinalnovostalentos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projetofinalnovostalentos.entity.Produto;
import br.univille.projetofinalnovostalentos.repository.ProdutoRepository;
import br.univille.projetofinalnovostalentos.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repositorio;
    @Override
    public List<Produto> getAll() {
        
        return repositorio.findAll();
    }
    @Override
    public Produto save(Produto produto) {
        return repositorio.save(produto);
        
    }
    @Override
    public Produto findById(long id) {
        var result = repositorio.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return new Produto();
    }
    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
    
}