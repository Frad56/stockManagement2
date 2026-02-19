import { Component, inject } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ProductService } from '../../../../../core/services/stockManagment/product.service';
import { ProductDTO } from '../../../../../shared/models/dto/product.dto';

@Component({
  selector: 'app-product-edit',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './product-edit.component.html',
  styleUrl: './product-edit.component.css'
})
export class ProductEditComponent {

private productService = inject(ProductService);
productForm = new FormGroup({
  code : new FormControl(''),
    name: new FormControl(''),
    unity_price: new FormControl(''),
    category_id: new FormControl(''),
    place_id: new FormControl(''),
    stock_id: new FormControl('')
});
private mapFormToProduct(): ProductDTO {
  const v =this.productForm.getRawValue();
  return {
    code: v.code ?? '', //pour verifier si la valeur est null ou undefined et assigner une chaîne vide à la place
    name: v.name ?? '',
    unityPrice: parseFloat(v.unity_price!), // Convertir en nombre
    category_id: parseInt(v.category_id!), // Convertir en entier
    place_id: parseInt(v.place_id!), // Convertir en entier
    stock_id: parseInt(v.stock_id!) // Convertir en entier
  };
}

onSubmit() {
  if(this.productForm.invalid) return;
  const productDTO = this.mapFormToProduct();
  this.productService.addProduct(productDTO).subscribe({
    next: (response) => {
      console.log('Product created successfully', response);
      // Optionally, reset the form or navigate to another page
      this.productForm.reset();
    },
    error: (err) => {
      console.error('Error creating product', err);
    
      if (err.error?.message) {
        alert(err.error.message);   // message Spring
      } else {
        alert('Erreur serveur lors de la création du produit');
      }
      console.log("la response ",productDTO);
    }
    
  });
}
}
