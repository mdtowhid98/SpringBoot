import { Role } from "./role.model";
import { Token } from "./token.model";

export class User {
    id!: number;
    name!: string;
    email!: string;
    password!: string;
    cell!: string;
    address!: string;
    dob!: Date;
    gender!: string;
    image!: string;
    active!: boolean;
    lock!: boolean;
    role!: Role;
  
    tokens!: Token[];
  
    
  }