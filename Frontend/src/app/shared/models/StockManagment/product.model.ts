export class Product {
    product_id?: number;
    code?: string;
    name?: string;
    unity_price?: number;
    category_id?: number;
    place_id?: number;
    stock_id?: number;

   constructor (id?:number,code?:string,name?:string,unity_price?:number,category_id?:number,place_id?:number,stock_id?:number){
    this.product_id=id;
    this.code=code;
    this.name=name;
    this.unity_price=unity_price;
    this.category_id=category_id;
    this.place_id=place_id;
    this.stock_id=stock_id;
   }
}