package com.example.store.Controller.stockMangment;


import com.example.store.DTO.stockManagment.ProductUnitSaleDTO;
import com.example.store.Model.StockMangement.ProductUnitSale;
import com.example.store.Service.stockManagment.interfaces.ProductUnitSaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productUnitSale")
public class ProductUnitSaleController {
    private final ProductUnitSaleService productUnitSaleService;


    public ProductUnitSaleController(ProductUnitSaleService productUnitSaleService) {
        this.productUnitSaleService = productUnitSaleService;
    }

    @PostMapping("/addProductUnitSale")
    public ResponseEntity<ProductUnitSale> saveProductUnitSale(ProductUnitSaleDTO productUnitSaleDTO) {
        return ResponseEntity.ok(productUnitSaleService.saveProductUnitSale(productUnitSaleDTO));
    }
    @GetMapping("/ListProductUnitSale")
    public ResponseEntity<List<ProductUnitSale>> fetchProductUnitSaleList() {
        return ResponseEntity.ok(productUnitSaleService.fetchProductUnitSaleList());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ProductUnitSale> findProductUnitSaleById(Long productUnitSaleId
    ) {
        return ResponseEntity.ok(productUnitSaleService.findProductUnitSaleById(productUnitSaleId));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductUnitSale> updateProductUnitSale(ProductUnitSaleDTO productUnitSale
                                                                     , Long productUnitSaleId) {
        return ResponseEntity.ok(productUnitSaleService.updateProductUnitSale(productUnitSale, productUnitSaleId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductUnitSaleById(Long productUnitSaleId) {
        productUnitSaleService.deleteProductUnitSaleById(productUnitSaleId);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
