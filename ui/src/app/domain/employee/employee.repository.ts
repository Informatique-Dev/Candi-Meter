import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { ResourceService } from "src/app/core/services/config/resource.service";
import { Emplyee } from "./model/Emplyee";
@Injectable({
    providedIn: 'root'
  })

export class EmployeeRepository extends ResourceService<Emplyee>{
    constructor(httpClient: HttpClient) {
      super(httpClient);
    }
    getResourceUrl(): string {
      return 'employee';
    }}