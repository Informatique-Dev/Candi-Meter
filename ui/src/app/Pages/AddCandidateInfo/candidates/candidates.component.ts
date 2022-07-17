import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { CandidateRepository } from 'src/app/domain/candidate/candidate.repository';
import { Candidate } from 'src/app/domain/candidate/models/candidate';

@Component({
  selector: 'app-candidates',
  templateUrl: './candidates.component.html',
  styleUrls: ['./candidates.component.sass']
})
export class CandidatesComponent implements OnInit {

  candidateForm !: FormGroup;
  // picture!:FormControl;
  candidateDetails :Candidate;
  fileAttr: string = 'Choose File';
  pictureChanged: boolean = false;

  constructor(private formBuilder: FormBuilder,
    private candidateRepository: CandidateRepository,
    ) { }
  ngOnInit(): void {
    this.candidateDetails ={id:0, name:'', email:'',phone:0,documentId:0,picture:''}
    this.candiForm();
  }
  candiForm(){
    this.candidateForm = this.formBuilder.group({
      id: [''],
      'name':['',Validators.required],
      'phone':['',Validators.required],
      'email':['',Validators.required],
      'picture':[''],

      })
  }
  onSubmit(){
    console.log('data', this.candidateForm);

  //  this.candidateDetails.id=this.candidateForm.value.id;
   this.candidateDetails.name=this.candidateForm.value.name;
   this.candidateDetails.phone=this.candidateForm.value.phone;
   this.candidateDetails.email=this.candidateForm.value.email;
   this.candidateDetails.picture=this.candidateForm.value.picture;



this.candidateRepository.addCandidate(this.candidateDetails).subscribe(res =>{
  console.log(res);
  if (this.pictureChanged){
    this.candidateRepository.addAttachment(this.candidateForm.value.picture,res.id).subscribe(res=>{
      console.log(res);
    });
  }
})
  }

  uploadFileEvt(imgFile: any): void {
    if (imgFile.target.files && imgFile.target.files[0]) {
      this.fileAttr = '';
      this.fileAttr += imgFile.target.files[0].name;
      let reader = new FileReader();
      reader.onload = (e: any): void => {
        // let image = new Image();
        // image.src = e.target.result;
        // this.picture.setValue(e.target.result);
   this.candidateDetails.picture=this.candidateForm.value.picture;

        this.pictureChanged = true;
      };
      reader.readAsDataURL(imgFile.target.files[0]);
    } else {
      this.fileAttr = 'Choose File';
    }
  }

}
