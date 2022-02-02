package com.boecommerce.ecommercecontroller;


import java.io.IOException;
import java.util.Optional;

import com.boecommerce.ecommercemodel.Producto;
import com.boecommerce.ecommercemodel.Usuario;
import com.boecommerce.ecommerceservice.ProductoService;
import com.boecommerce.ecommerceservice.UploadFileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/productos")
public class ProductoController {


    @Autowired
    private ProductoService productoService;

    @Autowired
    private UploadFileService upload;

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
    public String save(Producto producto, @RequestParam("img") MultipartFile file) throws IOException{
        Usuario u = new Usuario(1,"", "", "", "", "", "", "");
        producto.setUsuario(u);

        //imagen
        if(producto.getId()==null){//cuando se crea un producto 
            String nombreImagen = upload.saveImage(file);
            producto.setImagen(nombreImagen);

        }else{
            if(file.isEmpty()){//editamos el producto pero no cambiamos la imagen
                Producto p = new Producto();
                p = productoService.get(producto.getId()).get();
                producto.setImagen(p.getImagen());

            }else{
                String nombreImagen = upload.saveImage(file);
                producto.setImagen(nombreImagen);

            }
        }


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

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id ){
        productoService.delete(id);
        return "redirect:/productos";
    }
    
    
}
