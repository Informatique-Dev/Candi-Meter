import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CompanyRepository } from '../../domain/company/company.repository';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.sass']
})
export class CompanyComponent implements OnInit {
  companyForm!:FormGroup;
  displayedColumns: string[] = ['id', 'name','description'];
  isVisible:boolean = false;
  constructor(private formBuilder:FormBuilder,private companyRepository:CompanyRepository) { }

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
  Save(){
    if(this.companyForm.valid){
    this.addCompany();
    this.companyForm.reset();
    }
  }
  addCompany(){
    this.companyRepository.add(this.companyForm.value).subscribe(res=>{
     console.log('add');
    })

  }
  changeVisibility(){
    this.isVisible = !this.isVisible
  }
}
