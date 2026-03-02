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

 getProducts(){
    this.router.navigate(['/products']);
 }

 addProduct(){
  this.router.navigate(['/add-product']);
 }
 addCategory(){
  this.router.navigate(['categorys/add-category']);
 }
}
