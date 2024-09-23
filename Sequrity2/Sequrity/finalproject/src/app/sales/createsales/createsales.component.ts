import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators } from '@angular/forms';
import { ProductService } from '../../service/product.service';
import { SalesService } from '../../service/sales.service';
import { CategoryService } from '../../service/category.service';
import { ActivatedRoute, Router } from '@angular/router';
import { faUser, faCalendarAlt, faBox, faSortNumericDown, faDollarSign, faWarehouse, faTrash, faPlus, faCartPlus, faSave, faTags } from '@fortawesome/free-solid-svg-icons';
import { ProductModule } from '../../module/product/product.module';
import { SalesModule } from '../../module/sales/sales.module';
import { CategoryModule } from '../../module/category/category.module';
import { Subscription } from 'rxjs';
import { debounceTime } from 'rxjs/operators';
import { SalesProductModel } from '../../module/salesProduct.model';

@Component({
  selector: 'app-createsales',
  templateUrl: './createsales.component.html',
  styleUrls: ['./createsales.component.css']
})
export class CreatesalesComponent implements OnInit, OnDestroy {

  products: ProductModule[] = [];
  salesForm!: FormGroup;
  sale: SalesModule = new SalesModule();
  categories: CategoryModule[] = [];
  subscriptions: Subscription = new Subscription();
  filteredProducts: ProductModule[] = [];

  faUser = faUser;
  faCalendarAlt = faCalendarAlt;
  faBox = faBox;
  faSortNumericDown = faSortNumericDown;
  faDollarSign = faDollarSign;
  faWarehouse = faWarehouse;
  faTrash = faTrash;
  faPlus = faPlus;
  faCartPlus = faCartPlus;
  faSave = faSave;
  faTags = faTags;

  constructor(
    private productService: ProductService,
    private salesService: SalesService,
    private categoryService: CategoryService,
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.loadCategories();
    this.loadProduct();
    this.initSalesForm();
  }

  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
  }

  private initSalesForm() {
    const currentDate = new Date().toISOString().substring(0, 10); // Format as YYYY-MM-DD
    this.salesForm = this.formBuilder.group({
      customername: ['', Validators.required],
      salesdate: [currentDate, Validators.required],
      products: this.formBuilder.array([]),
      totalprice: [{ value: '', disabled: true }]
    });

    this.addProduct(); // Add initial product form group
    this.subscriptions.add(
      this.salesForm.get('products')?.valueChanges.pipe(debounceTime(300)).subscribe(() => {
        this.calculateTotalPrice();
      })
    );
  }

  get productsArray(): FormArray {
    return this.salesForm.get('products') as FormArray;
  }

  loadCategories() {
    this.categoryService.getAllCategory().subscribe({
      next: res => {
        this.categories = res;
      },
      error: error => {
        console.log(error);
      }
    });
  }

  loadProduct() {
    this.productService.getAllProductForSales().subscribe({
      next: res => {
        this.products = res.map(product => ({
          ...product,
          categories: product.categories || []  // Ensure categories is an array
        }));
      },
      error: error => {
        console.log(error);
      }
    });
  }

  onCategoryChange(index: number) {
    const selectedCategory = this.productsArray.at(index).get('category')?.value;

    if (!selectedCategory || !selectedCategory.id) {
      console.error('No category selected or category ID is undefined');
      return;
    }

    const selectedCategoryName = selectedCategory.categoryname;

    this.productService.findProductByCategoryName(selectedCategoryName).subscribe({
      next: (products: ProductModule[]) => {
        this.productsArray.at(index).patchValue({
          name: '', // Reset the selected product
          unitprice: '',
          stock: '',
          filteredProducts: products // Set filtered products for the current product group
        });
      },
      error: (error) => {
        console.error('Error fetching products:', error);
      }
    });
  }

  addProduct() {
    const productGroup = this.formBuilder.group({
      id: [0],
      category: ['', Validators.required],
      name: ['', Validators.required],
      filteredProducts: [[]],
      quantity: [{ value: 0, disabled: true }, Validators.required],
      unitprice: [{ value: 0, disabled: true }],
      stock: [{ value: 0, disabled: true }]
    });

    productGroup.get('name')?.valueChanges.subscribe(name => {
      const selectedProduct = this.products.find(prod => prod.name === name);
      if (selectedProduct) {
        productGroup.patchValue({
          id: selectedProduct.id,
          unitprice: selectedProduct.unitprice,
          stock: selectedProduct.stock
        });
        productGroup.get('quantity')?.enable();

        productGroup.get('quantity')?.valueChanges.subscribe(quantity => {
          const validQuantity = quantity ?? 0; // Ensure quantity is not null or undefined
        
          if (validQuantity > selectedProduct.stock) {
            alert(`The quantity entered exceeds the available stock of ${selectedProduct.stock} for ${selectedProduct.name}.`);
            productGroup.patchValue({ quantity: selectedProduct.stock });
          }
        });
      }
    });

    this.productsArray.push(productGroup);
  }

  getFilteredProducts(index: number): ProductModule[] {
    const filteredProducts = this.productsArray.at(index).get('filteredProducts')?.value;
    return Array.isArray(filteredProducts) ? filteredProducts : [];
  }

  removeProduct(index: number) {
    this.productsArray.removeAt(index);
    this.calculateTotalPrice();
  }

  calculateTotalPrice() {
    let totalprice = 0;
    this.productsArray.controls.forEach((control, index) => {
      const quantity = Number(control.get('quantity')?.value || 0);
      const unitprice = Number(control.get('unitprice')?.value || 0);

      if (quantity >= 0 && unitprice >= 0) {
        totalprice += quantity * unitprice;
      } else {
        console.warn(`Unexpected values at index ${index}: Quantity = ${quantity}, Unit Price = ${unitprice}`);
      }
    });

    this.salesForm.patchValue({ totalprice });
  }

  createSales() {
    this.calculateTotalPrice();
    this.salesForm.get('totalprice')?.enable();

    this.sale.customername = this.salesForm.value.customername;
    this.sale.salesdate = this.salesForm.value.salesdate;
    this.sale.totalprice = this.salesForm.value.totalprice;
    this.salesForm.get('totalprice')?.disable();

    this.sale.salesProducts = this.salesForm.value.products.map((product: ProductModule) => {
      const originalProduct = this.products.find(p => p.id === product.id);
      if (originalProduct) {
        originalProduct.stock -= product.quantity;

        return {
          id: originalProduct.id,
          product: originalProduct,
          quantity: product.quantity
        };
      }
      return null;
    }).filter((product: SalesProductModel | null) => product !== null);

    this.salesService.createSales(this.sale).subscribe({
      next: res => {
        this.sale.salesProducts.forEach((prod: SalesProductModel) => {
          this.productService.getById(prod.product.id).subscribe({
            next: (product: ProductModule) => {
              product.stock -= prod.quantity;
              this.productService.updateProducts(product).subscribe({
                next: () => {
                  console.log(`Stock reduced and updated for product ID ${prod.product.id}`);
                },
                error: (error) => {
                  console.error(`Error updating product ID ${prod.product.id}:`, error);
                }
              });
            },
            error: (error) => {
              console.error(`Error fetching product ID ${prod.product.id}:`, error);
            }
          });
        });
      },
      error: (error) => {
        console.error('Error creating sales order:', error);
      }
    });
  }
}
