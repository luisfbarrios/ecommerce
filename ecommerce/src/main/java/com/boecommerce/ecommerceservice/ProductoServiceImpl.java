package com.boecommerce.ecommerceservice;

import java.util.List;
import java.util.Optional;

import com.boecommerce.ecommercemodel.Producto;
import com.boecommerce.ecommercerepository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productorepository;

    @Override
    public Producto save(Producto producto) {
        return productorepository.save(producto);
    }

    @Override
    public Optional<Producto> get(Integer id) {
       
        return productorepository.findById(id);
    }

    @Override
    public void update(Producto producto) {
        productorepository.save(producto);
        
    }

    @Override
    public void delete(Integer id) {
        productorepository.deleteById(id);
        
    }

    @Override
    public List<Producto> findAll() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
