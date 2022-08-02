import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { ResourceService } from "src/app/core/services/config/resource.service";
import { Employee } from "./models/employee";
@Injectable({
  providedIn: 'root'
})
export class EmployeeRepository extends ResourceService<Employee>{

    constructor(httpClient: HttpClient) {
    super(httpClient);
  }
  getResourceUrl(): string {
    return 'employee'
  }

  toServerModel(entity: Employee) {
    if (!entity.id) {
      return {
        name: entity.name,
      }
    }
    else {
      return {
        id: entity.id,
        name: entity.name,
      }
    }
  }
}
