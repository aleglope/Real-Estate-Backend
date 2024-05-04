import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ErrorComponent } from './components/error/error.component';
import { ListTipoComponent } from './components/list-tipo/list-tipo.component';
import { AddTipoComponent } from './components/add-tipo/add-tipo.component';
import { EditTipoComponent } from './components/edit-tipo/edit-tipo.component';
import { ListProvinciaComponent } from './components/list-provincia/list-provincia.component';
import { EditProvinciaComponent } from './components/edit-provincia/edit-provincia.component';
import { AddProvinciaComponent } from './components/add-provincia/add-provincia.component';
import { EditPoblacionComponent } from './components/edit-poblacion/edit-poblacion.component';
import { AddPoblacionComponent } from './components/add-poblacion/add-poblacion.component';
import { ListPoblacionComponent } from './components/list-poblacion/list-poblacion.component';
import { ListInmuebleComponent } from './components/list-inmueble/list-inmueble.component';
import { AddInmuebleComponent } from './components/add-inmueble/add-inmueble.component';
import { EditInmuebleComponent } from './components/edit-inmueble/edit-inmueble.component';
import { AddImagenComponent } from './components/add-imagen/add-imagen.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'add-imagen/:id', component: AddImagenComponent },
  { path: 'list-home', component: ListTipoComponent },
  { path: 'list-tipo', component: ListTipoComponent },
  { path: 'add-tipo', component: AddTipoComponent },
  { path: 'edit-tipo/:id', component: EditTipoComponent },
  { path: 'list-provincia', component: ListProvinciaComponent },
  { path: 'add-provincia', component: AddProvinciaComponent },
  { path: 'edit-provincia/:id', component: EditProvinciaComponent },
  { path: 'list-poblacion', component: ListPoblacionComponent },
  { path: 'add-poblacion', component: AddPoblacionComponent },
  { path: 'edit-poblacion/:id', component: EditPoblacionComponent },
  { path: 'list-inmueble', component: ListInmuebleComponent },
  { path: 'add-inmueble', component: AddInmuebleComponent },
  { path: 'edit-inmueble/:id', component: EditInmuebleComponent },
  { path: 'error', component: ErrorComponent },
  { path: '**', component: ErrorComponent }, //Poner siempre en la última posición!!!
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
