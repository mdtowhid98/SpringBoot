import { ProductModule } from '../product/product.module';
import { SalesProductModel } from '../salesProduct.model';

export class SalesModule {
  id!: number;
  customername!: string;
  salesdate!: Date;
  totalprice!: number;
  salesProducts!: SalesProductModel[];
  
}
