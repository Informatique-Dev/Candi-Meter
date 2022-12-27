import { animate, style, transition, trigger } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { Topic } from 'src/app/domain/Topics/models/topic';
import { TopicRepository } from 'src/app/domain/Topics/topic.repository';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.sass'],
  animations: [
    trigger('side', [
      transition(':enter', [
        style({ transform: 'translateY(-200px)' }),
        animate(2000),
      ]),
    ]),
    trigger('card-came-left', [
      transition(':enter', [
        style({ transform: 'translateY(200px)' }),
        animate(2000),
      ]),
    ]),
  ],
})
export class HomePageComponent implements OnInit {
  allTopics: Topic[] = [];
  constructor(private topicRepository: TopicRepository) {}
  ngOnInit(): void {
    this.getAllCompanies();
  }
  getAllCompanies(): void {
    this.topicRepository.getList({}).subscribe((result) => {
      this.allTopics = result.data;
    });
  }
}
