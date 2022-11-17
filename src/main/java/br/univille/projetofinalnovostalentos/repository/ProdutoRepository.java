package br.univille.projetofinalnovostalentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projetofinalnovostalentos.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{
    
}
