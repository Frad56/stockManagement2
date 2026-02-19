import { Injectable,inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../../../shared/models/StockManagment/product.model';
import { ProductDTO } from '../../../shared/models/dto/product.dto';
@Injectable({
  providedIn: 'root'
})
export class ProductService {
private apiUrl = 'http://localhost:8080/';
private http = inject(HttpClient);

getProducts() : Observable<Product[]>{
  return this.http.get<Product[]>(`${this.apiUrl}products`);

}

addProduct(product:ProductDTO):Observable<Product>{
  console.log("le product Envoi au backend ",product);
  return this.http.post<ProductDTO>(`${this.apiUrl}products`,product);
}

editProduct(id:number,product:ProductDTO):Observable<Product>{
  return this.http.put<Product>(`${this.apiUrl}products/${id}`,product);
}



}