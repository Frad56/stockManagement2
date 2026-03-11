package com.example.store.Service.stockManagment.implementation;


import com.example.store.DTO.stockManagment.ProductDTO;
import com.example.store.Exception.ElementNotFoundException;
import com.example.store.Model.StockMangement.Category;
import com.example.store.Model.StockMangement.Product;
import com.example.store.Repository.StockManagment.ProductRepository;
import com.example.store.Service.stockManagment.interfaces.CategoryService;
import com.example.store.Service.stockManagment.interfaces.ProductService;
import com.example.store.Service.supplierManagement.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private CategoryService categoryService;

    private SupplierService supplierService;

    @Autowired
    private ProductServiceImpl(ProductRepository productRepository,CategoryService categoryService){
        this.productRepository=productRepository;
        this.categoryService=categoryService;

    }

    //Add
    @Override
    public Product saveProduct(ProductDTO dto){


        Product product = new Product();
        product.setReference(dto.getReference());
        product.setDesignation(dto.getDesignation());
        product.setBrand(dto.getBrand());
        product.setDescription(dto.getDescription());
        product.setBasePrice(dto.getBasePrice());

        Category category =


        return productRepository.save(product);
    }

    //Read
    @Override
    public List<Product> fetchProductList(){
        return (List<Product>) productRepository.findAll();
    }

    //delete
    @Override
    public void deleteProductById(Long productId){
        if(!productRepository.existsById(productId)){
            throw new ElementNotFoundException(productId);
        }
        productRepository.deleteById(productId);
    }

    //Update
   @Override
    public Product updateProduct(ProductDTO product, Long productId){
        Product productDB = productRepository.findById(productId).orElseThrow(()-> new ElementNotFoundException(productId));

//        productDB.setName(product.getName());
//        productDB.setUnityPrice(product.getUnity_price());
//
//        Long stock_id= product.getStock_id();
//        productDB.setStock(stockService.findStockById(stock_id));
//
//        Long category_id = product.getCategory_id();
//        productDB.setCategory(categoryService.findCategoryById(category_id));
//
//
//       Long place_id = product.getPlace_id();
//       productDB.setPlace(placeService.findPlaceById(place_id));

        return productRepository.save(productDB);

    }



    //search
    @Override
    public Product findProductById(Long productId){
        return productRepository.findById(productId).orElseThrow(() -> new ElementNotFoundException(productId));
    }



}
