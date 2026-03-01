package com.example.store.Controller.stockMangment;


import com.example.store.DTO.stockManagment.ProductDTO;
import com.example.store.Model.StockMangement.Category;
import com.example.store.Model.StockMangement.Place;
import com.example.store.Model.StockMangement.Product;
import com.example.store.Model.StockMangement.Stock;
import com.example.store.Service.stockManagment.CategoryService;
import com.example.store.Service.stockManagment.PlaceService;
import com.example.store.Service.stockManagment.ProductService;
import com.example.store.Service.stockManagment.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {


    private final ProductService productService;
    private final CategoryService categoryService;
    private final StockService stockService;
    private  final PlaceService placeService;


    @Autowired
    public ProductController(ProductService productService,
                             CategoryService categoryService,
                             StockService stockService,
                             PlaceService placeService){
        this.productService =productService;
        this.categoryService = categoryService;
        this.stockService = stockService;
        this.placeService = placeService;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody ProductDTO dto) {
       return ResponseEntity.ok(productService.saveProduct(dto));
    }

    @GetMapping("/products")
    public ResponseEntity< List<Product> >fetchProductList(){
        List<Product> products =productService.fetchProductList();;
        return ResponseEntity.ok(products);
    }

    @GetMapping("/products/find/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable("id") Long productId){
        Product product =  productService.findProductById(productId);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProductByID(@PathVariable("id") Long productId){
        productService.deleteProductById(productId);
        return ResponseEntity.ok("Deleted Successfully");
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProductBuId(@RequestBody ProductDTO productDTO,@PathVariable Long id){
        Product updatedProduct = productService.updateProduct(productDTO,id);
        return  ResponseEntity.ok(updatedProduct);
    }

}
