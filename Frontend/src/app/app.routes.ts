import { Routes } from '@angular/router';

export const routes: Routes = [

    {path:'',redirectTo: 'login', pathMatch:'full'},
    {path:'', loadChildren:() =>
import('./auth/auth.routes').then(m => m.authRoutes)},
{path:'', loadChildren:() =>
import('./features/stockManagment/product/product.routes').then(m => m.PRODUCT_ROUTES)},

{path:'categorys', loadChildren:() =>
import('./features/stockManagment/category/category.routes').then(m => m.CATEGORY_ROUTES)},

{path:'places', loadChildren:() =>import('./features/stockManagment/place/place.routes').then(m => m.PLACE_ROUTES)},

{path:'stocks', loadChildren:() =>import('./features/stockManagment/stock/stock.routes').then(m => m.STOCK_ROUTES)},

{path:'suppliers', loadChildren:() =>import('./features/supplierManagement/supplier/supplier.routes').then(m => m.SUPPLIER_ROUTES)},
{path:'product-suppliers', loadChildren:() =>import('./features/supplierManagement/productSupplier/productSupplier.routes').then(m => m.PRODUCT_SUPPLIER_ROUTES)},
];
