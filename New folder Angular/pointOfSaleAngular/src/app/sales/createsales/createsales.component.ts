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

  // FontAwesome icons
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
    this.loadDhanmondiBranchProducts();  // Load only Dhanmondi branch products
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
      totalprice: [{ value: '', disabled: true }],
      discount: ['', Validators.required],
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
      next: res => { this.categories = res; },
      error: error => { console.log(error); }
    });
  }

  loadDhanmondiBranchProducts() {
    this.productService.getAllDhanmondiBrancesProduct().subscribe({
      next: res => {
        this.products = res.map(product => ({ ...product, categories: product.categories || [] }));
      },
      error: error => { console.log(error); }
    });
  }

  onCategoryChange(index: number) {
    const selectedCategory = this.productsArray.at(index).get('category')?.value;
    if (!selectedCategory || !selectedCategory.id) return;

    const selectedCategoryName = selectedCategory.categoryname;
    this.productService.findProductByCategoryName(selectedCategoryName).subscribe({
      next: (products: ProductModule[]) => {
        // Filter products specifically for Dhanmondi branch if needed
        const dhanmondiProducts = products.filter(product => product.branch.branchName === 'Dhanmondi');
        this.productsArray.at(index).patchValue({
          name: '', 
          unitprice: '',
          stock: '',
          filteredProducts: dhanmondiProducts  // Only show Dhanmondi branch products
        });
      },
      error: (error) => { console.error('Error fetching products:', error); }
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
      discount: [0, Validators.required],
      stock: [{ value: 0, disabled: true }],
      expiryDate: [''] // Add the expiry date field here
    });
  
    productGroup.get('name')?.valueChanges.subscribe(name => {
      const selectedProduct = this.products.find(prod => prod.name === name);
      if (selectedProduct) {
        productGroup.patchValue({
          id: selectedProduct.id,
          unitprice: selectedProduct.unitprice,
          stock: selectedProduct.stock,
          expiryDate: selectedProduct.expiryDate // Populate expiry date from product
        });
        productGroup.get('quantity')?.enable();
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
    this.productsArray.controls.forEach((control) => {
      const quantity = Number(control.get('quantity')?.value || 0);
      const unitprice = Number(control.get('unitprice')?.value || 0);
      const discount = Number(control.get('discount')?.value || 0);
      if (quantity >= 0 && unitprice >= 0 && discount >= 0) {
        totalprice += quantity * unitprice * (1 - discount / 100);  // Apply discount correctly
      }
    });
    this.salesForm.patchValue({ totalprice });
  }

  createSales() {
    this.calculateTotalPrice();
    this.salesForm.get('totalprice')?.enable();
  
    const currentDate = new Date(); // Get the current date
  
    // Check for expired products
    const expiredProducts = this.salesForm.value.products.filter((product: any) => {
      const expiryDate = product.expiryDate ? new Date(product.expiryDate) : null; // Safely parse expiry date
      return expiryDate && expiryDate < currentDate; // Validate if expiry date is in the past
    });
  
    if (expiredProducts.length > 0) {
      alert(
        `Cannot create sales. The following products have expired:\n` +
        expiredProducts.map((prod: any) => `- ${prod.name} (Expiry Date: ${prod.expiryDate})`).join('\n')
      );
      this.salesForm.get('totalprice')?.disable();
      return; // Stop sales creation
    }
  
    // Proceed with sales creation if no expired products
    this.sale.customername = this.salesForm.value.customername;
    this.sale.salesdate = this.salesForm.value.salesdate;
    this.sale.discount = this.salesForm.value.discount;
    this.sale.totalprice = this.salesForm.value.totalprice;
  
    this.sale.product = this.salesForm.value.products.map((product: any) => {
      const originalProduct = this.products.find(p => p.id === product.id);
      if (originalProduct) {
        originalProduct.stock -= product.quantity;
        return { ...originalProduct, quantity: product.quantity };
      }
      return null;
    }).filter((product: ProductModule | null) => product !== null);
  
    this.salesService.createSales(this.sale).subscribe({
      next: res => {
        this.sale.product.forEach((prod: ProductModule) => {
          this.productService.updateProducts(prod).subscribe({
            next: () => { console.log(`Stock updated for product ID ${prod.id}`); },
            error: (error) => { console.log(error); }
          });
        });
        this.router.navigate(['invoice'], { queryParams: { sale: JSON.stringify(this.sale) } });
      },
      error: error => { console.log(error); }
    });
  }
  
  
}