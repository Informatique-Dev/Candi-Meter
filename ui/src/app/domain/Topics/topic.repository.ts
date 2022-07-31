import { ResourceService } from "src/app/core/services/config/resource.service";
import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Topic } from "./models/topic";

@Injectable({
  providedIn: 'root'
})

export class TopicRepository extends ResourceService<Topic>{
  constructor(httpClient: HttpClient) {
    super(httpClient);
  }
  getResourceUrl(): string {
    return 'topics';
  }

  toServerModel(entity: Topic): any {
    if (!entity.id) {
      return {
        name: entity.name,
        description: entity.description
      }
    }
    else {
      return {
        id: entity.id,
        name: entity.name,
        description: entity.description
      }

    }
  }

}
