/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.ciclo4.elCacharrero.crudRepository;

import com.usa.ciclo4.elCacharrero.model.Clone;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author solesito
 */
public interface CloneCrudRepository extends MongoRepository<Clone, Integer>{
    public List <Clone> findByPrice (double price);
}
