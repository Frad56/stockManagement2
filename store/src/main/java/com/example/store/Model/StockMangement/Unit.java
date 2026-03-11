package com.example.store.Model.StockMangement;


import com.example.store.Model.Authentification.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "unit")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unitId;

    @Column(name = "name")
    private String name;

    @Column(name = "symbol")
    private String symbol;

    @Enumerated(EnumType.STRING)
    private SizeType sizeType;

}
