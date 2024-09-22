import { ProductModule } from '../product/product.module';

export class SalesModule {
  id!: number;
  customername!: string;
  salesdate!: Date;
  totalprice!: number;
  product!: ProductModule[];
  
}
