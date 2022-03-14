package com.desafioArmazem.desafioArmazempb.services;

import com.desafioArmazem.desafioArmazempb.domains.Pedido;
import com.desafioArmazem.desafioArmazempb.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido save(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> findAll(){
        return (List<Pedido>) pedidoRepository.findAll();
    }

    public Optional<Pedido> findById(Long id) throws Exception{
        if (this.isExist(id)){
            return pedidoRepository.findById(id);
        }else{
            throw new Exception();
        }
    }


    public Pedido updateById(Long id, Pedido pedidoUpdate) throws Exception{
        if (this.isExist(pedidoUpdate.getId())){
            var pedido = this.pedidoRepository.findById(id).get();
            pedido.setData_pedido(pedidoUpdate.getData_pedido());
            pedido.setValor_total(pedidoUpdate.getValor_total());
            pedido.setId_cliente(pedidoUpdate.getId_cliente());

            return pedidoRepository.save(pedido);

        }else {
            throw new Exception();
        }
    }

    public void deleteById(long id) throws Exception{
        if(this.isExist(id)){
            this.pedidoRepository.deleteById(id);
        }else{
            throw new Exception();
        }
    }

    //Verifica se existe um objeto do tipo pedido no bd
    public boolean isExist(long id) {
        if (!this.pedidoRepository.findById(id).isEmpty()) {
            return true;
        } else {
            return false;
        }

    }


}
