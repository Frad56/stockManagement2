package com.example.store.Controller.stockMangment;


import com.example.store.DTO.stockManagment.ProductVariantDTO;
import com.example.store.Model.StockMangement.ProductVariant;
import com.example.store.Service.stockManagment.interfaces.ProductVariantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productVariant")
public class ProductVariantController {
    private final ProductVariantService productVariantService;
    public ProductVariantController(ProductVariantService productVariantService) {
        this.productVariantService = productVariantService;
    }

    @PostMapping("/addProductVariant")
    public ResponseEntity<ProductVariant> saveProductVariant(ProductVariantDTO productVariantDTO) {
        return ResponseEntity.ok(productVariantService.saveProductVariant(productVariantDTO));
    }
    @GetMapping("/ListProductVariants")
    public ResponseEntity<List<ProductVariant>> fetchProductVariantList() {
        return ResponseEntity.ok(productVariantService.fetchProductVariantList());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ProductVariant> findProductVariantById(Long productVariantId) {
        return ResponseEntity.ok(productVariantService.findProductVariantById(productVariantId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductVariantById(Long productVariantId) {
        productVariantService.deleteProductVariantById(productVariantId);
        return ResponseEntity.ok("Deleted Successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductVariant> updateProductVariant(ProductVariantDTO productVariantDTO, Long productVariantId) {
        return ResponseEntity.ok(productVariantService.updateProductVariant(productVariantDTO, productVariantId));
    }
}
