import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserLogin } from './userLogin';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserLoginService {
  private apiServerUrl = environment.apiBaseUrl;


  constructor(private http: HttpClient) { }

  public getUserLogins(): Observable<UserLogin[]> {
    return this.http.get<UserLogin[]>(`${this.apiServerUrl}/member-controller/readAll`);
  }

  public createUserLogins(userLogin: UserLogin): Observable<UserLogin> {
    return this.http.post<UserLogin>(`${this.apiServerUrl}/member-controller/create`, userLogin);
  }

  public updateUserLogins(userLogin: UserLogin): Observable<UserLogin> {
    return this.http.put<UserLogin>(`${this.apiServerUrl}/member-controller/update`, userLogin);
  }

  public deleteUserLogins(userLoginId: number): Observable<UserLogin> {
    return this.http.delete<UserLogin>(`${this.apiServerUrl}/member-controller/delete/${userLoginId}`);
  }




}
