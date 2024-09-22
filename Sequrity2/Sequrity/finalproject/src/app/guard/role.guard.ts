import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateFn, Router, RouterStateSnapshot } from '@angular/router';
import { AuthService } from '../service/auth.service';
import { map, Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class RoleGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> {
    const expectedRoles = route.data['role'] as Array<string>;

    return this.authService.currentUser$.pipe(
      map(user => {
        const userRole = this.authService.getUserRole();
        
        // Check if userRole is not null and is included in expectedRoles
        if (userRole && expectedRoles.includes(userRole)) {
          return true;
        } else {
          this.router.navigate(['/login']);
          return false;
        }
      })
    );
  }
}