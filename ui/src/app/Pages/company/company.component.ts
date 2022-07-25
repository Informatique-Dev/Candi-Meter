import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PageEvent } from '@angular/material/paginator';
import { BehaviorSubject } from 'rxjs';
import { switchMap } from 'rxjs/operators';

import { Company } from 'src/app/domain/company/models/company';
import { CompanyRepository } from '../../domain/company/company.repository';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.sass']
})
export class CompanyComponent implements OnInit {
  companyForm!: FormGroup;
  displayedColumns: string[] = ['id', 'name', 'description', 'update', 'delete'];
  isVisible: boolean = false;
  isAppear: boolean = false;
  allCompanies: Company[] = [];
  size: number = 10;
  page: number = 0;
  totalItems: number = 0;
  constructor(private formBuilder: FormBuilder, private companyRepository: CompanyRepository) { }

  ngOnInit(): void {
    this.compForm();
    this.getAllCompanies();
  }
  compForm() {
    this.companyForm = this.formBuilder.group({
      id: [''],
      name: ['', [Validators.required]],
      description: ['', [Validators.required]]
    })
  }
  SaveData() {
    if (this.companyForm.valid) {
      this.companyForm.controls['id'].value ? this.updateCompany() : this.addCompany();
      this.companyForm.reset();
    }

  }
  addCompany() {
    this.companyRepository.add(this.companyForm.value).subscribe(() => { this.getAllCompanies(); })
  }
  getAllCompanies(): void {
    this.companyRepository.getList({
      page: this.page,
      size: this.size
    }).subscribe(result => {
      this.allCompanies = result.data;
      this.totalItems = result.pagination.itemCount
    })
  }
  pageChange(event: PageEvent) {
    this.size = event.pageSize;
    this.page = event.pageIndex;
    this.getAllCompanies();
  }
  fetchData(companyData: Company): void {
    this.companyForm.reset();
    this.companyForm.patchValue({
      id: companyData.id,
      name: companyData.name,
      description: companyData.description
    })
  }
  updateCompany() {
    this.companyRepository.update(this.companyForm.value).subscribe(() => {
      this.getAllCompanies();
      this.changeVisibility();
    });
  }
  deleteCompany(companyData: Company) {
    this.companyRepository.delete(companyData.id).subscribe(() => {
      this.getAllCompanies();
    })
  }
  changeVisibility() {
    this.isVisible = !this.isVisible
  }
  openInputField() {
    this.isVisible = true;

  }
  appearRest() {
    this.isAppear = true;
  }
}
