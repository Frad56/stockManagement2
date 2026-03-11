package com.example.store.Controller.stockMangment;


import com.example.store.DTO.stockManagment.ProductDTO;

import com.example.store.Model.StockMangement.Product;

import com.example.store.Service.stockManagment.interfaces.CategoryService;
import com.example.store.Service.stockManagment.interfaces.ProductService;
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



    @Autowired
    public ProductController(ProductService productService,
                             CategoryService categoryService,
                            ){
        this.productService =productService;
        this.categoryService = categoryService;

    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody ProductDTO dto) {
       return ResponseEntity.ok(productService.saveProduct(dto));
    }

    @GetMapping("/ListProducts")
    public ResponseEntity< List<Product> >fetchProductList(){
        List<Product> products =productService.fetchProductList();;
        return ResponseEntity.ok(products);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable("id") Long productId){
        Product product =  productService.findProductById(productId);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductByID(@PathVariable("id") Long productId){
        productService.deleteProductById(productId);
        return ResponseEntity.ok("Deleted Successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProductBuId(@RequestBody ProductDTO productDTO,@PathVariable Long id){
        Product updatedProduct = productService.updateProduct(productDTO,id);
        return  ResponseEntity.ok(updatedProduct);
    }

}
