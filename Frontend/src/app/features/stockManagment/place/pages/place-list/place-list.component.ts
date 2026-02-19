import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Place } from '../../../../../shared/models/StockManagment/place.model';
import { PlaceService } from '../../../../../core/services/stockManagment/place.service';


@Component({
  selector: 'app-place-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './place-list.component.html',
  styleUrl: './place-list.component.css'
})
export class PlaceListComponent implements OnInit {

  places$!: Observable<Place[]>;

  private placeService = inject(PlaceService);

  ngOnInit(): void {
    this.places$ = this.placeService.getPlaces();
  }
}
