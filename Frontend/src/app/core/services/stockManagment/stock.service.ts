import { Injectable,inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import{ Observable } from 'rxjs';
import { Stock } from '../../../shared/models/StockManagment/stock.model';
@Injectable({
  providedIn: 'root'
})
export class StockService {
  private apriUrl = 'http://localhost:8080/';
  private http = inject(HttpClient);
  
  getStocks():Observable<Stock[]>{
    return this.http.get<Stock[]>(`${this.apriUrl}stocks`)
  }
}
