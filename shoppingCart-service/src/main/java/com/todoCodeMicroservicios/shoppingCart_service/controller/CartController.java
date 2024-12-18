package com.todoCodeMicroservicios.shoppingCart_service.controller;

import com.todoCodeMicroservicios.shoppingCart_service.dto.CartDTO;
import com.todoCodeMicroservicios.shoppingCart_service.model.Cart;
import com.todoCodeMicroservicios.shoppingCart_service.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService cartService;

    @GetMapping("/get")
    public List<Cart> getCarts(){
        return cartService.getCarts();
    }

    @PostMapping("/create")
    public String saveCart(@RequestBody Cart cart){
        cartService.saveCart(cart);
        return "Carrito guardado correctamente";
    }

    @DeleteMapping("/delete/{id_cart}")
    public String deleteCart(@PathVariable Long id_cart){
        cartService.deleteCart(id_cart);
        return "Carrito eliminado correctamente";
    }

    @GetMapping("/find/{id_cart}")
    public Cart findCart(@PathVariable Long id_cart){
        return cartService.findCart(id_cart);
    }

    @PutMapping("/edit/{id_cart}")
    public Cart editCart(@PathVariable Long id_cart, @RequestBody Cart cartEdit){
        cartService.editCart(id_cart, cartEdit);
        return cartService.findCart(id_cart);
    }

    @GetMapping("/get/products/{id_cart}")
    public CartDTO getCartAndProducts(@PathVariable Long id_cart){
        return cartService.getCartAndProducts(id_cart);
    }
}
