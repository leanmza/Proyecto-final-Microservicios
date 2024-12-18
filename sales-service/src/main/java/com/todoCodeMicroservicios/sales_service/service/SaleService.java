package com.todoCodeMicroservicios.sales_service.service;

import com.todoCodeMicroservicios.sales_service.dto.ProductDTO;
import com.todoCodeMicroservicios.sales_service.dto.SaleDTO;
import com.todoCodeMicroservicios.sales_service.model.Sale;
import com.todoCodeMicroservicios.sales_service.repository.ICartAPI;
import com.todoCodeMicroservicios.sales_service.repository.IProductAPI;
import com.todoCodeMicroservicios.sales_service.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService implements ISaleService {

    @Autowired
    private ISaleRepository saleRepo;

      @Autowired
      private ICartAPI cartAPI;

      @Autowired
      private IProductAPI productAPI;

    @Override
    public List<Sale> getSale() {
        return saleRepo.findAll();
    }

    @Override
    public void saveSale(Sale sale) {

        saleRepo.save(sale);
    }

    @Override
    public void deleteSale(Long idSale) {
        saleRepo.deleteById(idSale);
    }

    @Override
    public Sale findSale(Long idSale) {
        return saleRepo.findById(idSale).orElse(null);
    }

    @Override
    public void editSale(Long idSale, Sale saleEdit) {
        Sale sale = this.findSale(idSale);
        sale.setDate(saleEdit.getDate());
        sale.setId_cart(saleEdit.getId_cart());

        saleRepo.save(sale);

    }

    @Override
    public SaleDTO getSaleAndCart(Long idSale) {

        Sale sale = this.findSale(idSale);
        SaleDTO saleDTO = new SaleDTO();

        saleDTO.setId_sale(sale.getId_sale());
        saleDTO.setDate(sale.getDate());

        saleDTO.setCart(cartAPI.getCartAndProducts(Long.valueOf(sale.getId_cart())));


        for(ProductDTO productDTO : saleDTO.getCart().getProducts()) {
            System.out.println("productDto " + productDTO.toString());
            ProductDTO productDTOTemp = productAPI.findProduct(productDTO.getId_producto());
            System.out.println("productDtoTemp " + productDTOTemp.toString());

            productDTO.setName(productDTOTemp.getName());
            productDTO.setBrand(productDTOTemp.getBrand());
            productDTO.setPrice(productDTOTemp.getPrice());
        }
        return saleDTO;
    }
}
