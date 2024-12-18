package com.todoCodeMicroservicios.sales_service.repository;

import com.todoCodeMicroservicios.sales_service.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="shoppingCart-service")
public interface ICartAPI {

    @GetMapping("/cart/get/products/{id_cart}")
    public CartDTO getCartAndProducts(@PathVariable Long id_cart);
}
