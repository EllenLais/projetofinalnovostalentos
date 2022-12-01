package br.univille.projetofinalnovostalentos.service;

import java.util.List;

import br.univille.projetofinalnovostalentos.entity.Compra;


public interface CompraService {
    List<Compra> getAll();
    void save(Compra compras);
    Compra findById(long id);
}