package com.todoCodeMicroservicios.shoppingCart_service.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
