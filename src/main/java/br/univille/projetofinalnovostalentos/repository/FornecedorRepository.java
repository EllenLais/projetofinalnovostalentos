package br.univille.projetofinalnovostalentos.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projetofinalnovostalentos.entity.Fornecedor;
    
@Repository
public interface FornecedorRepository 
    extends JpaRepository<Fornecedor,Long>{
         
}
