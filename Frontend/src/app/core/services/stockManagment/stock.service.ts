import { Injectable,inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import{ Observable } from 'rxjs';
import { Stock } from '../../../shared/models/StockManagment/stock.model';
import { StockDTO } from '../../../shared/models/dto/stockManagmentDTO/Stock.dto';
@Injectable({
  providedIn: 'root'
})
export class StockService {
  private apriUrl = 'http://localhost:8080/api/stock/';
  private http = inject(HttpClient);
  
  getStocks():Observable<Stock[]>{
    return this.http.get<Stock[]>(`${this.apriUrl}stocks`)
  }
  addStock(stock:StockDTO):Observable<Stock>{
    return this.http.post<Stock>(`${this.apriUrl}stocks`,stock)
  }




}
