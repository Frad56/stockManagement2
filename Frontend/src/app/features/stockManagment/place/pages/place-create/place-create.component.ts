import { Component, inject } from '@angular/core';
import { PlaceService } from '../../../../../core/services/stockManagment/place.service';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { PlaceDTO } from '../../../../../shared/models/dto/place.dto';

@Component({
  selector: 'app-place-create',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './place-create.component.html',
  styleUrl: './place-create.component.css'
})
export class PlaceCreateComponent {

  private placeService = inject(PlaceService);
  placeForm = new FormGroup({
    name : new FormControl('')
  })

  private mapFormPlace():PlaceDTO{
    const v =this.placeForm.getRawValue();

    return{
      name:v.name ?? ''
    }
  }
  onSubmit(){
    if(this.placeForm.invalid) return;
    const placeDTO = this.mapFormPlace();
    this.placeService.addPlace(placeDTO).subscribe({
      next: (response) =>{
        console.log("Place created successfully",response);
        this.placeForm.reset();
      },
      error:(err) => {
        console.log("Error creating Place",err);
      }
    })
  }

}

