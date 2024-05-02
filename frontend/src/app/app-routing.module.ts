import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ErrorComponent } from './components/error/error.component';
import { ListTipoComponent } from './components/list-tipo/list-tipo.component';
import { AddTipoComponent } from './components/add-tipo/add-tipo.component';
import { EditTipoComponent } from './components/edit-tipo/edit-tipo.component';
import { EditProvinciaComponent } from './components/edit-provincia/edit-provincia.component';
import { AddProvinciaComponent } from './components/add-provincia/add-provincia.component';

const routes: Routes = [

  {path:"",component:HomeComponent},
  {path:"home",component:HomeComponent},
  {path:"list-home",component:ListTipoComponent},
  {path:"list-tipo",component:ListTipoComponent},
  {path:"add-tipo",component:AddTipoComponent},
  {path:"edit-tipo/:id",component:EditTipoComponent},
  {path:"list-provincia",component:EditProvinciaComponent},
  {path:"add-provincia",component:AddProvinciaComponent},
  {path:"edit-provincia/:id",component:EditProvinciaComponent},
  {path:"error",component:ErrorComponent},
  {path:"**",component:ErrorComponent} //Poner siempre en la última posición!!!

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
