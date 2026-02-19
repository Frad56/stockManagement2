import { Component } from '@angular/core';
import{ProductDTO} from '../../../../../shared/models/dto/product.dto';
import { ProductService } from '../../../../../core/services/stockManagment/product.service';
import { inject } from '@angular/core';
import { FormGroup ,ReactiveFormsModule, FormControl} from '@angular/forms';
@Component({
  selector: 'app-product-create',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './product-create.component.html',
  styleUrl: './product-create.component.css'
})
export class ProductCreateComponent 
 {

  private productService  = inject(ProductService)
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
        console.log('Product Edit successfully', response);
        // Optionally, reset the form or navigate to another page
        this.productForm.reset();
      },
      error: (err) => {
        console.error('Error edting product', err);
      
        if (err.error?.message) {
          alert(err.error.message);   // message Spring
        } else {
          alert('Erreur serveur lors editing   product');
        }
        console.log("la response ",productDTO);
      }
      
    });
  }
 


  
  

}
