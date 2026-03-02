import { Routes } from '@angular/router';

export const routes: Routes = [

    {path:'',redirectTo: 'login', pathMatch:'full'},
    {path:'', loadChildren:() =>
import('./auth/auth.routes').then(m => m.authRoutes)},
{path:'', loadChildren:() =>
import('./features/stockManagment/product/product.routes').then(m => m.PRODUCT_ROUTES)},
{path:'categorys', loadChildren:() =>
import('./features/stockManagment/category/category.routes').then(m => m.CATEGORY_ROUTES)},
];
