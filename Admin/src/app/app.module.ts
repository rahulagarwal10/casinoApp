import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AdminbarComponent } from './adminbar/adminbar.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { UserlistComponent } from './userlist/userlist.component';
import { RouterModule, Routes } from '@angular/router';
import {CustomerService} from "./customer.service";
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {RechargeComponent} from "./userlist/recharge/recharge.component";


const appRoutes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'home', component: HomeComponent},
  { path: 'register',component: RegisterComponent },
  { path: 'userlist',component: UserlistComponent },


];
@NgModule({
  declarations: [
    AppComponent,
    AdminbarComponent,
    HomeComponent,
    RegisterComponent,
    UserlistComponent,
    RechargeComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    ),
    HttpModule,
    FormsModule
  ],
  providers: [CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
