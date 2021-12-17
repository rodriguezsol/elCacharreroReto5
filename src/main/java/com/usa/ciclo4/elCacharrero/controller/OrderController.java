package com.usa.ciclo4.elCacharrero.controller;

import com.usa.ciclo4.elCacharrero.model.Order;
import com.usa.ciclo4.elCacharrero.service.OrderService;
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
@RequestMapping("order")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * consultar
     *
     * @return
     */
    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    /**
     * consultar por
     *
     * @param id
     * @return
     */

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") Integer id) {
        return orderService.getOrder(id);
    }

    /**
     * consultar por zona
     *
     * @param zona
     * @return
     */
    @GetMapping("/zona/{zona}")
    public List<Order> findByZone(@PathVariable("zona") String zona) {
        return orderService.findByZone(zona);
    }

    /**
     * Crear o guardar
     *
     * @param Ordenes
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    /**
     * Actualizar
     *
     * @param Ordenes
     * @return
     */

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }

    /**
     * Eliminar
     *
     * @param Ordenes
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return orderService.delete(id);
    }

    //Métodos del reto 4
    // Ordenes de un asesor
    @GetMapping("/salesman/{id}")
    public List<Order> ordersSalesManByID(@PathVariable("id") Integer id) {
        return orderService.ordersSalesManByID(id);
    }

    //Ordenes de un asesor x Estado
    @GetMapping("/state/{state}/{id}")
    public List<Order> ordersSalesManByState(@PathVariable("state") String state, @PathVariable("id") Integer id) {
        return orderService.ordersSalesManByState(state, id);
    }

    //Ordenes de un asesor x fecha
    @GetMapping("/date/{date}/{id}")
    public List<Order> ordersSalesManByDate(@PathVariable("date") String dateStr, @PathVariable("id") Integer id) {
        return orderService.ordersSalesManByDate(dateStr, id);
    }
}
