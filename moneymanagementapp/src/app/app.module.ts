import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'; 
import { AppComponent } from './app.component';
import { AppUsersComponent } from './appUsers/appUsers.component';
import { UserLoginsComponent } from './userLogins/userLogins.component';
import { RouterModule,Routes } from '@angular/router';
import { CreateAccountComponent } from './create-account/create-account.component';

const routes:Routes=[
  { path: '',component:UserLoginsComponent},
  {path:'appUsers',component:AppUsersComponent},
  {path:'create-account',component:CreateAccountComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    AppUsersComponent,
    UserLoginsComponent,
    CreateAccountComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [AppUsersComponent,UserLoginsComponent],        
  bootstrap: [AppComponent]
})
export class AppModule { }
