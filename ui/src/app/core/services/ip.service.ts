import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";




@Injectable({
  providedIn: 'root'
})
export class IpServiceService {
  constructor(private http: HttpClient) {}
  getIPAddress(): Observable<{ ip: string }> {
    return this.http.get<{ ip: string }>('http://api.ipify.org/?format=json');
  }
}
