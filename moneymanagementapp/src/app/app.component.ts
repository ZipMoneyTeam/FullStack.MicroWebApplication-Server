import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AppUser } from './appUser';
import { AppUserService } from './appUser.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public appUsers!: AppUser[];

  constructor(private appUserService: AppUserService) {}

  ngOnInit() {
    this.getAppUsers();
  }
  
  public getAppUsers(): void {
    this.appUserService.getAppUsers().subscribe(
      (response: AppUser[]) => {
        this.appUsers = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  
  //title = 'moneymanagementapp';
}
