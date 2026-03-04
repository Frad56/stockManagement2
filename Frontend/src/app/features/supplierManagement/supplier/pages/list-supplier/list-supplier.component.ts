import { Component, OnInit, inject } from '@angular/core';
import { SupplierService } from '../../../../../core/services/supplierManagment/supplier.service';
import { Observable } from 'rxjs';
import { Supplier } from '../../../../../shared/models/SupplierManagement/Suplier.model';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-list-supplier',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './list-supplier.component.html',
  styleUrl: './list-supplier.component.css'
})
export class ListSupplierComponent  implements OnInit {

  private supplierService = inject(SupplierService);
  suppliers$!  : Observable<Supplier[]>;

  ngOnInit(): void {
    this.suppliers$ = this.supplierService.getSuppliers();

  }



}
