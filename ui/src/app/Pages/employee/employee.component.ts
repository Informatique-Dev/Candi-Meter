import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PageEvent } from '@angular/material/paginator';
import { BehaviorSubject, switchMap } from 'rxjs';
import { MessageService } from 'src/app/core/services/config/message.service';
import { EmployeeRepository } from 'src/app/domain/employee/employee.repository';
import { emplyee } from 'src/app/domain/employee/model/emplyee';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
})
export class EmployeeComponent implements OnInit {
  employeeForm!: FormGroup;
  displayedColumns: string[] = ['id','name','delete','update'];
  isVisible: boolean = false;
  page: number = 0;
  size: number = 10;
  totalItems: number = 0;
  allEmployees: emplyee[] = [];
  isRestButtonAppear: boolean;

  constructor(
    private formBuilder: FormBuilder,
    private employeeRepository: EmployeeRepository,
    private message: MessageService
  ) {}
  ngOnInit(): void {
    this.employForm();
    this.getAllEmplyees();
  }
  employForm() {
    this.employeeForm = this.formBuilder.group({
      id: [''],
      name: ['', [Validators.required]],
      companyId: ['', [Validators.required]],
    });
  }
  SaveData(){
   if(this.employeeForm.valid){
    this.employeeForm.controls['id'].value? this.updateEmployee():this.addEmployee();
  this.employeeForm.reset(); 
  }
  }
  addEmployee(){
    this.employeeRepository.add(this.employeeForm.value).subscribe(()=>{
      this.getAllEmplyees();this.changeVisibility();
    })
  }
  getAllEmplyees(): void {
    this.employeeRepository
      .getList({
        page: this.page,
        size: this.size,
      })
      .subscribe((result) => {
        this.allEmployees = result.data;
        this.totalItems = result.pagination.itemCount;
      });
  }
  fetchData(employeeData:emplyee):void{
  this.employeeForm.reset();
  this.isVisible=true;
  
  this.employeeForm.patchValue({
    id:employeeData.id,
    name:employeeData.name
    
  })

  }
  updateEmployee(){
    this.employeeRepository.update(this.employeeForm.value).subscribe(()=>{
      this.getAllEmplyees();
      this.changeVisibility();
    })
  }
  deleteEmployee(employeeData:emplyee){
    this.message.deleteConfirmation('','Are you sure want to delete this employee ? ').subscribe(res =>{
      if(res.success)
      this.employeeRepository.delete(employeeData.id).subscribe(()=>{
        this.getAllEmplyees();
      })
    })
  }
  changeVisibility() {
    this.isVisible = !this.isVisible;
  }

}
