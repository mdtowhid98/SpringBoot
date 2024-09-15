import { MedicineGenericModel } from "./medicineGeneric.model";

export class MedicineModel{

    id!:number;
    name!:string;
    manufacturer!:string;
    price!:number;
    quantity!:number;
    expiryDate!:Date;
    unitPrice!:number;
    manufacturerDate!:Date;
    stock!:number;
    image!:string;
    generic!:MedicineGenericModel;

}