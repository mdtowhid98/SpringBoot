import { Component, OnInit } from '@angular/core';
import { UserModule } from '../../module/user/user.module';
import { UserprofileService } from '../../service/userprofile.service';
import { Router } from '@angular/router';
import { faUser, faUserCircle, faEnvelope, faImage, faTag, faSpinner } from '@fortawesome/free-solid-svg-icons'; // Import icons

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrl: './userprofile.component.css'
})
export class UserprofileComponent implements OnInit{

  activeUsers: UserModule[] = [];

  constructor(private userprofileService: UserprofileService) {}

  ngOnInit(): void {
    this.loadActiveUsers();
  }

  loadActiveUsers(): void {
    this.userprofileService.getAllActiveUsers().subscribe(
      (users) => {
        this.activeUsers = users;
      },
      (error) => {
        console.error('Error fetching active users', error);
      }
    );
  }
}