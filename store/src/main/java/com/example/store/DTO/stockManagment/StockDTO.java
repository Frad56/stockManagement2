package com.example.store.DTO.stockManagment;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StockDTO {
    private Long stock_id;
    private String name;
    private Long quantity;
}
