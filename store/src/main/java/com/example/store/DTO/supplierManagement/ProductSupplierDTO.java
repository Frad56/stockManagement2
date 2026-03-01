package com.example.store.DTO.supplierManagement;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductSupplierDTO {
    private Long product_id;
    private Long supplier_id;
    private Double purchase_price;
}
