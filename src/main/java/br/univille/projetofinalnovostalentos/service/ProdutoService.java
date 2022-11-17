package br.univille.projetofinalnovostalentos.service;

import java.util.List;

import br.univille.projetofinalnovostalentos.entity.Produto;

public interface ProdutoService {
    List<Produto> getAll();

    Produto save(Produto produto);

    Produto findById(long id);

    void delete(long id);
}
