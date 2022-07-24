import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PageEvent } from '@angular/material/paginator';
import { Company } from 'src/app/domain/company/models/company';
import { CompanyRepository } from '../../domain/company/company.repository';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.sass']
})
export class CompanyComponent implements OnInit {
  companyForm!:FormGroup;
  displayedColumns: string[] = ['id', 'name','description','update','delete'];
  isVisible:boolean = false;
  allCompanies:Company[]=[];
  size:number=0;
  page:number=0;
  totalRows:number=0;
  constructor(private formBuilder:FormBuilder,private companyRepository:CompanyRepository) { }

  ngOnInit(): void {
    this.compForm();
    this.getAllCompanies();
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
    this.companyRepository.add(this.companyForm.value).subscribe(_=>{ })
  }
  getAllCompanies(){
    this.companyRepository.getList().subscribe(result=>{
      this.allCompanies = result.data;
    })

  }
  pageChange(event:PageEvent){
     this.size= event.pageSize;
     this.page= event.pageIndex;
     this.getAllCompanies();
  }
  changeVisibility(){
    this.isVisible = !this.isVisible
  }
}
