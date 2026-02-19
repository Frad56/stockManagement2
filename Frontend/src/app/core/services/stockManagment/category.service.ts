import { Injectable,Inject, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Category } from '../../../shared/models/StockManagment/category.model';
import{ Observable } from 'rxjs';
import { CategoryDTO } from '../../../shared/models/dto/Category.dto';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private apriUrl = 'http://localhost:8080/';
  private http = inject(HttpClient);

  getCategories():Observable<Category[]>{
    return this.http.get<Category[]>(`${this.apriUrl}category`);
  }

  addCategory(category : CategoryDTO):Observable<Category>{
    console.log("Category service is called to add a new category");
    return this.http.post<Category>(`${this.apriUrl}category`,category);
  }
}
