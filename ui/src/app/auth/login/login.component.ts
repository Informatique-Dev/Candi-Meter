import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {

  loginForm : FormGroup ;
  formSubmitted : boolean = false;

  constructor(private fb:FormBuilder) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      'email': ['', Validators.compose([Validators.required, Validators.pattern(/^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/)])],
      'password': ['', Validators.compose([Validators.required])]
  });
  }

  onSubmit(Form:any) {
      this.formSubmitted = true;
      if (this.loginForm.valid) {
          console.log("success login")
        }
      else {
          console.log("The form is NOT valid!");
          this.formSubmitted = false;
      }
  }

}
