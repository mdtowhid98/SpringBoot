import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map, Observable, throwError } from 'rxjs';
import { ProductModule } from '../module/product/product.module';
import { CategoryModule } from '../module/category/category.module';
import { ApiResponse } from '../module/api.response.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl: string = 'http://localhost:8087/api/product/';

 

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
    return this.httpClient.get<ProductModule[]>(`${this.baseUrl}h/searchproduct`, { params });
  }

  findProductByName(name: string): Observable<ProductModule[]> {
    const params = new HttpParams().set('name', name);
    return this.httpClient.get<ProductModule[]>(`${this.baseUrl}h/searchproductname`, { params });
  }

  getAllProducts(): Observable<ProductModule[]> {
    return this.httpClient.get<ProductModule[]>(this.baseUrl);
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
    formData.append('image', image);
    return this.httpClient.post<any>(`${this.baseUrl}save`, formData);
  }

  updateProductStock(productName: string, updatedStock: number): Observable<any> {
    return this.httpClient.patch(`${this.baseUrl}${productName}/stock/+id`, { stock: updatedStock });
  }
  
  
  updateProducts(product: ProductModule): Observable<ProductModule> {
    return this.httpClient.put<ProductModule>(`${this.baseUrl}"update/"${product.id}`, product);
  }
  
  deleteProduct(id: number): Observable<any> {
    return this.httpClient.delete(this.baseUrl+ "delete/"+ id);
  }
  
  // updateProduct(id: number, formData: FormData): Observable<ProductModule> {
  //   return this.httpClient.put<ProductModule>(`${this.baseUrl}update/${id}`, formData, {
  //     reportProgress: true,
  //     responseType: 'json'
  //   });
  // }

 updateProduct(id: number, product: ProductModule, image: File): Observable<any> {
    const formData = new FormData();
    formData.append('product', new Blob([JSON.stringify(product)], { type: 'application/json' }));
    formData.append('image', image);
    console.log('FormData:', formData); // Debug line to inspect FormData
    return this.httpClient.put<any>(`${this.baseUrl}update/${id}`, formData);
}

  
  getById(id: number): Observable<ProductModule> {
    return this.httpClient.get<ProductModule>(`${this.baseUrl}${id}`);
  }


  
  }
  
