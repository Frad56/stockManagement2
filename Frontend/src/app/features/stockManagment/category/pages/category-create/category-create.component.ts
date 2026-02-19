import { Component, inject } from '@angular/core';
import { CategoryService } from '../../../../../core/services/stockManagment/category.service';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CategoryDTO } from '../../../../../shared/models/dto/Category.dto';

@Component({
  selector: 'app-category-create',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './category-create.component.html',
  styleUrl: './category-create.component.css'
})
export class CategoryCreateComponent {

  private categoryService = inject(CategoryService);
  categoryForm = new FormGroup({
    name : new FormControl('')
  })

  private mapFormCatgory():CategoryDTO
  {
    const v = this.categoryForm.getRawValue();
    return {
      name: v.name ?? ''
    }
  }
  onSubmit(){
    if(this.categoryForm.invalid) return;
    const categoryDTO = this.mapFormCatgory();
    this.categoryService.addCategory(categoryDTO).subscribe({
      next: (response) =>{
        console.log("Category created successfully",response);
        this.categoryForm.reset();
      },
      error:(err) => {
        console.log("Error creating Category",err);
      }
    })
  }
}
