package com.boecommerce.ecommercecontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.boecommerce.ecommercemodel.DetalleOrden;
import com.boecommerce.ecommercemodel.Orden;
import com.boecommerce.ecommercemodel.Producto;
import com.boecommerce.ecommerceservice.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductoService productoService;

    //Almacenar detalle de orden
    List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();

    //datos de la orden
    Orden orden = new Orden();

    @GetMapping("")
    public String home (Model model){

        model.addAttribute("productos", productoService.findAll());
        return "usuario/home";
    }

    @GetMapping("productohome/{id}")
    public String productoHome(@PathVariable Integer id, Model model){
        Producto producto = new Producto();
        Optional<Producto> productoOptional = productoService.get(id);
        producto = productoOptional.get();

        model.addAttribute("producto", producto);
        
        
        return "usuario/productohome";
    }
    
    @PostMapping("/cart")
    public String addCart (@RequestParam Integer id, @RequestParam Integer cantidad  ){
        DetalleOrden detalleOrden = new DetalleOrden();
        Producto producto = new Producto();
        double sumaTotal = 0;

        Optional<Producto> optionalProducto = productoService.get(id);
        

        return "usuario/carrito.html";
    }
}
