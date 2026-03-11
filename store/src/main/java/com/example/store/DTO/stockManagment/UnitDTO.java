package com.example.store.DTO.stockManagment;


import com.example.store.Model.StockMangement.SizeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UnitDTO {

    private Long unitId;
    private String name;
    private String symbol;
    private SizeType sizeType;

}
