import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { routerTransition } from '../router.animation';

@Component({
  selector: 'app-login',
  animations: [routerTransition()],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {
  hidePassword = true;
  loginForm : FormGroup;
  formSubmitted : boolean = false;

  constructor(private fb:FormBuilder, private route:Router) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      'email': ['', Validators.compose([Validators.required, Validators.pattern(/^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/)])],
      'password': ['', Validators.compose([Validators.required])]
  });
  }

  onSubmit() {
    this.formSubmitted = true;
    
    if (this.loginForm.valid) {
    this.route.navigateByUrl("/main/home");
    }
      else {
        this.formSubmitted = false;
      }
  }

}
