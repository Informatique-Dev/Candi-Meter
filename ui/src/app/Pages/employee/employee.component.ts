import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PageEvent } from '@angular/material/paginator';
import { BehaviorSubject, switchMap } from 'rxjs';
import { MessageService } from 'src/app/core/services/config/message.service';
import { EmployeeRepository } from 'src/app/domain/employee/employee.repository';
import { Emplyee } from 'src/app/domain/employee/model/Emplyee';

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
  allEmployees: Emplyee[] = [];
  isRestButtonAppear: boolean;

  constructor(
    private formBuilder: FormBuilder,
    private _EmployeeRepository: EmployeeRepository,
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
    this._EmployeeRepository.update(this.employeeForm.value).subscribe(()=>{
      this.getAllEmplyees();this.changeVisibility();
    })
  }
  getAllEmplyees(): void {
    this._EmployeeRepository
      .getList({
        page: this.page,
        size: this.size,
      })
      .subscribe((result) => {
        this.allEmployees = result.data;
        this.totalItems = result.pagination.itemCount;
        console.log(result)
      });
  }
  fetchData(employeeData:Emplyee):void{
  this.employeeForm.reset();
  this.isVisible=true;
  
  this.employeeForm.patchValue({
    id:employeeData.id,
    name:employeeData.name
    
  })

  }
  updateEmployee(){
    this._EmployeeRepository.update(this.employeeForm.value).subscribe(()=>{
      this.getAllEmplyees();
      this.changeVisibility();
    })
  }
  deleteEmployee(employeeData:Emplyee){
    this.message.deleteConfirmation('','Are you sure want to delete this employee ? ').subscribe(res =>{
      if(res.success)
      this._EmployeeRepository.delete(employeeData.id).subscribe(()=>{
        this.getAllEmplyees();
      })
    })
  }
  onSubmit() {}
  changeVisibility() {
    this.isVisible = !this.isVisible;
  }
  appearRest() {
    this.isRestButtonAppear = true;
  }
}
