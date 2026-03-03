import { Component, inject } from '@angular/core';
import { Route } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {

  private router = inject(Router);

//Stock Managment
//Products
 getProducts(){
    this.router.navigate(['/products']);
 }

 addProduct(){
  this.router.navigate(['/add-product']);
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
}
