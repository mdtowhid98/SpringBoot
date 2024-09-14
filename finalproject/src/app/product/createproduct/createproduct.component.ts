import { Component, OnInit } from '@angular/core';
import { ProductModule } from '../../module/product/product.module';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ProductService } from '../../service/product.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { faPlusCircle, faTag, faImage, faDollarSign, faBoxes } from '@fortawesome/free-solid-svg-icons';
import { CategoryModule } from '../../module/category/category.module';
import { CategoryService } from '../../service/category.service';

@Component({
  selector: 'app-createproduct',
  templateUrl: './createproduct.component.html',
  styleUrls: ['./createproduct.component.css'] // Note: Corrected the typo here
})
export class CreateproductComponent implements OnInit {

  image: File | null = null;
  categories: CategoryModule[] = [];
  product: ProductModule = new ProductModule();
  formValue!: FormGroup;

  faPlusCircle = faPlusCircle;
  faTag = faTag;
  faImage = faImage;
  faDollarSign = faDollarSign;
  faBoxes = faBoxes;

  constructor(
    private productService: ProductService,
    private categoryService: CategoryService,
    private router: Router,
    private httpClient: HttpClient,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.loadCategory();
    this.formValue = this.formBuilder.group({
      name: ['', Validators.required],
      photo: ['', Validators.required],
      stock: [0, [Validators.required, Validators.min(0)]],
      unitprice: [0, [Validators.required, Validators.min(0)]],
      category: [null, Validators.required], // Updated to be a single value
    });
  }

  onFileSelected(event: any) {
    this.image = event.target.files[0];
  }

  loadCategory() {
    this.categoryService.getAllCategoryForProduct().subscribe({
      next: res => {
        this.categories = res;
        console.log('Categories loaded:', this.categories); // Debug statement
      },
      error: error => {
        console.log(error);
      }
    });
  }

  // createProduct() {
  //   const selectedCategory = this.formValue.value.category;

  //   if (!selectedCategory) {
  //     alert('Please select a category.');
  //     return;
  //   }

  //   this.product.name = this.formValue.value.name;
  //   this.product.photo = this.formValue.value.photo;
  //   this.product.unitprice = this.formValue.value.unitprice;
  //   this.product.stock = this.formValue.value.stock;
  //   this.product.categories = [selectedCategory]; // Wrap in array if needed

  //   this.productService.getAllProductForSales().subscribe({
  //     next: (products) => {
  //       const existingProduct = products.find((p: ProductModule) =>
  //         p.name.toLowerCase() === this.product.name.toLowerCase()
  //       );

  //       if (existingProduct) {
  //         existingProduct.stock += this.product.stock;
  //         this.productService.updateProducts(existingProduct).subscribe({
  //           next: (res) => {
  //             console.log('Product updated', res);
  //             this.formValue.reset();
  //             this.router.navigate(['/viewproduct']);
  //           },
  //           error: (error) => {
  //             console.log(error);
  //           }
  //         });
  //       } else {
  //         this.productService.createProduct(this.product).subscribe({
  //           next: (res) => {
  //             console.log('Product created', res);
  //             this.formValue.reset();
  //             this.router.navigate(['/viewproduct']);
  //           },
  //           error: (error) => {
  //             console.log(error);
  //           }
  //         });
  //       }
  //     },
  //     error: (error) => {
  //       console.log(error);
  //     }
  //   });
  // }


  onSubmit() {
    if (this.image) {

      const product: ProductModule = {
        ...this.formValue.value,
        category: { id: this.formValue.value.category } as CategoryModule
      };

      this.productService.createProduct(product, this.image).subscribe({
        next: apiResponse => {
          if (apiResponse && apiResponse.successful) {
            console.log(apiResponse.message);
            this.formValue.reset();
            this.router.navigate(['/viewproduct']);
          }
        },
        error: err => {
          console.error('Error adding product:', err.apiResponse?.message);
        }
      });
    } else {
      alert('Please select an image.');
    }
  }

}
