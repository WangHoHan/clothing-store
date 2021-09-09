import { AppComponent } from './app.component';
import { NgModule } from '@angular/core';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { CookieService } from "ngx-cookie-service";
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from '@angular/common/http';
import { MatMenuModule } from "@angular/material/menu";

@NgModule({
  declarations: [
    AppComponent,
    routingComponents
  ],
    imports: [
      AppRoutingModule,
      BrowserAnimationsModule,
      BrowserModule,
      FormsModule,
      HttpClientModule,
      MatMenuModule
    ],
  providers: [
    CookieService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
