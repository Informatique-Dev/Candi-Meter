import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map, Observable } from 'rxjs';
import { Response } from 'src/app/domain/candidate/models/response';
import { SettingsService } from './settings.service';


@Injectable({
  providedIn: 'root'
})
export abstract class ResourceService<T> {
  protected readonly APIUrl = SettingsService.configurationEnvironment.api.baseUrl + this.getResourceUrl();

  protected constructor(protected httpClient: HttpClient) {}

  abstract getResourceUrl(): string;

  toServerModel(entity: T): any {
    return entity;
  }

  fromServerModel(json: any): T {
    return json;
  }
  get(id: string | number): Observable<T> {
    return this.httpClient.get<T>(`${this.APIUrl}/${id}`).pipe(
      map(json => this.fromServerModel(json)),
      catchError(err => {
        throw new Error(err.message);
      })
    );
  }
  getListById(url: string, p: {} = {}): Observable<Response<any>> {
    const params = new HttpParams({ fromObject: p });
    return this.httpClient.get<Response<any>>(`${this.APIUrl}/${url}?${params.toString()}`).pipe(
      map(list => list),
      catchError(err => {
        throw new Error(err.message);
      })
    );
  }
  getList(p: {} = { page: 0, size: 30 }): Observable<Response<T>> {
    const params = new HttpParams({ fromObject: p });
    return this.httpClient.get<Response<T>>(`${this.APIUrl}?${params.toString()}`).pipe(
      map(list => list),
      catchError(err => {
        throw new Error(err.message);
      })
    );
  }
  add(resource: T):Observable<any> {
    return this.httpClient.post(`${this.APIUrl}`,this.toServerModel(resource)).pipe(
      catchError(err=>{
        throw new Error(err.message);
      })
    )
  }
  addAttachment(file: string, id: number): Observable<any> {
    return this.httpClient.post(`${this.APIUrl}/${id}/document`, { content: btoa(file) }).pipe(
      catchError(err => {
        throw new Error(err.message);
      })
    );
  }

  update(resource:T): Observable<any> {
    // @ts-ignore
    return this.httpClient.put(`${this.APIUrl}/${resource.id}`, this.toServerModel(resource)).pipe(
      catchError(err => {
        throw new Error(err.message);
      })
    );
  }

  delete(id: string | number): Observable<any> {
    return this.httpClient.delete(`${this.APIUrl}/${id}`).pipe(
      catchError(err => {
        throw new Error(err.message);
      })
    );
  }



}
