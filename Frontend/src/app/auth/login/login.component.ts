import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../service/auth.service';
import { CommonModule } from '@angular/common'; 
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, RouterLink,CommonModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {


  userForm: FormGroup;


  errorMessage: string = '';

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.userForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(4)]]
    });
  }

 
  login() {
    if (this.userForm.invalid) return;

  
    const loginData = {
      username: this.userForm.value.username,
      password: this.userForm.value.password
    };

    this.authService.login(loginData).subscribe({
      next: (response) => {
      
        this.router.navigate(['/dashboard']); 
      },
      error: (err) => {
        console.error(err);
        this.errorMessage = 'Nom d’utilisateur ou mot de passe incorrect';
      }
    });
  }
}