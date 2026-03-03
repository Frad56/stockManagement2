import { Component, inject } from '@angular/core';
import { StockService } from '../../../../../core/services/stockManagment/stock.service';
import { FormControl, FormGroup } from '@angular/forms';
import { StockDTO } from '../../../../../shared/models/dto/stockManagmentDTO/Stock.dto';
import { ReactiveFormsModule } from '@angular/forms';
@Component({
  selector: 'app-stock-create',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './stock-create.component.html',
  styleUrl: './stock-create.component.css'
})
export class StockCreateComponent {

  private stockService = inject(StockService);

  stockForm = new FormGroup({ 
    
    name :new FormControl(''),
    quantity : new FormControl(''),
  });
  
  private mapFormToStock(): StockDTO {
    const v = this.stockForm.getRawValue();
    return {
      name: v.name ?? '',
      quantity: parseInt(v.quantity!)
    };
  }
  onSubmit() {
    if (this.stockForm.invalid) return;
    const stockDTO = this.mapFormToStock();
    this.stockService.addStock(stockDTO).subscribe({
      next: (response) => {
        console.log('Stock created successfully', response);
        this.stockForm.reset();
      },
      error: (err) => {
        console.error('Error creating stock', err);
        if (err.error?.message) {
          alert(err.error.message);   
        } else {
          alert('Erreur serveur lors création stock');
        }
        console.log("la response ", stockDTO);
      }
    });
  }
}
