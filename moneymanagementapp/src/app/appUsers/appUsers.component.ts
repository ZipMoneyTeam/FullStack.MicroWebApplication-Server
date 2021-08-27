import { Component, OnInit } from '@angular/core';
import { AppUser } from '../appUser';
import { AppUserService } from '../appUser.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-appUsers',
  templateUrl: './appUsers.component.html',
  styleUrls: ['./appUsers.component.css']
})
export class AppUsersComponent implements OnInit {

  public appUsers!: AppUser[];

  selectedAppUser?: AppUser;

  constructor(private appUserService: AppUserService) {}

  getname(){}

  onSelect(appUser: AppUser): void {
    this.selectedAppUser = appUser;
  }

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

}
