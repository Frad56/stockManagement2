import { Injectable,inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Place } from '../../../shared/models/StockManagment/place.model';
import { Observable } from 'rxjs';
import { PlaceDTO } from '../../../shared/models/dto/place.dto';
@Injectable({
  providedIn: 'root'
})
export class PlaceService {

  private apiUrl = 'http://localhost:8080/';
  private http = inject(HttpClient);

  getPlaces(): Observable<Place[]>{
    return this.http.get<Place[]>(`${this.apiUrl}places`);
  }

  addPlace(place:PlaceDTO):Observable<Place>{
    return this.http.post<Place>(`${this.apiUrl}places`,place);
  }
}
