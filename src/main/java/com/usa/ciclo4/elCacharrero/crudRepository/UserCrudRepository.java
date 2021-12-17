/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.ciclo4.elCacharrero.crudRepository;

import com.usa.ciclo4.elCacharrero.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author solecito
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {

    /**
     * en sql es asi
     *
     * @select * from user where user_email=""
     *
     */
    public Optional<User> findByEmail(String Email);

    /**
     * en sql es asi
     *
     * @param email
     * @param password
     * @return
     */

    public Optional<User> findByEmailAndPassword(String email, String password);

    /**
     *
     * Para seleccionar el usuario con el id maximo
     */
    Optional<User> findTopByOrderByIdDesc();
    
    
    
    public List <User> findByMonthBirthtDay (String birthday);
}
