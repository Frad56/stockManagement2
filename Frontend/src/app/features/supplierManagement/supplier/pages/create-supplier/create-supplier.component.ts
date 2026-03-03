import { Component, inject } from '@angular/core';
import { SupplierService } from '../../../../../core/services/supplierManagment/supplier.service';
import { FormControl, FormGroup, ReactiveFormsModule, FormBuilder, Validators, FormArray } from '@angular/forms';
import { SupplierDTO } from '../../../../../shared/models/dto/supplierManagementDTO/supplier.dto';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-create-supplier',
  standalone: true,
  imports: [ReactiveFormsModule,CommonModule],
  templateUrl: './create-supplier.component.html',
  styleUrl: './create-supplier.component.css'
})
export class CreateSupplierComponent {

  private supplierService = inject(SupplierService);
  private formBuilder = inject(FormBuilder);

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
    productIds: this.formBuilder.array([])    

  });
  get productIds() {
    return this.supplierForm.get('productIds') as FormArray;
  }

  private mapFormToSupplier(): SupplierDTO {
    const v = this.supplierForm.getRawValue();
    return {
      company_name: v.company_name ?? '',
      contact_name: v.contact_name ?? '',
      phone_number: v.phone_number ?? '',
      fax: v.fax ?? '',
      email: v.email ?? '',
      address: v.address ?? '',
      city: v.city ?? '',
      postal_code: v.postal_code ?? '',
      country: v.country ?? '',
      productIds: (v.productIds as number[]) ?? []
    };
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
