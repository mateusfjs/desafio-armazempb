package com.desafioArmazem.desafioArmazempb.repositories;

import com.desafioArmazem.desafioArmazempb.domains.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
