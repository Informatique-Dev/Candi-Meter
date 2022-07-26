import { ResourceService } from "src/app/core/services/config/resource.service";
import { SettingsService } from "src/app/core/services/config/settings.service";
import { Company } from "./models/company";
import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root'
})

export class CompanyRepository extends ResourceService<Company>{
  constructor(httpClient: HttpClient) {
    super(httpClient);
  }
  getResourceUrl(): string {
    return 'company';
  }

  toServerModel(entity: Company): any {
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
