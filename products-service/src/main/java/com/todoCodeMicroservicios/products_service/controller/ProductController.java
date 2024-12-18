package com.todoCodeMicroservicios.products_service.controller;

import com.todoCodeMicroservicios.products_service.model.Product;
import com.todoCodeMicroservicios.products_service.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/get")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping("/create")
    public String saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return "Producto creado correctamente";
    }

    @DeleteMapping("/delete/{id_product}")
    public String deleteProduct (@PathVariable Long id_product){
        productService.deleteProduct(id_product);
        return "Producto eliminado correctamente";
    }

    @GetMapping("/find/{id_product}")
    public Product findProduct(@PathVariable Long id_product){
        return  productService.findProduct(id_product);
    }

    @PutMapping("/edit/{id_product}")
    public Product editProduct(@PathVariable Long id_product, @RequestBody Product productEdit){
        productService.editProduct(id_product, productEdit);
        return productService.findProduct(id_product);
    }

}
