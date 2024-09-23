import { MedicineGenericModel } from "./medicineGeneric.model";

export class MedicineModel{

    id!:number;
    name!:string;
    manufacturer!:string;
    price!:number;
    quantity!:number;
    expiryDate!:Date;
    manufacturerDate!:Date;
    image!:string;
    generic!:MedicineGenericModel[];

   

}

// export interface ApiResponse {
//     successful: boolean;
//     data: {
//       medicines: MedicineModel[];
//     };
//   }

  // export interface MedicineWithGeneric extends MedicineModel {
  //   manufacturerDate: Date;
  //   image: string;
  //   genericts: string[];
  // }
  