import { Component, inject } from '@angular/core';
import { SupplierService } from '../../../../../core/services/supplierManagment/supplier.service';
import { FormControl, FormGroup, ReactiveFormsModule, FormBuilder, Validators, FormArray } from '@angular/forms';
import { SupplierDTO } from '../../../../../shared/models/dto/supplierManagementDTO/supplier.dto';
import { CommonModule } from '@angular/common';
import { Product } from '../../../../../shared/models/StockManagment/product.model';
import { ProductService } from '../../../../../core/services/stockManagment/product.service';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatOption } from "@angular/material/core";
import { MatSelectModule } from '@angular/material/select';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-create-supplier',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CommonModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatCardModule
  ],
  templateUrl: './create-supplier.component.html',
  styleUrls: ['./create-supplier.component.css']
})
export class CreateSupplierComponent {

  private supplierService = inject(SupplierService);
  private formBuilder = inject(FormBuilder);
  private productService = inject(ProductService);


  products: Product[] = [];

  supplierForm = this.formBuilder.group({
    company_name:[''],
    contact_name: [''],
    phone_number:[''],
    fax:[''],
    email:['',Validators.email],
    address:[''],
    city:[''],
    postal_code:[''],
    country:[''],
    productIds: [[]] 

  });

constructor() {
  this.productService.getProducts().subscribe(
    products => {this.products = products});
}

 
    
private mapFormToSupplier(): SupplierDTO {
  return this.supplierForm.getRawValue() as unknown as SupplierDTO;
}
  onSubmit() {
    if(this.supplierForm.invalid) return;
    const supplierDTO = this.mapFormToSupplier();
    this.supplierService.addSupplier(supplierDTO).subscribe({
      next: (response) => {
        console.log('Supplier created successfully', response);
        this.supplierForm.reset();
      },
      error: (err) => {
        console.error('Error creating supplier', err);
        if (err.error?.message) {
          alert(err.error.message);   
        } else {
          alert('Erreur serveur lors création   supplier');
        }
        console.log("la response ",supplierDTO);
      }
      
    });

  }

}

