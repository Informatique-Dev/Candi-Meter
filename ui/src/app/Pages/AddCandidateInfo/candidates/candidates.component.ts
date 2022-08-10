import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators,
} from '@angular/forms';
import { PageEvent } from '@angular/material/paginator';
import { CandidateRepository } from 'src/app/domain/candidate/candidate.repository';
import { Candidate } from 'src/app/domain/candidate/models/candidate';

@Component({
  selector: 'app-candidates',
  templateUrl: './candidates.component.html'

})
export class CandidatesComponent implements OnInit {
  candidateForm!: FormGroup;
  fileAttr: string = 'Choose File';
  pictureChanged: boolean = false;
  dataimage!: any;
  displayedColumns: string[] = [
    'id',
    'name',
    'phone',
    'email',
    'update',
    'delete',
  ];
  isVisible: boolean = false;
  isAppear: boolean = false;

  size: number = 10;
  page: number = 0;
  totalRows: number = 0;
  allCandidates: Candidate[] = [];
  submit: boolean = false;
  submitted: boolean = false;
  constructor(
    private formBuilder: FormBuilder,
    private candidateRepository: CandidateRepository
  ) { }
  ngOnInit(): void {
    this.candidForm();
    this.getAllCandidates();
  }
  candidForm() {
    this.candidateForm = this.formBuilder.group({
      id: [''],
      name: ['', Validators.required],
      phone: ['',[ Validators.required,Validators.pattern('[0-9]{10,10}')]],
      email: ['',[Validators.required, Validators.pattern(/^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/)]],
      documentId: [''],
      picture: [''],
    });
  }
  addCandidate() {
    this.candidateRepository
      .add(this.candidateForm.value)
      .subscribe(() =>{
        this.getAllCandidates();
        this.changeVisibility();
      });
  }
  onSubmit() {
    if (this.candidateForm.valid) {
      this.submitted = true;
      this.candidateForm.controls['id'].value
        ? this.UpdateCandidate()
        : this.addCandidate();
      this.candidateForm.reset();
    }

  }
  uploadFileEvt(imgFile: any): void {
    if (imgFile.target.files && imgFile.target.files[0]) {
      this.fileAttr = '';
      this.fileAttr += imgFile.target.files[0].name;
      let reader = new FileReader();
      reader.onload = (e: any): void => {
        let image = new Image();
        image.src = e.target.result;
        this.candidateForm.controls['picture'].setValue(e.target.result)
        this.dataimage = e.target.result;
        this.pictureChanged = true;
      };
      reader.readAsDataURL(imgFile.target.files[0]);
    } else {
      this.fileAttr = 'Choose File';
    }
  }
  getAllCandidates(): void {
    this.candidateRepository
      .getList({
        page: this.page,
        size: this.size,
      })
      .subscribe((result) => {
        this.allCandidates = result.data;
        this.totalRows = result.pagination.itemCount;
      });
  }
  resetTheForm(): void {
    this.candidateForm.reset();
    this.pictureChanged = false;
  }
  changeVisibility() {
    this.isVisible = !this.isVisible;
  }
  pageChanged(event: PageEvent): void {
    this.size = event.pageSize;
    this.page = event.pageIndex;
    this.getAllCandidates();
  }

  UpdateCandidate() {
    this.candidateRepository.update(this.candidateForm.value).subscribe(() => {
      this.getAllCandidates();
      this.changeVisibility();
    });
  }
  fetchData(candidate: Candidate): void {
    this.resetTheForm();
    this.candidateForm.patchValue({
      id: candidate.id,
      name: candidate.name,
      email: candidate.email,
      phone: candidate.phone,
      documentId: candidate.documentId
    });
  }
  deleteCandidate(candidate: Candidate) {
    this.candidateRepository.delete(candidate.id).subscribe(_ =>
      this.getAllCandidates()
    );
  }
  appearRest() {
    this.isAppear = true;
  }
  openInputField() {
    this.isVisible = true;

  }
}
