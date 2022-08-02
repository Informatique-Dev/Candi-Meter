import { Injectable } from "@angular/core";
import { Question } from './models/question';
import { ResourceService } from 'src/app/core/services/config/resource.service';

@Injectable({
  providedIn: 'root'
})
export class QuestionRepository extends ResourceService<Question>{
  getResourceUrl(): string {
    return 'question';
  }
  toServerModel(entity: Question) {
    if (!entity.id) {
      return {
        description: entity.description
      }
    }
    else {
      return {
        id: entity.id,
        description: entity.description

      }
    }
  }
}
