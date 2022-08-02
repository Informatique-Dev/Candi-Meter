import { Company } from "../../company/models/company";

export interface Employee{
  id:number;
  name:string;
  company:Company;
}
