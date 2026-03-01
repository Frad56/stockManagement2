package com.example.store.Service.stockManagment;


import com.example.store.DTO.stockManagment.ProductDTO;
import com.example.store.Model.StockMangement.Product;

import java.util.List;


public interface ProductService {

   Product saveProduct(ProductDTO product);

   List<Product> fetchProductList();

   Product findProductById(Long idProduct);

   Product updateProduct(ProductDTO product, Long productId);

   void deleteProductById(Long productID);

}
