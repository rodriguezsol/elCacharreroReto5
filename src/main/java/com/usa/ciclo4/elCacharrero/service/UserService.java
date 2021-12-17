/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.ciclo4.elCacharrero.service;

import com.usa.ciclo4.elCacharrero.model.User;
import com.usa.ciclo4.elCacharrero.repository.UserRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author solecito aqui va la logica de negocios "las validaciones"
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Get,consultar
     *
     * @return
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

    /**
     * metodo crear usuario
     *
     * @param user
     * @return
     */
    public User save(User user) {

        //obtiene el maximo id existente en la coleccion
        Optional<User> userIdMaximo = userRepository.lastUserId();

        //si el id del Usaurio que se recibe como parametro es nulo, entonces valida el maximo id existente en base de datos
        if (user.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (userIdMaximo.isEmpty()) {
                user.setId(1);
            } //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo del usuario
            else {
                user.setId(userIdMaximo.get().getId()+ 1);
            }
        }

        Optional<User> existUser = userRepository.getUserById(user.getId());
        if (existUser.isEmpty()) {
            if (getUserByEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }

    }

    /**
     *
     * @param user
     * @return
     */
    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> userExist = userRepository.getUserById(user.getId());
            if (!userExist.isEmpty()) {
                if (user.getIdentification() != null) {
                    userExist.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userExist.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userExist.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userExist.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userExist.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userExist.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userExist.get().setZone(user.getZone());
                }
                if (user.getType() != null) {
                    userExist.get().setType(user.getType());
                }
                userRepository.update(userExist.get());
                return userExist.get();
            } else {
                return user;
            }
        } else {
            return user;
        }

    }

    /**
     *
     * @param id
     * @return
     */
    public boolean deleteById(Integer id) {
        Boolean aBoolean = userRepository.getUserById(id).map(user -> {
            userRepository.deleteById(id);
            return true;
        }).orElse(false);

        return aBoolean;
    }

    public boolean getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    /**
     * metodo validar si existe email y password
     *
     * @param email
     * @param password
     * @return
     */
    public User authenticateUser(String email, String password) {
        Optional<User> usuario = userRepository.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
    public List <User> findByMonthBirthtDay (String birthday){
        return  userRepository.findByMonthBirthtDay(birthday);
    }

}
