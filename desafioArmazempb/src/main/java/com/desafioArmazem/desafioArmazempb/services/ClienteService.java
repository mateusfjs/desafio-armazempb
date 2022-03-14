package com.desafioArmazem.desafioArmazempb.services;

import java.util.List;
import java.util.Optional;

import com.desafioArmazem.desafioArmazempb.domains.Cliente;
import com.desafioArmazem.desafioArmazempb.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) throws Exception{
        if (this.isExist(id)){
            return clienteRepository.findById(id);
        }else{
            throw new Exception();
        }
    }

    public Cliente updateById(Long id, Cliente clienteUpdate) throws Exception{
        if(this.isExist(clienteUpdate.getId())){
            var cliente = this.clienteRepository.findById(id).get();

            cliente.setCpf(clienteUpdate.getCpf());
            cliente.setEndereco(clienteUpdate.getEndereco());
            cliente.setNome(clienteUpdate.getNome());
            cliente.setData_nascimento(clienteUpdate.getData_nascimento());

            return clienteRepository.save(cliente);

        }else{
            throw new Exception();
        }
    }

    public void deleteById(long id) throws Exception{
        if(this.isExist(id)){
            this.clienteRepository.deleteById(id);
        }else{
            throw new Exception();
        }
    }






    //Verifica se existe um objeto do tipo Cliente no bd
    public boolean isExist(long id) {
        if (!this.clienteRepository.findById(id).isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
}