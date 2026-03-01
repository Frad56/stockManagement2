package com.example.store.DTO.supplierManagement;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SupplierDTO {
    private String company_name;
    private String contact_name;
    private String phone_number ;
    private String fax;
    private String email;
    private String address;
    private String city;
    private String postal_code;
    private String country;
    private List<Long> productIds;
}
