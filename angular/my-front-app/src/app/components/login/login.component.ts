import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtService } from 'src/app/services/jwt.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm!: FormGroup;

  constructor(
    private service: JwtService,
    private fb: FormBuilder,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', Validators.required, Validators.email],
      password: ['', Validators.required],
    })
  }

  submitForm() {
    if (this.loginForm?.value) {
      this.service.login(this.loginForm.value).subscribe(
        (response) => {
          console.log(response);
          if (response?.jwt != null) {
            alert("Hello, Your token is " + response.jwt);
            const jwtToken = response.jwt;
            localStorage.setItem('jwt', jwtToken);
            this.router.navigateByUrl("/dashboard");
          }
        }
      );
    } else {
      console.error("Form is invalid or undefined");
    }
  }
  
}
