import { Injectable } from '@angular/core';
import { SettingsService } from 'src/app/core/services/config/settings.service';
import { Candidate } from "./models/candidate";
import { ResourceService } from 'src/app/core/services/config/resource.service';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class CandidateRepository extends ResourceService<Candidate> {
  private readonly url = `${SettingsService.configurationEnvironment.api.baseUrl}`;
  constructor(protected httpClient: HttpClient) {
    super(httpClient);
  }

  getResourceUrl(): string {
    return 'candidate';
  };

  toServerModel(entity: Candidate): any {
    if (!entity.id) {
      return {
        name: entity.name,
        phone: entity.phone,
        email: entity.email
      };
    } else {
      return {
        id: entity.id,
        name: entity.name,
        phone: entity.phone,
        email: entity.email,
        documentId: entity.documentId,
      };
    }
  };

}
