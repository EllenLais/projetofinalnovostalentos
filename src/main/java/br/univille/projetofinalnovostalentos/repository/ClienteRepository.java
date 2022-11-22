package br.univille.projetofinalnovostalentos.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.projetofinalnovostalentos.entity.Cliente;
    
@Repository
public interface ClienteRepository 
    extends JpaRepository<Cliente,Long>{
        List<Cliente> findByNomeIgnoreCaseContaining(@Param("nome") String nome);  
}
