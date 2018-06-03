import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import{RouterModule,Routes} from '@angular/router';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { UserInfoComponent } from './components/user-info/user-info.component';
import { NavigationComponent } from './navigation/navigation.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

import {UserserviceService} from './sharedservice/userservice.service'

const appRoutes: Routes = [
  { path: 'home', component: HomeComponent }, 
  { path: 'login', component: UserInfoComponent }, 
];

@NgModule({
  declarations: [
    AppComponent,
    UserInfoComponent,
    NavigationComponent,
    HomeComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(
      appRoutes      
    )
  ],
  providers: [UserserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
