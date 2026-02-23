package com.example.store.Service.stockManagment;


import com.example.store.DTO.stockManagment.ProductDTO;
import com.example.store.Exception.ElementNotFoundException;
import com.example.store.Model.StockMangement.Product;
import com.example.store.Repository.StockManagment.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private StockService stockService;
    private CategoryService categoryService;
    private PlaceService placeService;

    @Autowired
    private ProductServiceImpl(ProductRepository productRepository,StockService stockService,CategoryService categoryService,PlaceService placeService){
        this.productRepository=productRepository;
        this.stockService=stockService;
        this.categoryService=categoryService;
        this.placeService=placeService;
    }

    //Add
    @Override
    public Product saveProduct(Product product){
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

        productDB.setName(product.getName());
        productDB.setUnityPrice(product.getUnity_price());

        Long stock_id= product.getStock_id();
        productDB.setStock(stockService.findStockById(stock_id));

        Long category_id = product.getCategory_id();
        productDB.setCategory(categoryService.findCategoryById(category_id));


       Long place_id = product.getPlace_id();
       productDB.setPlace(placeService.findPlaceById(place_id));

        return productRepository.save(productDB);

    }



    //search
    @Override
    public Product findProductById(Long productId){
        return productRepository.findById(productId).orElseThrow(() -> new ElementNotFoundException(productId));
    }



}
