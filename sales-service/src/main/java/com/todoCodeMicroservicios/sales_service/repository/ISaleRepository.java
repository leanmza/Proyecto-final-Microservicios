package com.todoCodeMicroservicios.sales_service.repository;

import com.todoCodeMicroservicios.sales_service.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Long> {


}
