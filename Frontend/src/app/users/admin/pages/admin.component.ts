import { Component, inject } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';

import { Router } from '@angular/router';
import {MatSidenavModule} from '@angular/material/sidenav';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [MatSidenavModule, MatButtonModule,CommonModule],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {
  showStockManagment = false;
  showUserManagment =false;
  showSupplierManagment = false;
  private router = inject(Router);


//* ****************   SignUP    ************************** */
signUp(){
  this.router.navigate(['/SignUp']);
}
//Stock Managment
//Products
 getProducts(){
    this.router.navigate(['/products']);
 }

 addProduct(){
  this.router.navigate(['/add-product']);
 }

 //add Product Supplier 
  addProductSupplier(){
    this.router.navigate(['product-suppliers/add-product-supplier']);
  }

 //Categorys
 addCategory(){
  this.router.navigate(['categorys/add-category']);
 }

 //Places

 addPlace(){
  this.router.navigate(['places/add-place']);
 }

 //Stocks

 addStock(){
  this.router.navigate(['stocks/add-stock']);
 }

 //supplier
 addSupplier(){
  this.router.navigate(['suppliers/add-supplier']);
 }
 allSuppliers(){
  this.router.navigate(['suppliers/suppliers']);
 }
}
