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
  dataimage!:any
  constructor(private formBuilder: FormBuilder,
    private candidateRepository: CandidateRepository,
    ) { }
  ngOnInit(): void {
    this.candidateDetails ={id:0, name:'', email:'',phone:'',documentId:0,picture:''}
    this.candidForm();
  }
  candidForm(){
    this.candidateForm = this.formBuilder.group({
      'id': [''],
      'name':['',Validators.required],
      'phone':['',Validators.required],
      'email':['',Validators.required],
      'documentId': [''],
      'picture':['']
      })
  }
  add(){
    console.log('data', this.candidateForm);

    this.candidateDetails.id=this.candidateForm.value.id;
    this.candidateDetails.name=this.candidateForm.value.name;
    this.candidateDetails.phone=this.candidateForm.value.phone;
    this.candidateDetails.email=this.candidateForm.value.email;
    this.candidateDetails.documentId=this.candidateForm.value.documentId;
    this.candidateDetails.picture=this.candidateForm.value.picture;

  }
  onSubmit(){

    this.add();
    console.log('jj',this.candidateForm,this.candidateDetails)
    this.candidateRepository.addCandidate(this.candidateDetails).subscribe(res =>{
      console.log(res);
      if (this.pictureChanged){
      console.log('hh');
      // this.candidateRepository.addAttachment(this.candidateForm.value.picture,res.id).subscribe(res=>{
      //   console.log('ff',res);
      // });
      this.candidateRepository.addAttachmentfi(this.candidateForm.value.picture,res.id).subscribe(res=>{
        console.log('ff',res);
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
        let image = new Image();
        image.src = e.target.result;
        // this.picture.setValue(e.target.result);
       this.candidateDetails.picture=e.target.result;
       this.dataimage=e.target.result
       console.log('img', this.candidateDetails.picture)

        this.pictureChanged = true;
      };
      reader.readAsDataURL(imgFile.target.files[0]);
    } else {
      this.fileAttr = 'Choose File';
    }
  }

}
