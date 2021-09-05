import { first } from "rxjs/operators";
import { HttpClient, HttpHeaders, HttpParams, HttpResponse } from "@angular/common/http";
import { Injectable } from '@angular/core';
import {CookieService} from "ngx-cookie-service";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private apiServerUrl = 'http://localhost:8080';

  constructor(private cookie : CookieService, private http : HttpClient) { }

  public signIn(username : string, password : string) {

    let params = new HttpParams({
      fromObject: { username: username, password: password }
    });

    let httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' }),
      observe: 'response' as 'response'
    };

    return this.http.post<any>(`${this.apiServerUrl}/login`, params.toString(), httpOptions)
      .pipe(first())
      .subscribe(
        (data: HttpResponse<any>) => {
          let httpOptions1 = {
            headers: new HttpHeaders({ 'Authorization': 'Bearer ' + <string>data.headers.get('access_token')}),
            observe: 'response' as 'response'
          };
          this.http.get<any>(`${this.apiServerUrl}/user/${username}`, httpOptions1).subscribe(
            (data: HttpResponse<any>) => {
              let user_id = data.body.id;
              this.cookie.set("user_id", user_id);
            },
            error => {
            }
          );
          this.cookie.set("access_token", <string>data.headers.get('access_token'));
          this.cookie.set("refresh_token", <string>data.headers.get('refresh_token'));
        },
        error => {
        });
  }
}
