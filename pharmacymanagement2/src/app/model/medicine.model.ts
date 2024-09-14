import { MedicineGenericModel } from "./medicineGeneric.model";

export class MedicineModel{

    id!:number;
    name!:string;
    manufacturer!:string;
    price!:number;
    quantity!:number;
    expiryDate!:Date;
    manufacturerDate!:Date;
    stock!:number;
    image!:string;
    generic!:MedicineGenericModel;

}