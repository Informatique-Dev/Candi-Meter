import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { CompanyRepository } from 'src/app/domain/company/company.repository';
import { Company } from 'src/app/domain/company/models/company';
import { EmployeeRepository } from 'src/app/domain/employee/employee.repository';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html'
})
export class EmployeeComponent implements OnInit {
  employeeForm!:FormGroup;
  displayedColumns: string[] = ['Question', 'description'];
  isVisible:boolean = false;
  // allCompanies:Company[]=[]
  allCompanies:Observable<Company[]> ;


  constructor(private formBuilder:FormBuilder,private employeeRepository: EmployeeRepository, private companyRepository: CompanyRepository) { }
  ngOnInit(): void {
    this.employForm();
    // this.getAllCompanies();
  }
  employForm(){
    this.employeeForm=this.formBuilder.group({
      id:[''],
      name:['', [Validators.required]],
      company:['', [Validators.required]]
    })
  }
  SaveData() {
    if (this.employeeForm.valid) {
      // this.employeeForm.controls['id'].value ? this.updateCompany() : this.addEmployee();
      this.addEmployee();
      this.employeeForm.reset();
    }

  }
  addEmployee(){
      this.employeeRepository.add(this.employeeForm.value).subscribe(() => {
      console.log('add');

      })
  }
  // getAllCompanies(): void {
  //   this.companyRepository.getList().subscribe(result => {
  //     this.allCompanies = result.data;

  //   })
  // }
  changeVisibility(){
    this.isVisible = !this.isVisible
  }
}
