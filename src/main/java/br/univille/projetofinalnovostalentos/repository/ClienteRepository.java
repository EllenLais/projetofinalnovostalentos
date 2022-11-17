package br.univille.projetofinalnovostalentos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projetofinalnovostalentos.entity.Cliente;
    
@Repository
public interface ClienteRepository 
    extends JpaRepository<Cliente,Long>{
        
}
