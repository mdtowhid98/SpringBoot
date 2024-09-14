import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map, Observable, throwError } from 'rxjs';
import { ProductModule } from '../module/product/product.module';
import { CategoryModule } from '../module/category/category.module';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl: string = 'http://localhost:8087/api/product/';

  // categoriesUrl: string = "http://localhost:8087/api/category/"; 

  constructor(private httpClient: HttpClient) { }

  // getProduct(): Observable<ProductModule[]> {
  //   return this.httpClient.get<ProductModule[]>(this.baseUrl+"h/searchproduct").pipe(
  //     map(products => 
  //       products.map(product => ({
  //         ...product,
  //         category: Array.isArray(product.categories) ? product.categories : [product.categories]
  //       }))
  //     )
  //   );
  // }


  findProductByCategoryName(categoryName: string): Observable<ProductModule[]> {
    const params = new HttpParams().set('categoryName', categoryName);
    // Correctly append the endpoint to baseUrl
    return this.httpClient.get<ProductModule[]>(`${this.baseUrl}h/searchproduct`, { params });
  }


  getAllProductForSales():Observable<ProductModule[]>{

    return this.httpClient.get<ProductModule[]>(this.baseUrl);
   
  
  }
 
  private handleError(error:any){
  console.error('An error occurred:',error);
  return throwError(()=>new Error('test'));
  
  }
  
  createProduct(product: ProductModule, image: File): Observable<any> {

    const formData = new FormData();

    formData.append('product', new Blob([JSON.stringify(product)], { type: 'application/json' }));

    // Append image file
    formData.append('image', image);

    return this.httpClient.post<any>(this.baseUrl + "save", formData);

  }


  
  
  updateProducts(product: ProductModule): Observable<ProductModule> {
    return this.httpClient.put<ProductModule>(`${this.baseUrl}/${product.id}`, product);
  }
  
  deleteProduct(id: string): Observable<any> {
    return this.httpClient.delete(this.baseUrl + '/' + id);
  }
  
  updateProduct(id: string, product: ProductModule): Observable<any> {
    return this.httpClient.put(this.baseUrl + '/' + id, product);
  
  }
  
  
  getById(id: string): Observable<any> {
  
    return this.httpClient.get(this.baseUrl + "/" + id);
  }

//  getCategories(): Observable<CategoryModule[]> {
//   return this.httpClient.get<CategoryModule[]>(this.categoriesUrl);
// }
  
  
  }
  
