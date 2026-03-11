package com.example.store.DTO.stockManagment;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShelfDTO {
    private Long shelfId;
    private String ShelfNameByAisle;
    private Long aisleId;
}
