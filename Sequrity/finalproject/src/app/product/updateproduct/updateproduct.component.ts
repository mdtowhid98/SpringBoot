import { Component, OnInit } from '@angular/core';
import { ProductModule } from '../../module/product/product.module';
import { ProductService } from '../../service/product.service';
import { ActivatedRoute, Router } from '@angular/router';
import { faBoxes, faDollarSign, faImage, faPlusCircle, faSave, faTag } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-updateproduct',
  templateUrl: './updateproduct.component.html',
  styleUrl: './updateproduct.component.css'
})
export class UpdateproductComponent implements OnInit{

  id: number = 0;
  product: ProductModule = new ProductModule();
  imageFile: File | null = null;

  faPlusCircle = faPlusCircle;
  faTag = faTag;
  faImage = faImage;
  faDollarSign = faDollarSign;
  faBoxes = faBoxes;
  faSave = faSave;

  constructor(
    private productService: ProductService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.params['id'];
    this.productService.getById(this.id).subscribe({
      next: res => {
        this.product = res;
        console.log(this.product);
      },
      error: error => {
        console.log('Error fetching product:', error);
      }
    });
  }

  onFileChange(event: any) {
    const file = event.target.files[0];
    if (file) {
      this.imageFile = file;
    }
  }

  updateProduct() {
    if (!this.imageFile) {
        console.error("No image file selected");
        return; // Exit if no file is selected
    }

    console.log('Product to update:', this.product); // Debug line to check product data

    this.productService.updateProduct(this.id, this.product, this.imageFile).subscribe({
        next: res => {
            console.log('Product updated successfully:', res);
            this.router.navigate(['/viewproduct']);
        },
        error: error => {
            console.error('Error updating product:', error);
        }
    });
}


}