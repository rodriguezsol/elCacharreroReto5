/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.ciclo4.elCacharrero.service;

import com.usa.ciclo4.elCacharrero.model.Clone;
import com.usa.ciclo4.elCacharrero.repository.CloneRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author solecito
 */
@Service
public class CloneService {

    @Autowired
    private CloneRepository repository;

    public List<Clone> getAll() {
        return repository.getAll();
    }

    public Optional<Clone> getClones(Integer id) {
        return repository.getClones(id);
    }

    public Clone save(Clone products) {
        if (products.getId() == null) {
            return products;
        } else {
            return repository.save(products);
        }
    }

    public Clone update(Clone products) {

        if (products.getId() != null) {
            Optional<Clone> productsDb = repository.getClones(products.getId());
            if (!productsDb.isEmpty()) {

                if (products.getBrand() != null) {
                    productsDb.get().setBrand(products.getBrand());
                }

                if (products.getProcesor() != null) {
                    productsDb.get().setProcesor(products.getProcesor());
                }
                if (products.getOs()!= null) {
                    productsDb.get().setOs(products.getOs());
                }
                if (products.getDescription() != null) {
                    productsDb.get().setDescription(products.getDescription());
                }
                if (products.getMemory() != null) {
                    productsDb.get().setMemory(products.getMemory());
                }
                if (products.getHardDrive() != null) {
                    productsDb.get().setHardDrive(products.getHardDrive());
                }
                if (products.getPrice() != 0.0) {
                    productsDb.get().setPrice(products.getPrice());
                }
                if (products.getQuantity() != 0) {
                    productsDb.get().setQuantity(products.getQuantity());
                }
                if (products.getPhotography() != null) {
                    productsDb.get().setPhotography(products.getPhotography());
                }
                productsDb.get().setAvailability(products.isAvailability());
                repository.update(productsDb.get());
                return productsDb.get();
            } else {
                return products;
            }
        } else {
            return products;
        }
    }

    public boolean delete(Integer id) {
        Boolean aBoolean = getClones(id).map(products -> {
            repository.delete(products);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
     public List <Clone> findByPrice (double price){
        return  repository.findByPrice(price);
    }
    
    private boolean checkStrings(String string1, String string2) {
        return string1.indexOf(string2)>=0;
    }
    
    public List <Clone> findByDescription (String description2){
        List <Clone> suplementos = repository.getAll();
        ArrayList<Clone> suplementos2 = new ArrayList();
        for(Clone suplemento: suplementos){
            String descripcion1 = suplemento.getDescription();
            
            if (checkStrings(descripcion1, description2)) {
                suplementos2.add(suplemento);
            }
            
        }
        
        return (List<Clone>) suplementos2;
    }


}
