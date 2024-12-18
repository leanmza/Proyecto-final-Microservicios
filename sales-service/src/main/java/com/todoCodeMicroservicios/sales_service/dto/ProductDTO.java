package com.todoCodeMicroservicios.sales_service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDTO {
    private Long id_producto;

    private String name;
    private String brand;
    private double price;
}
