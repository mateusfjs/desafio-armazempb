package com.desafioArmazem.desafioArmazempb.controllers;

import com.desafioArmazem.desafioArmazempb.domains.Pedido;
import com.desafioArmazem.desafioArmazempb.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido){
        Pedido savePedido =  pedidoService.save(pedido);

        return new ResponseEntity(savePedido, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
        List<Pedido> pedidos = pedidoService.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id){

        try {
            Optional <Pedido> pedidoEncontrado = pedidoService.findById(id);
            return new ResponseEntity<>(pedidoEncontrado.get(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updateById(@PathVariable(value = "id")long id, @RequestBody Pedido pedido){
        try {
            Pedido pedidoAtualizar = this.pedidoService.updateById(id, pedido);
            return new ResponseEntity<>(pedidoAtualizar, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pedido> deletebyId(@PathVariable(value = "id")long id){
        try {
            this.pedidoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
