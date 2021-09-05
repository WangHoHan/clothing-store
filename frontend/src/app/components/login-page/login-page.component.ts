import { Component, OnInit } from '@angular/core';
import {LoginService} from "../../services/login/login.service";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private loginService : LoginService) { }

  ngOnInit(): void {
  }

  public signIn(loginFormValues : any) {
    this.loginService.signIn(loginFormValues.username, loginFormValues.password);
  }
}
