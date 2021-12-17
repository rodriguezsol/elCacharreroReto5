/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.ciclo4.elCacharrero.controller;

import com.usa.ciclo4.elCacharrero.model.User;
import com.usa.ciclo4.elCacharrero.service.UserService;
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
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("user")

public class UserController {

    @Autowired
    private UserService userService;

    /**
     *consultar
     * @return
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
    
     @GetMapping("/{id}")
    public Optional <User> getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    /**
     * Crear o guardar
     * @param user
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    /**
     * Consultar
     * @param email
     * @return
     */
    @GetMapping("/emailexist/{email}")
    public boolean existEmail(@PathVariable("email") String email) {
        return userService.getUserByEmail(email);
    }

    /**
     * Consular
     * @param email
     * @param password
     * @return
     */
   @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }

    /**
     * *
     *Actualizar
     * @param user
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    /**
     * Eliminar
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return userService.deleteById(id);
    }
    @GetMapping("/birthday/{birthday}")
    public List <User> findByMonthBirthtDay(@PathVariable("birthday") String birthday){
        return userService.findByMonthBirthtDay(birthday);
    }
}
