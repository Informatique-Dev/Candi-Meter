import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.sass']
})
export class CompanyComponent implements OnInit {
  companyForm!:FormGroup;
  displayedColumns: string[] = ['Question', 'description'];
  isVisible:boolean = false;
  constructor(private formBuilder:FormBuilder) { }

  ngOnInit(): void {
    this.compForm();
  }
  compForm(){
    this.companyForm=this.formBuilder.group({
      id:[''],
      name:['', [Validators.required]],
      description:['', [Validators.required]]
    })
  }
  onSubmit(){

  }
  changeVisibility(){
    this.isVisible = !this.isVisible
  }
}
