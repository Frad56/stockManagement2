import { Routes } from "@angular/router";
import { StockListComponent } from "./pages/stock-list/stock-list.component";
import { StockCreateComponent } from "./pages/stock-create/stock-create.component";


export const STOCK_ROUTES:Routes=[
 {path:'stock', component:StockListComponent },
 {path:'add-stock', component:StockCreateComponent }
]