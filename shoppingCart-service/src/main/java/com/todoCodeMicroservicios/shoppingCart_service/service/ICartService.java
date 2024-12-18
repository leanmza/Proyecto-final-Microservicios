package com.todoCodeMicroservicios.shoppingCart_service.service;

import com.todoCodeMicroservicios.shoppingCart_service.dto.CartDTO;
import com.todoCodeMicroservicios.shoppingCart_service.model.Cart;

import java.util.List;

public interface ICartService {
    List<Cart> getCarts();

    void saveCart(Cart cart);

    void deleteCart(Long idCart);

    Cart findCart(Long idCart);

    void editCart(Long idCart, Cart cartEdit);

    CartDTO getCartAndProducts(Long idCart);
}
