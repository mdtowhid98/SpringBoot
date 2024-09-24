import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../service/product.service';
import { faEdit, faTrash } from '@fortawesome/free-solid-svg-icons';
import { ProductModule } from '../../module/product/product.module';
import { Router } from '@angular/router';
import { UserModule } from '../../module/user/user.module';
import { AuthService } from '../../service/auth.service';
import { CategoryService } from '../../service/category.service';
import { CategoryModule } from '../../module/category/category.module';



@Component({
  selector: 'app-viewproduct',
  templateUrl: './viewproduct.component.html',
  styleUrls: ['./viewproduct.component.css']
})
export class ViewproductComponent implements OnInit {


  userRole: string | null = '';
  currentUser: UserModule | null = null;
  categories: CategoryModule[] = [];
  products: ProductModule[] = [];
  selectedCategory: string = '';

  faEdit = faEdit;
  faTrash = faTrash;

  constructor(
    private productService: ProductService,
    protected authService: AuthService,
    private router: Router,
    private categoryService: CategoryService
  ) { }

  ngOnInit(): void {
    this.getAllCategory();
    this.getAllProducts(); // Ensure products are loaded on initialization

    this.authService.currentUser$.subscribe(user => {
      this.currentUser = user;
    });
  }

  // Method to filter or perform action based on selected category
  filterByCategory(event: Event) {
    const target = event.target as HTMLSelectElement; // Cast event.target to HTMLSelectElement
    const selectedValue = target.value; // Access the value property
    this.selectedCategory = selectedValue; // Set the selected category

    // Call appropriate method based on category selection
    if (this.selectedCategory) {
      this.loadProductsByCategory(this.selectedCategory); // Load products for selected category
    } else {
      this.getAllProducts(); // Load all products if no category is selected
    }
  }

  loadProductsByCategory(categoryName: string) {
    this.productService.findProductByCategoryName(categoryName).subscribe(
      res => {
        this.products = res;
        console.log(this.products);
      },
      err => {
        console.log(err);
      }
    );
  }

  getAllProducts() {
    this.productService.getAllProductForSales().subscribe(
      res => {
        this.products = res;
        console.log(this.products);
      },
      err => {
        console.log(err);
      }
    );
  }

  getAllCategory() {
    this.categoryService.getAllCategory().subscribe(
      res => {
        this.categories = res;
        console.log(this.categories);
      },
      err => {
        console.log(err);
      }
    );
  }

     // Delete method
     deleteProduct(id: number) {
      if (confirm('Are you sure you want to delete this pharmacist?')) {
        this.productService.deleteProduct(id).subscribe({
          next: () => {
            // Refresh the generics list after successful deletion
            this.getAllProducts();
            this.router.navigate(['/viewproduct'])
          },
          error: (error) => {
            console.log('Error deleting product', error);
          }
        });
      }
    }

  updateProduct(id: number): void {
    this.router.navigate(['updateProduct', id]);
  }



}
