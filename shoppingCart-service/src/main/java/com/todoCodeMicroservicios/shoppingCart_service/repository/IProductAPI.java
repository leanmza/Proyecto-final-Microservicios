package com.todoCodeMicroservicios.shoppingCart_service.repository;

import com.todoCodeMicroservicios.shoppingCart_service.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "products-service")
public interface IProductAPI {

    @GetMapping("/products/find/{id_product}")
    public ProductDTO findProduct(@PathVariable Long id_product);

}
