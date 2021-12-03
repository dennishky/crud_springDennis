package br.com.dennis.springcrud.services;


import br.com.dennis.springcrud.repository.ClientRepository;
import br.com.dennis.springcrud.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceV1 {

    @Autowired
    private ClientRepository repository;

    public Client save(Client person){
        return repository.save(person);
    }

    public Client findById(long id) throws Exception{
        return repository.findById(id).orElseThrow( () -> new Exception("Not Found!"));
    }

    public List<Client> findALL(){
        return  repository.findAll();
    }

    public Client update(Client person) throws Exception {
        Client p = repository.findById(person.getId()).orElseThrow( () -> new Exception("Not found"));
        p.setname(person.getname());
        p.setphone(person.getphone());
        p.setcity(person.getcity());
        return repository.save(p);
    }

    public void delete(long id) throws Exception {
        Client p = repository.findById(id).orElseThrow( () -> new Exception("Not Found"));
        repository.delete(p);
    }

}
