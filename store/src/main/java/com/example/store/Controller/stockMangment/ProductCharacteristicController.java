package com.example.store.Controller.stockMangment;


import com.example.store.DTO.stockManagment.ProductCharacteristicDTO;
import com.example.store.Model.StockMangement.ProductCharacteristic;
import com.example.store.Service.stockManagment.interfaces.ProductCharacteristicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productCharacteristic")
public class ProductCharacteristicController {
    private final ProductCharacteristicService productCharacteristicService;

    public ProductCharacteristicController(ProductCharacteristicService productCharacteristicService) {
        this.productCharacteristicService = productCharacteristicService;
    }

    @PostMapping("/addProductCharacteristic")
    public ResponseEntity<ProductCharacteristic> saveProductCharacteristic(ProductCharacteristicDTO productCharacteristicDTO) {
        return ResponseEntity.ok(productCharacteristicService.saveProductCharacteristic(productCharacteristicDTO));
    }


    @GetMapping("/ListProductCharacteristics")
    public ResponseEntity<List<ProductCharacteristic>> fetchProductCharacteristicList() {
        return ResponseEntity.ok(productCharacteristicService.fetchProductCharacteristicList());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ProductCharacteristic> findProductCharacteristicById(Long productCharacteristicId) {
        return ResponseEntity.ok(productCharacteristicService.findProductCharacteristicById(productCharacteristicId));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductCharacteristic> updateProductCharacteristic(ProductCharacteristicDTO productCharacteristicDTO, Long productCharacteristicId)
    {         return ResponseEntity.ok(productCharacteristicService.updateProductCharacteristic(productCharacteristicDTO, productCharacteristicId));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductCharacteristicById(Long productCharacteristicId) {
        productCharacteristicService.deleteProductCharacteristicById(productCharacteristicId);
        return ResponseEntity.ok("Deleted Successfully");
    }

}
