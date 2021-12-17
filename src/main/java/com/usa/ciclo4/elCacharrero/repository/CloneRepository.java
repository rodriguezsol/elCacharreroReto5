/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.ciclo4.elCacharrero.repository;

import com.usa.ciclo4.elCacharrero.crudRepository.CloneCrudRepository;
import com.usa.ciclo4.elCacharrero.model.Clone;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author solecito
 */
@Repository
public class CloneRepository {
   @Autowired
    private CloneCrudRepository repository; 
   
    public List<Clone> getAll() {
        return repository.findAll();
    }

    public Optional<Clone> getClones(Integer id) {
        return repository.findById(id);
    }
    public Clone save(Clone clone) {
        return repository.save(clone);
    }

    public void update(Clone clone) {
        repository.save(clone);
    }
    
    public void delete(Clone clone) {
        repository.delete(clone);
    } 
    public List <Clone> findByPrice (double price){
        return  repository.findByPrice(price);
    }
}
