import { Component, OnInit } from '@angular/core';
import { CookieService } from "ngx-cookie-service";
import { HttpErrorResponse, HttpResponse } from "@angular/common/http";
import { LoginService } from "../../services/login/login.service";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private cookie : CookieService, private loginService : LoginService) { }

  ngOnInit() : void { }

  public signIn(credentials : any) : void {
    this.loginService.signIn(credentials.username, credentials.password)
      .subscribe(
      (response : HttpResponse<any>) => {
        this.cookie.set("access_token", <string>response.headers.get('access_token'));
        this.cookie.set("refresh_token", <string>response.headers.get('refresh_token'));
      },
        (error : HttpErrorResponse) => {
          alert(error.message);
        });
  }
}
