package com.boecommerce.ecommercecontroller;


import java.util.Optional;

import com.boecommerce.ecommercemodel.Producto;
import com.boecommerce.ecommercemodel.Usuario;
import com.boecommerce.ecommerceservice.ProductoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductoController {


    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String show(Model model){
        model.addAttribute("productos", productoService.findAll());
        return "productos/show";

    }

    @GetMapping("/create")
    public String create () {
        return "productos/create";
    }

    @PostMapping("/save")
    public String save(Producto producto){
        Usuario u = new Usuario(1,"", "", "", "", "", "", "");
        producto.setUsuario(u);
        productoService.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Producto producto = new Producto();
        Optional<Producto> optionalProducto = productoService.get(id);
        producto = optionalProducto.get();
        model.addAttribute("producto", producto);
        return "productos/edit";
    }


    @PostMapping("/update")
    public String update(Producto producto){
        productoService.update(producto);
        return "redirect:/productos";

    }
    
    
}
