import { CommonModule } from '@angular/common';
import { Component, OnInit, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../../../../../shared/models/StockManagment/product.model';
import { ProductService } from '../../../../../core/services/stockManagment/product.service';

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent implements OnInit {

  products$! : Observable<Product[]>;
  private productService  = inject(ProductService)
  
  ngOnInit(): void {
      this.products$ = this.productService.getProducts()
  }

}
