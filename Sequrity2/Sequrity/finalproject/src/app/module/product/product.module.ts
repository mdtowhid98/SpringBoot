import { NgModule, PipeTransform } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CategoryModule } from '../category/category.module';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class ProductModule {
  id!: number; // Use `!` to indicate that it will be defined
  name!: string;
  photo?: string; // URL or base64 string
  stock!: number;
  unitprice!: number;
  quantity!: number;
  categories!: CategoryModule[];
}



