package com.todoCodeMicroservicios.sales_service.service;

import com.todoCodeMicroservicios.sales_service.dto.SaleDTO;
import com.todoCodeMicroservicios.sales_service.model.Sale;

import java.util.List;

public interface ISaleService {
    List<Sale> getSale();

    void saveSale(Sale sale);

    void deleteSale(Long idSale);

    Sale findSale(Long idSale);

    void editSale(Long idSale, Sale saleEdit);

    SaleDTO getSaleAndCart(Long idSale);
}
