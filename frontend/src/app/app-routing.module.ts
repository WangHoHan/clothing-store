import { FooterComponent } from './components/footer/footer.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginPageComponent } from "./components/login-page/login-page.component";
import { NavigationComponent } from './components/navigation/navigation.component';
import { NgModule } from '@angular/core';
import { ProductPageComponent } from './components/product-page/product-page.component';
import { RouterModule, Routes } from '@angular/router';
import { ShoppingBagComponent } from "./components/shopping-bag/shopping-bag.component";

 const routes: Routes = [
   { path: '', redirectTo: '/home', pathMatch: 'full' },
   { path: 'home', component: HomePageComponent },
   { path: 'login', component: LoginPageComponent },
   { path: 'product', redirectTo: '/home', pathMatch: 'full' },
   { path: 'product/:id', component: ProductPageComponent },
   { path: 'shopping-bag', component: ShoppingBagComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [FooterComponent, HomePageComponent, LoginPageComponent, NavigationComponent,
  ProductPageComponent, ShoppingBagComponent]
