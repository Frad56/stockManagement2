import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductSupplierService {

  private apiUrl = 'http://localhost:8080/api/api/productSupplier/';
  private http = inject(HttpClient);


  constructor() { }
}
