import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { PageEvent } from '@angular/material/paginator';
import { CandidateRepository } from 'src/app/domain/candidate/candidate.repository';
import { Candidate } from 'src/app/domain/candidate/models/candidate';

@Component({
  selector: 'app-candidates',
  templateUrl: './candidates.component.html',
  styleUrls: ['./candidates.component.sass'],
})
export class CandidatesComponent implements OnInit {
  candidateForm!: FormGroup;
  candidateDetails: Candidate;
  fileAttr: string = 'Choose File';
  pictureChanged: boolean = false;
  dataimage!: any;
  displayedColumns: string[] = [
    'id',
    'name',
    'phone',
    'email',
    'delete',
    'update',
  ];
  isVisible: boolean = false;
  isAppear: boolean = false;

  size: number = 10;
  page: number = 0;
  totalRows: number = 0;
  allCandidates: Candidate[] = [];
  submit: boolean = false;
  constructor(
    private formBuilder: FormBuilder,
    private candidateRepository: CandidateRepository
  ) {}
  ngOnInit(): void {
    this.candidForm();
    this.getAllCandidates();
  }
  candidForm() {
    this.candidateForm = this.formBuilder.group({
      id: [''],
      name: ['', Validators.required],
      phone: ['', Validators.required],
      email: ['', Validators.required],
      documentId: [''],
      picture: [''],
    });
  }
  saveCandidate() {
    this.candidateDetails.id = this.candidateForm.value.id;
    this.candidateDetails.name = this.candidateForm.value.name;
    this.candidateDetails.phone = this.candidateForm.value.phone;
    this.candidateDetails.email = this.candidateForm.value.email;
    this.candidateDetails.documentId = this.candidateForm.value.documentId;
    this.candidateDetails.picture = this.candidateForm.value.picture;
  }
  addCandidate() {
    this.addCandidate();
    if (this.candidateForm.valid) {
      this.candidateRepository
        .addCandidate(this.candidateDetails)
        .subscribe((res) => {
          if (this.pictureChanged) {
            // this.candidateRepository.addAttachment(this.candidateForm.value.picture,res.id).subscribe(res=>{
            // });
            this.candidateRepository
              .addAttachmentfi(this.candidateForm.value.picture, res.id)
              .subscribe((res) => {});
          }
        });
    }
  }
  onSubmit() {
    this.candidateForm.controls['id'].value
      ? this.UpdateCandidate()
      : this.addCandidate();
  }
  uploadFileEvt(imgFile: any): void {
    if (imgFile.target.files && imgFile.target.files[0]) {
      this.fileAttr = '';
      this.fileAttr += imgFile.target.files[0].name;
      let reader = new FileReader();
      reader.onload = (e: any): void => {
        let image = new Image();
        image.src = e.target.result;
        // this.picture.setValue(e.target.result);
        this.candidateDetails.picture = e.target.result;
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
      .getListByCandidate({
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
      this.resetTheForm();
      this.getAllCandidates();
      this.changeVisibility();
    });
  }
  fetchData(candidate: Candidate): void {
    this.resetTheForm();
    this.candidateForm.controls['id'].patchValue(candidate.id),
      this.candidateForm.controls['name'].patchValue(candidate.name),
      this.candidateForm.controls['email'].patchValue(candidate.email);
    this.candidateForm.controls['phone'].patchValue(candidate.phone);
    this.candidateForm.controls['documentId'].patchValue(candidate.documentId);
  }
  deleteCandidate(candidate: Candidate) {
    this.candidateRepository.delete(candidate.id).subscribe((result) => {
      this.getAllCandidates();
    });
  }
  appearrest() {
    this.isAppear = true;
  }
}
