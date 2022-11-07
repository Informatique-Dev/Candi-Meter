import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { ResourceService } from "src/app/core/services/config/resource.service";
import { emplyee } from "./model/emplyee";
@Injectable({
    providedIn: 'root'
  })

export class EmployeeRepository extends ResourceService<emplyee>{
    constructor(httpClient: HttpClient) {
      super(httpClient);
    }
    getResourceUrl(): string {
      return 'employee';
    }}