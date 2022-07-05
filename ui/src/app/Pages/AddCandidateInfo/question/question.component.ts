import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.sass']
})


export class QuestionComponent implements OnInit {
  questionForm!:FormGroup;
  isVisible:boolean = false;
  visibileIcon:string='visibility_off'
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.questForm();
  }
  questForm(){
    this.questionForm=this.formBuilder.group({
      id:[''],
      description:['', [Validators.required]]
    })
  }
  onSubmit(){

  }
  changeVisibility(){
    this.isVisible = !this.isVisible
    this.visibileIcon=this.isVisible?'visibility':'visibility_off'
  }
  displayedColumns: string[] = ['Question', 'description']
}


