import { Routes } from "@angular/router";
import { ListSupplierComponent } from "./pages/list-supplier/list-supplier.component";
import { CreateSupplierComponent } from "./pages/create-supplier/create-supplier.component";
import { UpdateSupplierComponent } from "./pages/update-supplier/update-supplier.component";

export const SUPPLIER_ROUTES :Routes= [
    {path:'suppliers',component:ListSupplierComponent},
    {path:'add-supplier',component:CreateSupplierComponent },
    {path:'update-supplier/:id',component:UpdateSupplierComponent }
]