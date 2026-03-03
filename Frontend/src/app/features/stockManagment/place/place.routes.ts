import { Routes } from "@angular/router";
import { PlaceListComponent } from "./pages/place-list/place-list.component";
import { PlaceCreateComponent } from "./pages/place-create/place-create.component";

export const PLACE_ROUTES:Routes = [
    
    { path:'places', component :PlaceListComponent},
    {path:'add-place',component:PlaceCreateComponent}
];