package com.example.store.Model.StockMangement;


import jakarta.persistence.*;



@Entity
@Table(name="aisle")
public class Aisle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aisleId;

    @Column(name= "name")
    private String name;



}
