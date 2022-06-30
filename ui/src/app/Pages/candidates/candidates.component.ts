import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-candidates',
  templateUrl: './candidates.component.html',
  styleUrls: ['./candidates.component.sass']
})
export class CandidatesComponent implements OnInit {

  constructor(private fb: FormBuilder) { }
  candidateForm : FormGroup;
  ngOnInit(): void {
    this.candiForm();
  }
  candiForm(){
    this.candidateForm = this.fb.group({
      'name':['',Validators.required],
      'phone':['',Validators.required],
      'email':['',Validators.required],
      'cv':['',Validators.required]
      })
  }
  onSubmit(){

  }

}
