import { MedicineModel } from "./medicine.model";


export class SalesMedicineModel{

    id!: number;
    customername!: string;
    salesdate!: Date;
    totalprice!: number;
    medicine!: MedicineModel[];



}