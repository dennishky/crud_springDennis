package br.com.dennis.springcrud.controller;


import br.com.dennis.springcrud.services.ClientServiceV1;
import br.com.dennis.springcrud.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client/v1")
public class ClientControllerV1 {

    @Autowired
    private ClientServiceV1 service;

    @PostMapping
    public Client save(@RequestBody Client person){
        return service.save(person);
    }

    @GetMapping
    public List<Client> findALL(){
        return service.findALL();
    }

    @RequestMapping("/{id}")
    public Client findById(@PathVariable("id") long id) throws Exception{
        return service.findById(id);
    }

    @PutMapping
    public Client update(@RequestBody Client person) throws Exception{
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete( @PathVariable("id") long id) throws Exception{
        service.delete(id);
    }

}
