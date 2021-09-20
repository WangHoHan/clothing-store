import { HttpClient, HttpHeaders, HttpParams, HttpResponse } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private apiServerUrl = 'http://localhost:8080';

  constructor(private http : HttpClient) { }

  public getUserId(username : string, access_token : string) : Observable<HttpResponse<any>> {

    let httpOptions = {
      headers: new HttpHeaders({ 'Authorization': 'Bearer ' + access_token}),
      observe: 'response' as 'response'
    };

    return this.http.get<number>(`${this.apiServerUrl}/user/${username}/id`, httpOptions);
  }

  public signIn(username : string, password : string) : Observable<HttpResponse<any>> {

    let params = new HttpParams({
      fromObject : { username : username, password : password }
    });

    let httpOptions = {
      headers : new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' }),
      observe : 'response' as 'response'
    };

    return this.http.post<any>(`${this.apiServerUrl}/login`, params.toString(), httpOptions);
  }
}
