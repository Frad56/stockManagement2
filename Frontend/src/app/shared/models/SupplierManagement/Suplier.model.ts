export class Supplier {

    supplier_id!: number;
    company_name! :String  ;
    contact_name!: String;
    phone_number!: String;
    fax!:String  ;
    email!:String  ;
    address!:String  ;
    city!: String;
    postal_code!: String;
    country!: String;
   // List<Long> productIds;

   constructor(supplier_id :number, company_name: String, contact_name: String, phone_number: String, fax: String, email: String, address: String, city: String, postal_code: String, country: String) {
    this.supplier_id = supplier_id;
    this.company_name = company_name;
    this.contact_name = contact_name;
    this.phone_number = phone_number;
    this.fax = fax;
    this.email = email;
    this.address = address;
    this.city = city;
    this.postal_code = postal_code;
    this.country = country;
   }
 }