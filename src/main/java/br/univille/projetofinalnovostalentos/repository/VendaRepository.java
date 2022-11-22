package br.univille.projetofinalnovostalentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projetofinalnovostalentos.entity.Venda;

@Repository
public interface VendaRepository 
    extends JpaRepository<Venda,Long> {
    
}