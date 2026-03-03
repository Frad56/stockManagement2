import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Supplier } from '../../../shared/models/SupplierManagement/Suplier.model';
import { SupplierDTO } from '../../../shared/models/dto/supplierManagementDTO/supplier.dto';

@Injectable({
  providedIn: 'root'
})
export class SupplierService {

  private apiUrl = 'http://localhost:8080/api/supplier';
  private http = inject(HttpClient);

  constructor() { }

  getSuppliers():Observable<Supplier[]>{
    return this.http.get<Supplier[]>(`${this.apiUrl}/all`);
  }

  addSupplier(supplier: SupplierDTO):Observable<Supplier>{
    console.log("Supplier service is called to add a new supplier");
    return this.http.post<Supplier>(`${this.apiUrl}/suppliers`,supplier);
  }

}
