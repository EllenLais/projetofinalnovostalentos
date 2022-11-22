package br.univille.projetofinalnovostalentos.service;

import java.util.List;

import br.univille.projetofinalnovostalentos.entity.Fornecedor;


public interface FornecedorService {
    List<Fornecedor> getAll();

    void save(Fornecedor fornecedor);

    Fornecedor findById(long id);

    void delete(long id);
}
