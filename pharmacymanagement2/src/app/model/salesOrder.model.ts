import { CustomerModel } from "./customer.model";
import { PharmacistModel } from "./pharmacist.model";

export class SalesOrderModel{


    id!:number;
    customer!:CustomerModel;
    pharmacist!:PharmacistModel;
    orderDate!:Date;
    totalAmount!:number;


}