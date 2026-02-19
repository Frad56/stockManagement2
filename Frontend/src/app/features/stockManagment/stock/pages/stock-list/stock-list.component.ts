import { CommonModule } from '@angular/common';
import { Component, OnInit, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Stock } from '../../../../../shared/models/StockManagment/stock.model';
import { StockService } from '../../../../../core/services/stockManagment/stock.service';
@Component({
  selector: 'app-stock-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './stock-list.component.html',
  styleUrl: './stock-list.component.css'
})
export class StockListComponent implements OnInit{
  stocks$!: Observable<Stock[]>

  private stockService = inject(StockService);
  ngOnInit(): void {
      this.stocks$ = this.stockService.getStocks();
  }

}
