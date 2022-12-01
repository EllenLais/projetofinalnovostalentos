package br.univille.projetofinalnovostalentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projetofinalnovostalentos.entity.Compra;

@Repository
public interface CompraRepository 
    extends JpaRepository<Compra,Long> {
    
}