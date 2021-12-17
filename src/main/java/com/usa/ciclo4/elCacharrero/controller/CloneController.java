/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.ciclo4.elCacharrero.controller;

import com.usa.ciclo4.elCacharrero.model.Clone;
import com.usa.ciclo4.elCacharrero.service.CloneService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author solecito
 */
@RestController
@RequestMapping("/clone")
@CrossOrigin("*")
public class CloneController {

    @Autowired
    private CloneService cloneService;

    @GetMapping("/all")
    public List<Clone> getAll() {
        return cloneService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Clone> getClones(@PathVariable("id") Integer id) {
        return cloneService.getClones(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone save(@RequestBody Clone clone) {
        return cloneService.save(clone);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone update(@RequestBody Clone clone) {
        return cloneService.update(clone);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return cloneService.delete(id);
    }
     
    @GetMapping("/price/{price}")
    public List<Clone> findByPrice(@PathVariable("price") double price) {
        return cloneService.findByPrice(price);
    }
    
    @GetMapping("/description/{description}")
    public List<Clone> findByDescription(@PathVariable("description") String description) {
        return cloneService.findByDescription(description);
    }  

}
