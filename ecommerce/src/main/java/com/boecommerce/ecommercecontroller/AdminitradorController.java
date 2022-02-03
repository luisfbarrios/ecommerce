package com.boecommerce.ecommercecontroller;

import java.util.List;

import com.boecommerce.ecommercemodel.Producto;
import com.boecommerce.ecommerceservice.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/administrador")
public class AdminitradorController {

    @Autowired
    private ProductoService productoService;
    @GetMapping("")
    public String home(Model model){
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return "administrador/home";
    }
    
}
