package br.univille.projetofinalnovostalentos.service;

import java.util.List;

import br.univille.projetofinalnovostalentos.entity.Categoria;

public interface CategoriaService {
    List<Categoria> getAll();

    void save(Categoria categoria);

    Categoria findById(long id);

    void delete(long id);
}
