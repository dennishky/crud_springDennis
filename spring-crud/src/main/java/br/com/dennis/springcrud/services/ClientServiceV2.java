package br.com.dennis.springcrud.services;


import br.com.dennis.springcrud.repository.ClientRepository;
import br.com.dennis.springcrud.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Service
public class ClientServiceV2 {

    @Autowired
    private ClientRepository repository;

    // version 2 //
    @Autowired
    private EntityManager em;
    // version 2 //

    public Client save(Client person){
        // Version 2 //
        person.setRegisterdate(new Date());
        // --------- //
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
        //version 2//
        p.setstate(person.getstate());
        //---------//
        return repository.save(p);
    }

    public void delete(long id) throws Exception {
        Client p = repository.findById(id).orElseThrow( () -> new Exception("Not Found"));
        repository.delete(p);
    }

    // Version 2 //
    public List<Client> listByName(String name){
     String hql = "from Client where name like :name order by name";
        Query query = em.createQuery(hql);
        query.setParameter("name", name + "%");
        List<Client> client = query.getResultList();
        return client;
    }
    // -------- //

}
