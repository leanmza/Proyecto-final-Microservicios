package com.todoCodeMicroservicios.products_service.service;

import com.todoCodeMicroservicios.products_service.model.Product;
import com.todoCodeMicroservicios.products_service.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository productRepo;

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long idProduct) {
        productRepo.deleteById(idProduct);
    }

    @Override
    public Product findProduct(Long idProduct) {
        return productRepo.findById(idProduct).orElse(null);
    }

    @Override
    public void editProduct(Long idProduct, Product productEdit) {
        Product product = this.findProduct(idProduct);
        product.setName(productEdit.getName());
        product.setBrand(productEdit.getBrand());
        product.setPrice(productEdit.getPrice());

        productRepo.save(product);
    }
}
