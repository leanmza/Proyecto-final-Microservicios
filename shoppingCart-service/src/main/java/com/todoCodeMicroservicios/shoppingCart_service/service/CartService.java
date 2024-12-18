package com.todoCodeMicroservicios.shoppingCart_service.service;

import com.todoCodeMicroservicios.shoppingCart_service.dto.CartDTO;
import com.todoCodeMicroservicios.shoppingCart_service.dto.ProductDTO;
import com.todoCodeMicroservicios.shoppingCart_service.model.Cart;
import com.todoCodeMicroservicios.shoppingCart_service.repository.ICartRepository;
import com.todoCodeMicroservicios.shoppingCart_service.repository.IProductAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService implements ICartService {

    @Autowired
    private ICartRepository cartRepo;

    @Autowired
    private IProductAPI productAPI;

    @Override
    public List<Cart> getCarts() {
        return cartRepo.findAll();
    }

    @Override
    public void saveCart(Cart cart) {

        cart.setTotal(addPrices(cart.getId_products()));

        cartRepo.save(cart);
    }

    private Double addPrices(List<String> idProducts) {
        double total = 0;

        for (String id_product : idProducts) {
            Long id = Long.parseLong(id_product);
            System.out.println(id);
            ProductDTO productDTO = productAPI.findProduct(id);

            total = total + productDTO.getPrice();
        }
        return total;
    }

    @Override
    public void deleteCart(Long idCart) {
        cartRepo.deleteById(idCart);
    }

    @Override
    public Cart findCart(Long idCart) {
        return cartRepo.findById(idCart).orElse(null);
    }

    @Override
    public void editCart(Long idCart, Cart cartEdit) {
        Cart cart = this.findCart(idCart);
        cart.setId_products(cartEdit.getId_products());
        cart.setTotal(addPrices(cartEdit.getId_products()));

        cartRepo.save(cart);
    }

    @Override
    @CircuitBreaker(name = "products-service", fallbackMethod = "fallbackGetCartAndProducts")
    @Retry(name = "products-service")
    public CartDTO getCartAndProducts(Long idCart) {
        CartDTO cartDTO = new CartDTO();
        Cart cart = cartRepo.findById(idCart).orElse(null);
        List<ProductDTO> listProducts = new ArrayList<>();

        for (String id_product : cart.getId_products()) {
            listProducts.add(productAPI.findProduct(Long.parseLong(id_product)));
        }

        cartDTO.setId(cart.getId());
        cartDTO.setTotal(cart.getTotal());
        cartDTO.setProducts(listProducts);

        return cartDTO;
    }

    public CartDTO fallbackGetCartAndProducts(Throwable throwable) {
        return new CartDTO(9999999L, null, 999999.99);
    }


}
