package com.example.store.Model.StockMangement;


import com.example.store.Model.supplierManagement.Supplier;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "product_characteristic")
public class ProductCharacteristic {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productCharacteristicId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",nullable = false)
    @JsonBackReference
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "characteristic_id",nullable = false)
    private Characteristic characteristic;

}
