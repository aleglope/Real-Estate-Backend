import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GLOBAL } from '../environments/global';
import { Inmueble } from '../models/entity';

@Injectable({
  providedIn: 'root',
})
export class InmuebleService {
  url: string = GLOBAL.url;

  constructor(private _http: HttpClient) {}

  /* PARA LA ADMINISTRACION*/
  getInmuebles(): Observable<Inmueble[]> {
    return this._http.get<Inmueble[]>(this.url + 'inmuebles');
  }

  /* PARA LA PORTADA*/
  getInmueblesActivos(): Observable<Inmueble[]> {
    return this._http.get<Inmueble[]>(this.url + 'inmuebles-activos');
  }

  /* PARA LA PORTADA*/
  getInmueblesPortada(): Observable<Inmueble[]> {
    return this._http.get<Inmueble[]>(this.url + 'inmuebles-portada');
  }
  /* PARA LA VENTA*/
  addInmueble(inmueble: Inmueble): Observable<Inmueble> {
    return this._http.post<Inmueble>(this.url + 'inmueble', inmueble);
  }

  getInmueble(id: number): Observable<Inmueble> {
    return this._http.get<Inmueble>(this.url + 'inmueble/' + id);
  }

  updateInmueble(inmueble: Inmueble): Observable<Inmueble> {
    return this._http.put<Inmueble>(this.url + 'inmueble', inmueble);
  }
}
