import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PageEvent } from '@angular/material/paginator';
import { Question } from 'src/app/domain/Question/models/question';
import { QuestionRepository } from 'src/app/domain/Question/question.repository';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html'
})


export class QuestionComponent implements OnInit {
  questionForm!:FormGroup;
  displayedColumns: string[] = ['id', 'description', 'update', 'delete'];
  isVisible:boolean = false;
  isRestButtonAppear: boolean = false;
  allQuestions:Question[]=[];
  page:number=0;
  size:number=10;
  totalItems:number=0;


  constructor(private formBuilder: FormBuilder, private questionRepository:QuestionRepository) { }

  ngOnInit(): void {
    this.questForm();
    this.getAllQuestions();
  }
  questForm(){
    this.questionForm=this.formBuilder.group({
      id:[''],
      description:['', [Validators.required]]
    })
  }
  SaveData() {
    if (this.questionForm.valid) {
      this.questionForm.controls['id'].value ? this.updateQuestion() : this.addQuestion();
      this.questionForm.reset();
    }

  }
  addQuestion() {
    this.questionRepository.add(this.questionForm.value).subscribe(() => { this.getAllQuestions()})
  }
  getAllQuestions(): void {
    this.questionRepository.getList({
      page: this.page,
      size: this.size
    }).subscribe(result => {
      this.allQuestions = result.data;
      this.totalItems = result.pagination.itemCount
    })
  }
  pageChange(event: PageEvent) {
    this.size = event.pageSize;
    this.page = event.pageIndex;
    this.getAllQuestions();
  }
  fetchData(questionData:Question): void {
    this.questionForm.reset();
    this.isVisible = true;

    this.questionForm.patchValue({
      id: questionData.id,
      description: questionData.description
    })
  }
  updateQuestion() {
    this.questionRepository.update(this.questionForm.value).subscribe(() => {
      this.getAllQuestions();
      this.changeVisibility();
    });
  }
  deleteQuestion(questionData: Question) {
    this.questionRepository.delete(questionData.id).subscribe(() => {
      this.getAllQuestions();
    })
  }
  changeVisibility(){
    this.isVisible = !this.isVisible
  }
  appearRest() {
    this.isRestButtonAppear = true;
  }
  resetTheForm(){
    this.questionForm.reset();
  }
}


