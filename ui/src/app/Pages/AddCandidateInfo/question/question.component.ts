import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: []
})


export class QuestionComponent implements OnInit {
  questionForm!:FormGroup;
  displayedColumns: string[] = ['Question', 'description'];
  isVisible:boolean = false;


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
  }
}


