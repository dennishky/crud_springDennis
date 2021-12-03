package br.com.dennis.springcrud.controller;


import br.com.dennis.springcrud.services.ClientServiceV2;
import br.com.dennis.springcrud.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client/v2")
public class ClientControllerV2 {

    @Autowired
    private ClientServiceV2 service;

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

    @GetMapping("/query/{name}")
    public List<Client> listByName(@PathVariable("name") String name){
        return service.listByName(name);
    }

}
