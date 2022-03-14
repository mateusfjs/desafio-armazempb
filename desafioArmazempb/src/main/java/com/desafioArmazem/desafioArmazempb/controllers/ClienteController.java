package com.desafioArmazem.desafioArmazempb.controllers;

import com.desafioArmazem.desafioArmazempb.domains.Cliente;
import com.desafioArmazem.desafioArmazempb.services.ClienteService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        Cliente saveCliente = clienteService.save(cliente);

        return new ResponseEntity(saveCliente, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        try {
            Optional<Cliente> clienteEncontrado = clienteService.findById(id);
            return new ResponseEntity<>(clienteEncontrado.get(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Cliente> updateById(@PathVariable(value = "id")long id, @RequestBody Cliente cliente){
        try {
            Cliente clienteAtualizar = this.clienteService.updateById(id, cliente);
            return new ResponseEntity<>(clienteAtualizar, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteById(@PathVariable(value = "id")long id){
        try {
            this.clienteService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }






}
