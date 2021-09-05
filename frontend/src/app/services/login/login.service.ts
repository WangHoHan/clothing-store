import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams, HttpResponse} from "@angular/common/http";
import {first} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private apiServerUrl = 'http://localhost:8080';

  constructor(private http : HttpClient) { }

  public signIn(email : string, password : string) {

    let params = new HttpParams({
      fromObject: { email: email, password: password },
    });

    let httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' }),
    };

    return this.http.post<any>(`${this.apiServerUrl}/login`, params.toString(), httpOptions)
      .pipe(first())
      .subscribe(
        (data: HttpResponse<any>) => {
          console.log(data.headers.get('access_token'));
          console.log("data.headers.get('authorization')");
        },
        error => {
        });
  }
}
