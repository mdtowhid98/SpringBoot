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
        // Ensure that each product has a categories property initialized
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
  
    const selectedCategoryName = selectedCategory.categoryname; // Assuming categoryname is the property
  
    // Fetch filtered products based on the selected category
    this.productService.findProductByCategoryName(selectedCategoryName).subscribe({
      next: (products: ProductModule[]) => {
        this.productsArray.at(index).patchValue({
          name: '', // Reset the selected product
          unitprice: '',
          stock: '',
          filteredProducts: products // Set filtered products for the current product group

          
        });
        // console.log('products: '+products);
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
      filteredProducts: [[]], // Store filtered products for each product form group
      quantity: [{ value: 0, disabled: true }, Validators.required],
      unitprice: [{ value: 0, disabled: true }],
      stock: [{ value: 0, disabled: true }],
    });

    productGroup.get('name')?.valueChanges.subscribe(name => {
      const selectedProduct = this.products.find(prod => prod.name === name);
      if (selectedProduct) {
        const oldStock = selectedProduct.stock;
        if (oldStock > 0) {
          productGroup.patchValue({
            id: selectedProduct.id,  // Set the id here, which is a string
            unitprice: selectedProduct.unitprice,
            stock: oldStock // Set the current stock
          });
          productGroup.get('quantity')?.enable(); // Enable quantity input if stock is available
        } else {
          alert(`The product ${selectedProduct.name} is out of stock!`);
          productGroup.patchValue({
            id: selectedProduct.id,
            unitprice: selectedProduct.unitprice,
            stock: oldStock,
            quantity: 0 // Reset quantity to 0
          });
          productGroup.get('quantity')?.disable(); // Disable quantity input if out of stock
        }
        this.calculateTotalPrice();
      }
    });

    productGroup.get('name')?.valueChanges.subscribe(name => {
      const selectedProduct = this.products.find(prod => prod.name === name);
      if (selectedProduct) {
        productGroup.patchValue({
          id: selectedProduct.id,
          unitprice: selectedProduct.unitprice,
          stock: selectedProduct.stock
        });
        productGroup.get('quantity')?.enable(); // Enable quantity input
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
    console.log('Calculated Total Price:', totalprice);
  }







  createSales() {
    this.calculateTotalPrice();

    // Enable totalprice temporarily to read its value
    this.salesForm.get('totalprice')?.enable();

    this.sale.customername = this.salesForm.value.customername;
    this.sale.salesdate = this.salesForm.value.salesdate;
    this.sale.totalprice = this.salesForm.value.totalprice;

    // Disable totalprice again if necessary
    this.salesForm.get('totalprice')?.disable();

    console.log(this.sale.totalprice + " Create");

    // Proceed with creating the sale
    this.sale.product = this.salesForm.value.products.map((product: any) => {
      const originalProduct = this.products.find(p => p.id === product.id);
      if (originalProduct) {
        originalProduct.stock -= product.quantity; // Adjust the stock based on the quantity sold
      }
      return {
        id: originalProduct?.id,
        name: originalProduct?.name,
        photo: originalProduct?.photo,
        stock: originalProduct?.stock, // Updated stock
        unitprice: originalProduct?.unitprice,
        quantity: product.quantity,
        categories: originalProduct?.categories
      };
    });

    // Create the sales order
    this.salesService.createSales(this.sale).subscribe({
      next: res => {
        // After successful creation of the sales order, update product stock
        this.sale.product.forEach(prod => {
          this.productService.updateProducts(prod).subscribe({
            next: () => {
              console.log(`Stock reduced and updated for product ID ${prod.id}`);
            },
            error: (error) => {
              console.log(error);
            }
          });
        });

        // Navigate to invoice page with sale data
        this.router.navigate(['invoice'], {
          queryParams: { sale: JSON.stringify(this.sale) }
        });
      },
      error: error => {
        console.log(error);
      }
    });
  }







}
