package com.desafioArmazem.desafioArmazempb.repositories;

import com.desafioArmazem.desafioArmazempb.domains.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
}
