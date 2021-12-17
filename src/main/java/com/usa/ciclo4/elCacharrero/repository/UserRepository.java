/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.ciclo4.elCacharrero.repository;

import com.usa.ciclo4.elCacharrero.crudRepository.UserCrudRepository;
import com.usa.ciclo4.elCacharrero.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author solecito
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    /**
     *
     * @return
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userCrudRepository.findById(id);
    }

    /**
     *
     * @param user
     * @return
     */
    public User save(User user) {
        return userCrudRepository.save(user);
    }

    public void update(User user) {
        userCrudRepository.save(user);
    }

    public void deleteById(Integer id) {
        userCrudRepository.deleteById(id);

    }

    /**
     *
     * @param email
     * @return
     */
    public boolean getUserByEmail(String email) {
        Optional<User> userExistEmail = userCrudRepository.findByEmail(email);

        return !userExistEmail.isEmpty();
    }

    /**
     *
     * @param email
     * @param password
     * @return
     */

    public Optional<User>authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
     public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }
     public List <User> findByMonthBirthtDay (String birthday){
        return  userCrudRepository.findByMonthBirthtDay(birthday);
    }

}
