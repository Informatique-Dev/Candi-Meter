import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html'
})
export class EmployeeComponent implements OnInit {
  employeeForm!:FormGroup;
  displayedColumns: string[] = ['Question', 'description'];
  isVisible:boolean = false;
  constructor(private formBuilder:FormBuilder) { }
  ngOnInit(): void {
    this.employForm();
  }
  employForm(){
    this.employeeForm=this.formBuilder.group({
      id:[''],
      name:['', [Validators.required]],
      company_id:['', [Validators.required]]
    })
  }
  onSubmit(){

  }
  changeVisibility(){
    this.isVisible = !this.isVisible
  }
}
