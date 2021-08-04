 import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from "./components/home-page/home-page.component";
 import {ProductPageComponent} from "./components/product-page/product-page.component";

 const routes: Routes = [
   { path: '',  component: HomePageComponent },
   { path: 'home', component: HomePageComponent },
   { path: 'product/:id', component: ProductPageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [HomePageComponent, ProductPageComponent]
