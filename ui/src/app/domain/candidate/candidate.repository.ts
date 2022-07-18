import { Injectable } from '@angular/core';
import { SettingsService } from 'src/app/core/services/config/settings.service';
import { Candidate } from "./models/candidate";
import { ResourceService } from 'src/app/core/services/config/resource.service';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})

export class CandidateRepository extends ResourceService<Candidate> {
  private readonly url = `${SettingsService.configurationEnvironment.api.baseUrl}`;
  constructor(protected  httpClient: HttpClient) {
    super(httpClient);
  }


   getResourceUrl(): string{
    return 'candidate';
   };


  addCandidate(resource: Candidate):Observable<{id :number}> {
        return this.httpClient.post<{id :number}>(`${this.url}candidate`,this.toServerModel(resource)).pipe(
          catchError(err =>{
            throw new Error(err);
          })
        );

};
// addAttachmentfile(file: string, id: number): Observable<any> {
//   console.log('file', file,id);

//   return this.httpClient.post(`${this.url}document/${id}`, { content: btoa(file) }).pipe(
//     catchError(err => {
//       throw new Error(err.message);
//     })
//   );
// }
addAttachmentfi(file: string, id: number): Observable<any> {
  return this.httpClient.post(`${this.url}${id}/document`, { content: btoa(file) }).pipe(
    catchError(err => {
      throw new Error(err.message);
    })
  );
}
    fromServerModel(json: never): Candidate {
          return json;
    };
    toServerModel(entity:Candidate):any{
      if(!entity.id){
       return{
         name: entity.name,
         phone: entity.phone,
         email:entity.email
       };
      }else{
       return {
        id: entity.id,
        name: entity.name,
        phone: entity.phone,
        email:entity.email,
        documentId: entity.documentId,
       };
      }
     };

}
