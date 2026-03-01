package com.example.store.Service.stockManagment;


import com.example.store.DTO.stockManagment.ProductDTO;
import com.example.store.Exception.ElementNotFoundException;
import com.example.store.Model.StockMangement.Category;
import com.example.store.Model.StockMangement.Place;
import com.example.store.Model.StockMangement.Product;
import com.example.store.Model.StockMangement.Stock;
import com.example.store.Model.supplierManagement.ProductSupplier;
import com.example.store.Repository.StockManagment.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Product saveProduct(ProductDTO dto){
        Category category = categoryService.findCategoryById(dto.getCategory_id());
        System.out.println("******************************");
        System.out.println(category);

        Place place = placeService.findPlaceById(dto.getPlace_id());
        System.out.println("******************************");
        System.out.println(place);
        System.out.println("******************************");

        Stock stock = stockService.findStockById(dto.getStock_id());
        System.out.println("******************************");
        System.out.println(stock);

        Product product = new Product();
        product.setCode(dto.getCode());
        product.setName(dto.getName());
        product.setUnityPrice(dto.getUnity_price());
        product.setCategory(category);
        product.setPlace(place);
        product.setStock(stock);
        List<ProductSupplier> productSuppliers = new ArrayList<>();




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
