package br.univille.projetofinalnovostalentos.service;

import java.util.List;
import br.univille.projetofinalnovostalentos.entity.Venda;

public interface VendaService {
    List<Venda> getAll();
    void save(Venda venda);
    Venda findById(long id);
}