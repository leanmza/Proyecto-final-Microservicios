package com.todoCodeMicroservicios.products_service.service;

import com.todoCodeMicroservicios.products_service.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();

    void saveProduct(Product product);

    void deleteProduct(Long idProduct);

    Product findProduct(Long idProduct);

    void editProduct(Long idProduct, Product productEdit);
}
