package com.boecommerce.ecommercerepository;

import java.util.Optional;

import com.boecommerce.ecommercemodel.Producto;

import org.springframework.stereotype.Repository;



@Repository
public interface ProductoRepository extends JpaRepositoy<Producto, Integer> {

    Producto save(Producto producto);

    Optional<Producto> findById(Integer id);

    void deleteById(Integer id);
    
}
