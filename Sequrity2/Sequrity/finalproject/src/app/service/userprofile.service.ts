import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { UserModule } from '../module/user/user.module';

@Injectable({
  providedIn: 'root'
})
export class UserprofileService {

  baseurl="http://localhost:8087/currentuser";

  constructor(private authService: AuthService, private http: HttpClient) { }

  getUserProfile(): Observable<UserModule | null> {
    return of(this.authService.getUserProfileFromStorage());
  }

  updateUserProfile(user: UserModule): Observable<UserModule> {
    localStorage.setItem('userProfile', JSON.stringify(user));
    return this.http.put<UserModule>(`${this.baseurl}/user/${user.id}`, user); // Adjusted endpoint
  }

  getAllActiveUsers(): Observable<UserModule[]> {
    return this.http.get<UserModule[]>(`${this.baseurl}/active-users`); // Endpoint to fetch active users
  }
}