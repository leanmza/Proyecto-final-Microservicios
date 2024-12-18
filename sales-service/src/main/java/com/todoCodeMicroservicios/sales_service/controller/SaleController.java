package com.todoCodeMicroservicios.sales_service.controller;

import com.todoCodeMicroservicios.sales_service.dto.SaleDTO;
import com.todoCodeMicroservicios.sales_service.model.Sale;
import com.todoCodeMicroservicios.sales_service.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sales")
public class SaleController {

    @Autowired
    private ISaleService saleService;

    @GetMapping("/get")
    public List<Sale> getSales(){
        return saleService.getSale();
    }

    @PostMapping("/create")
    public String saveSale(@RequestBody Sale sale){
        saleService.saveSale(sale);
        return "Venta creada correctamente";
    }

    @DeleteMapping("/delete/{id_sale}")
    public String deleteSale(@PathVariable Long id_sale){
        saleService.deleteSale(id_sale);
        return "Venta eliminada correctamente";
    }

    @GetMapping("/find/{id_sale}")
    public Sale findSale(@PathVariable Long id_sale) {
        return saleService.findSale(id_sale);
    }
    @PutMapping("/edit/{id_sale}")
    public Sale editSale(@PathVariable Long id_sale, @RequestBody Sale saleEdit){
        saleService.editSale(id_sale, saleEdit);
        return findSale(id_sale);
    }

    @GetMapping("/get/{id_sale}")
    public SaleDTO getSaleAndCart(@PathVariable Long id_sale) {
        return saleService.getSaleAndCart(id_sale);
    }
}
