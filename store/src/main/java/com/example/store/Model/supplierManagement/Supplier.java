package com.example.store.Model.supplierManagement;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long supplier_id;

    @NotNull
    @Column(name = "companyName")
    private String company_name;

    @Column(name = "contactName")
    private String contact_name;

    @Column(name ="phoneNumber" )
    private String phone_number ;

    @Column(name = "fax")
    private String fax;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "postalCode")
    private String postal_code;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ProductSupplier> product_suppliers = new ArrayList<>();
}
