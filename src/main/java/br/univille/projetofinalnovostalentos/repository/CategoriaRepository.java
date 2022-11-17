package br.univille.projetofinalnovostalentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projetofinalnovostalentos.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long>{
}
