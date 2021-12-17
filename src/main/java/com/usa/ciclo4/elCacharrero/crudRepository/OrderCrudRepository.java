package com.usa.ciclo4.elCacharrero.crudRepository;


import com.usa.ciclo4.elCacharrero.model.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author solecito
 */

public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    
    //Retorna las ordenes de pedido que coincidan con la zona recibida como parametro
    @Query("{'salesMan.zone': ?0}")
   public List<Order> findUserByZone(String zone);
    
    //Retorna las ordenes x estado
    @Query("{status: ?0}")
   public List<Order> findByStatus(String status);
    
    //Para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();
    
  
    
}
