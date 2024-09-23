import { ProductModule } from "./product/product.module";
import { SalesModule } from "./sales/sales.module";

export class SalesProductModel{
    id!: number;
    product!: ProductModule;
    quantity!: number;
  
}